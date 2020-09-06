package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.exception.BusinessException;
import cn.org.dianjiu.common.pojo.req.TBlogReq;
import cn.org.dianjiu.common.pojo.resp.TBlogResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TBlogDao;
import cn.org.dianjiu.server.entity.TBlog;
import cn.org.dianjiu.server.service.TBlogServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TBlog)表服务实现类
 *
 * @author makejava
 * @since 2020-09-05 21:29:58
 */
@Slf4j
@Service
public class TBlogServiceImpl implements TBlogServiceI {

    @Autowired
    private TBlogDao tBlogDao;

    @Override
    public TBlogResp getById(Integer id) {
        TBlogResp tBlogResp = new TBlogResp();
        TBlog tBlog = tBlogDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlog)) {
            //log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlog, tBlogResp);
        return tBlogResp;
    }

    @Override
    public TBlogResp getByEntity(TBlogReq tBlogReq) {
        TBlogResp tBlogResp = new TBlogResp();
        TBlog tBlog = new TBlog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogReq, tBlog);
        TBlog tBlog1 = tBlogDao.getByEntity(tBlog);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlog1)) {
            log.error("根据tBlogReq【" + tBlogReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogReq【" + tBlogReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlog1, tBlogResp);
        return tBlogResp;
    }

    @Override
    public List<TBlogResp> listByEntity(TBlogReq tBlogReq) {
        List<TBlogResp> list = new ArrayList<>();
        TBlog tBlog = new TBlog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogReq, tBlog);
        List<TBlog> tBlogs = tBlogDao.listByEntity(tBlog);
        if (null == tBlogs || tBlogs.isEmpty()) {
            log.error("根据tBlogReq【" + tBlogReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogReq【" + tBlogReq + "】没有查到相关记录！");
        }
        for (TBlog tBlog1 : tBlogs) {
            TBlogResp tBlogResp = new TBlogResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlog1)) {
                log.error("根据tBlogReq【" + tBlogReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tBlogReq【" + tBlogReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tBlog1, tBlogResp);
            list.add(tBlogResp);
        }
        return list;
    }

    @Override
    public List<TBlogResp> listByIds(List<Integer> ids) {
        List<TBlogResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TBlog> tBlogs = tBlogDao.listByIds(ids);
        if (null != tBlogs && !tBlogs.isEmpty()) {
            for (TBlog tBlog1 : tBlogs) {
                TBlogResp tBlogResp = new TBlogResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tBlog1)) {
                    log.error("根据ids【" + ids.toString() + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids.toString() + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tBlog1, tBlogResp);
                list.add(tBlogResp);
            }
        }
        return list;
    }

    @Override
    public int insert(TBlogReq tBlogReq) {
        TBlog tBlog = new TBlog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogReq, tBlog);
        Date date = new Date();
        tBlog.setCreateTime(date);
        tBlog.setUpdateTime(date);
        return tBlogDao.insert(tBlog);
    }

    @Override
    public int insertBatch(List<TBlogReq> list) {
        List<TBlog> tBlogs = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TBlogReq tBlogReq : list) {
            TBlog tBlog = new TBlog();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogReq, tBlog);
            tBlogs.add(tBlog);
        }
        return tBlogDao.insertBatch(tBlogs);
    }

    @Override
    public int update(TBlogReq tBlogReq) {
        TBlog tBlog = new TBlog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogReq, tBlog);
        tBlog.setUpdateTime(new Date());
        return tBlogDao.update(tBlog);
    }

    @Override
    public int updateBatch(List<TBlogReq> list) {
        List<TBlog> tBlogs = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TBlogReq tBlogReq : list) {
            TBlog tBlog = new TBlog();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogReq, tBlog);
            tBlogs.add(tBlog);
        }
        return tBlogDao.updateBatch(tBlogs);
    }

    @Override
    public int deleteById(Integer id) {
        return tBlogDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TBlogReq tBlogReq) {
        TBlog tBlog = new TBlog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogReq, tBlog);
        return tBlogDao.deleteByEntity(tBlog);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tBlogDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tBlogDao.countAll();
    }

    @Override
    public int countByEntity(TBlogReq tBlogReq) {
        TBlog tBlog = new TBlog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogReq, tBlog);
        return tBlogDao.countByEntity(tBlog);
    }

}