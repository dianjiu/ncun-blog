package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.exception.BusinessException;
import cn.org.dianjiu.common.pojo.req.TBlogThemeReq;
import cn.org.dianjiu.common.pojo.resp.TBlogThemeResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TBlogThemeDao;
import cn.org.dianjiu.server.entity.TBlogTheme;
import cn.org.dianjiu.server.service.TBlogThemeServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TBlogTheme)表服务实现类
 *
 * @author makejava
 * @since 2020-09-05 21:30:20
 */
@Slf4j
@Service
public class TBlogThemeServiceImpl implements TBlogThemeServiceI {

    @Autowired
    private TBlogThemeDao tBlogThemeDao;

    @Override
    public TBlogThemeResp getById(Integer id) {
        TBlogThemeResp tBlogThemeResp = new TBlogThemeResp();
        TBlogTheme tBlogTheme = tBlogThemeDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogTheme)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogTheme, tBlogThemeResp);
        return tBlogThemeResp;
    }

    @Override
    public TBlogThemeResp getByEntity(TBlogThemeReq tBlogThemeReq) {
        TBlogThemeResp tBlogThemeResp = new TBlogThemeResp();
        TBlogTheme tBlogTheme = new TBlogTheme();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
        TBlogTheme tBlogTheme1 = tBlogThemeDao.getByEntity(tBlogTheme);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogTheme1)) {
            log.error("根据tBlogThemeReq【" + tBlogThemeReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogThemeReq【" + tBlogThemeReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogTheme1, tBlogThemeResp);
        return tBlogThemeResp;
    }

    @Override
    public List<TBlogThemeResp> listByEntity(TBlogThemeReq tBlogThemeReq) {
        List<TBlogThemeResp> list = new ArrayList<>();
        TBlogTheme tBlogTheme = new TBlogTheme();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
        List<TBlogTheme> tBlogThemes = tBlogThemeDao.listByEntity(tBlogTheme);
        if (null == tBlogThemes || tBlogThemes.isEmpty()) {
            log.error("根据tBlogThemeReq【" + tBlogThemeReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogThemeReq【" + tBlogThemeReq + "】没有查到相关记录！");
        }
        for (TBlogTheme tBlogTheme1 : tBlogThemes) {
            TBlogThemeResp tBlogThemeResp = new TBlogThemeResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogTheme1)) {
                log.error("根据tBlogThemeReq【" + tBlogThemeReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tBlogThemeReq【" + tBlogThemeReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tBlogTheme1, tBlogThemeResp);
            list.add(tBlogThemeResp);
        }
        return list;
    }

    @Override
    public List<TBlogThemeResp> listByIds(List<Integer> ids) {
        List<TBlogThemeResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TBlogTheme> tBlogThemes = tBlogThemeDao.listByIds(ids);
        if (null != tBlogThemes && !tBlogThemes.isEmpty()) {
            for (TBlogTheme tBlogTheme1 : tBlogThemes) {
                TBlogThemeResp tBlogThemeResp = new TBlogThemeResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tBlogTheme1)) {
                    log.error("根据ids【" + ids.toString() + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids.toString() + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tBlogTheme1, tBlogThemeResp);
                list.add(tBlogThemeResp);
            }
        }
        return list;
    }

    @Override
    public int insert(TBlogThemeReq tBlogThemeReq) {
        TBlogTheme tBlogTheme = new TBlogTheme();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
        Date date = new Date();
        tBlogTheme.setCreateTime(date);
        tBlogTheme.setUpdateTime(date);
        return tBlogThemeDao.insert(tBlogTheme);
    }

    @Override
    public int insertBatch(List<TBlogThemeReq> list) {
        List<TBlogTheme> tBlogThemes = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TBlogThemeReq tBlogThemeReq : list) {
            TBlogTheme tBlogTheme = new TBlogTheme();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
            tBlogThemes.add(tBlogTheme);
        }
        return tBlogThemeDao.insertBatch(tBlogThemes);
    }

    @Override
    public int update(TBlogThemeReq tBlogThemeReq) {
        TBlogTheme tBlogTheme = new TBlogTheme();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
        tBlogTheme.setUpdateTime(new Date());
        return tBlogThemeDao.update(tBlogTheme);
    }

    @Override
    public int updateBatch(List<TBlogThemeReq> list) {
        List<TBlogTheme> tBlogThemes = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TBlogThemeReq tBlogThemeReq : list) {
            TBlogTheme tBlogTheme = new TBlogTheme();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
            tBlogThemes.add(tBlogTheme);
        }
        return tBlogThemeDao.updateBatch(tBlogThemes);
    }

    @Override
    public int deleteById(Integer id) {
        return tBlogThemeDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TBlogThemeReq tBlogThemeReq) {
        TBlogTheme tBlogTheme = new TBlogTheme();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
        return tBlogThemeDao.deleteByEntity(tBlogTheme);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tBlogThemeDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tBlogThemeDao.countAll();
    }

    @Override
    public int countByEntity(TBlogThemeReq tBlogThemeReq) {
        TBlogTheme tBlogTheme = new TBlogTheme();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogThemeReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogThemeReq, tBlogTheme);
        return tBlogThemeDao.countByEntity(tBlogTheme);
    }

}