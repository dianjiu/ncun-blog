package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogLabelReq;
import cn.org.dianjiu.common.pojo.resp.TBlogLabelResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TBlogLabelDao;
import cn.org.dianjiu.server.entity.TBlogLabel;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TBlogLabelServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章标签(TBlogLabel)表服务实现类
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:25
 */
@Slf4j
@Service
public class TBlogLabelServiceImpl implements TBlogLabelServiceI {

    @Autowired
    private TBlogLabelDao tBlogLabelDao;

    @Override
    public TBlogLabelResp getById(Integer id) {
        TBlogLabelResp tBlogLabelResp = new TBlogLabelResp();
        TBlogLabel tBlogLabel = tBlogLabelDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabel)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogLabel, tBlogLabelResp);
        return tBlogLabelResp;
    }

    @Override
    public TBlogLabelResp getByEntity(TBlogLabelReq tBlogLabelReq) {
        TBlogLabelResp tBlogLabelResp = new TBlogLabelResp();
        TBlogLabel tBlogLabel = new TBlogLabel();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
        TBlogLabel tBlogLabel1 = tBlogLabelDao.getByEntity(tBlogLabel);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabel1)) {
            log.error("根据tBlogLabelReq【" + tBlogLabelReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogLabelReq【" + tBlogLabelReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogLabel1, tBlogLabelResp);
        return tBlogLabelResp;
    }

    @Override
    public List<TBlogLabelResp> listByEntity(TBlogLabelReq tBlogLabelReq) {
        List<TBlogLabelResp> list = new ArrayList<>();
        TBlogLabel tBlogLabel = new TBlogLabel();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
        List<TBlogLabel> tBlogLabels = tBlogLabelDao.listByEntity(tBlogLabel);
        if (null == tBlogLabels || tBlogLabels.isEmpty()) {
            log.error("根据tBlogLabelReq【" + tBlogLabelReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogLabelReq【" + tBlogLabelReq + "】没有查到相关记录！");
        }
        for (TBlogLabel tBlogLabel1 : tBlogLabels) {
            TBlogLabelResp tBlogLabelResp = new TBlogLabelResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabel1)) {
                log.error("根据tBlogLabelReq【" + tBlogLabelReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tBlogLabelReq【" + tBlogLabelReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tBlogLabel1, tBlogLabelResp);
            list.add(tBlogLabelResp);
        }
        return list;
    }

    @Override
    public List<TBlogLabelResp> listByIds(List<Integer> ids) {
        List<TBlogLabelResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TBlogLabel> tBlogLabels = tBlogLabelDao.listByIds(ids);
        if (null != tBlogLabels && !tBlogLabels.isEmpty()) {
            for (TBlogLabel tBlogLabel1 : tBlogLabels) {
                TBlogLabelResp tBlogLabelResp = new TBlogLabelResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabel1)) {
                    log.error("根据ids【" + ids + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tBlogLabel1, tBlogLabelResp);
                list.add(tBlogLabelResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TBlogLabelResp> listByPage(PageReq<TBlogLabelReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TBlogLabelResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TBlogLabelResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TBlogLabelReq tBlogLabelReq) {
        TBlogLabel tBlogLabel = new TBlogLabel();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
        Date date = new Date();
        tBlogLabel.setCreatedTime(date);
        tBlogLabel.setCreatedBy("admin");
        tBlogLabel.setUpdatedTime(date);
        tBlogLabel.setUpdatedBy("admin");
        return tBlogLabelDao.insert(tBlogLabel);
    }

    @Override
    public int insertBatch(List<TBlogLabelReq> list) {
        List<TBlogLabel> tBlogLabels = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TBlogLabelReq tBlogLabelReq : list) {
            TBlogLabel tBlogLabel = new TBlogLabel();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
            tBlogLabels.add(tBlogLabel);
        }
        return tBlogLabelDao.insertBatch(tBlogLabels);
    }

    @Override
    public int update(TBlogLabelReq tBlogLabelReq) {
        TBlogLabel tBlogLabel = new TBlogLabel();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
        tBlogLabel.setUpdatedTime(new Date());
        return tBlogLabelDao.update(tBlogLabel);
    }

    @Override
    public int updateBatch(List<TBlogLabelReq> list) {
        List<TBlogLabel> tBlogLabels = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TBlogLabelReq tBlogLabelReq : list) {
            TBlogLabel tBlogLabel = new TBlogLabel();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
            tBlogLabels.add(tBlogLabel);
        }
        return tBlogLabelDao.updateBatch(tBlogLabels);
    }

    @Override
    public int deleteById(Integer id) {
        return tBlogLabelDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TBlogLabelReq tBlogLabelReq) {
        TBlogLabel tBlogLabel = new TBlogLabel();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
        return tBlogLabelDao.deleteByEntity(tBlogLabel);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tBlogLabelDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tBlogLabelDao.countAll();
    }

    @Override
    public int countByEntity(TBlogLabelReq tBlogLabelReq) {
        TBlogLabel tBlogLabel = new TBlogLabel();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogLabelReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogLabelReq, tBlogLabel);
        return tBlogLabelDao.countByEntity(tBlogLabel);
    }

}
