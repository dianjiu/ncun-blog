package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TCommentReq;
import cn.org.dianjiu.common.pojo.resp.TCommentResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TCommentDao;
import cn.org.dianjiu.server.entity.TComment;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TCommentServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论操作(TComment)表服务实现类
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:07
 */
@Slf4j
@Service
public class TCommentServiceImpl implements TCommentServiceI {

    @Autowired
    private TCommentDao tCommentDao;

    @Override
    public TCommentResp getById(Integer id) {
        TCommentResp tCommentResp = new TCommentResp();
        TComment tComment = tCommentDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tComment)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tComment, tCommentResp);
        return tCommentResp;
    }

    @Override
    public TCommentResp getByEntity(TCommentReq tCommentReq) {
        TCommentResp tCommentResp = new TCommentResp();
        TComment tComment = new TComment();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommentReq, tComment);
        TComment tComment1 = tCommentDao.getByEntity(tComment);
        if (ObjectUtils.checkObjAllFieldsIsNull(tComment1)) {
            log.error("根据tCommentReq【" + tCommentReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tCommentReq【" + tCommentReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tComment1, tCommentResp);
        return tCommentResp;
    }

    @Override
    public List<TCommentResp> listByEntity(TCommentReq tCommentReq) {
        List<TCommentResp> list = new ArrayList<>();
        TComment tComment = new TComment();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommentReq, tComment);
        List<TComment> tComments = tCommentDao.listByEntity(tComment);
        if (null == tComments || tComments.isEmpty()) {
            log.error("根据tCommentReq【" + tCommentReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tCommentReq【" + tCommentReq + "】没有查到相关记录！");
        }
        for (TComment tComment1 : tComments) {
            TCommentResp tCommentResp = new TCommentResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tComment1)) {
                log.error("根据tCommentReq【" + tCommentReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tCommentReq【" + tCommentReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tComment1, tCommentResp);
            list.add(tCommentResp);
        }
        return list;
    }

    @Override
    public List<TCommentResp> listByIds(List<Integer> ids) {
        List<TCommentResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TComment> tComments = tCommentDao.listByIds(ids);
        if (null != tComments && !tComments.isEmpty()) {
            for (TComment tComment1 : tComments) {
                TCommentResp tCommentResp = new TCommentResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tComment1)) {
                    log.error("根据ids【" + ids + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tComment1, tCommentResp);
                list.add(tCommentResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TCommentResp> listByPage(PageReq<TCommentReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TCommentResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TCommentResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TCommentReq tCommentReq) {
        TComment tComment = new TComment();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommentReq, tComment);
        Date date = new Date();
        tComment.setCreatedTime(date);
        tComment.setCreatedBy("admin");
        tComment.setUpdatedTime(date);
        tComment.setUpdatedBy("admin");
        return tCommentDao.insert(tComment);
    }

    @Override
    public int insertBatch(List<TCommentReq> list) {
        List<TComment> tComments = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TCommentReq tCommentReq : list) {
            TComment tComment = new TComment();
            if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tCommentReq, tComment);
            tComments.add(tComment);
        }
        return tCommentDao.insertBatch(tComments);
    }

    @Override
    public int update(TCommentReq tCommentReq) {
        TComment tComment = new TComment();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommentReq, tComment);
        tComment.setUpdatedTime(new Date());
        return tCommentDao.update(tComment);
    }

    @Override
    public int updateBatch(List<TCommentReq> list) {
        List<TComment> tComments = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TCommentReq tCommentReq : list) {
            TComment tComment = new TComment();
            if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tCommentReq, tComment);
            tComments.add(tComment);
        }
        return tCommentDao.updateBatch(tComments);
    }

    @Override
    public int deleteById(Integer id) {
        return tCommentDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TCommentReq tCommentReq) {
        TComment tComment = new TComment();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommentReq, tComment);
        return tCommentDao.deleteByEntity(tComment);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tCommentDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tCommentDao.countAll();
    }

    @Override
    public int countByEntity(TCommentReq tCommentReq) {
        TComment tComment = new TComment();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommentReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommentReq, tComment);
        return tCommentDao.countByEntity(tComment);
    }

}
