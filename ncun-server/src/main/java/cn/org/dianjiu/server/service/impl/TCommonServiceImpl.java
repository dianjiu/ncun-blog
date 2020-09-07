package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.TCommonReq;
import cn.org.dianjiu.common.pojo.resp.TCommonResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TCommonDao;
import cn.org.dianjiu.server.entity.TCommon;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TCommonServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TCommon)表服务实现类
 *
 * @author makejava
 * @since 2020-09-05 21:30:39
 */
@Slf4j
@Service
public class TCommonServiceImpl implements TCommonServiceI {

    @Autowired
    private TCommonDao tCommonDao;

    @Override
    public TCommonResp getById(Integer id) {
        TCommonResp tCommonResp = new TCommonResp();
        TCommon tCommon = tCommonDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommon)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tCommon, tCommonResp);
        return tCommonResp;
    }

    @Override
    public TCommonResp getByEntity(TCommonReq tCommonReq) {
        TCommonResp tCommonResp = new TCommonResp();
        TCommon tCommon = new TCommon();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommonReq, tCommon);
        TCommon tCommon1 = tCommonDao.getByEntity(tCommon);
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommon1)) {
            log.error("根据tCommonReq【" + tCommonReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tCommonReq【" + tCommonReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tCommon1, tCommonResp);
        return tCommonResp;
    }

    @Override
    public List<TCommonResp> listByEntity(TCommonReq tCommonReq) {
        List<TCommonResp> list = new ArrayList<>();
        TCommon tCommon = new TCommon();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommonReq, tCommon);
        List<TCommon> tCommons = tCommonDao.listByEntity(tCommon);
        if (null == tCommons || tCommons.isEmpty()) {
            log.error("根据tCommonReq【" + tCommonReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tCommonReq【" + tCommonReq + "】没有查到相关记录！");
        }
        for (TCommon tCommon1 : tCommons) {
            TCommonResp tCommonResp = new TCommonResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tCommon1)) {
                log.error("根据tCommonReq【" + tCommonReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tCommonReq【" + tCommonReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tCommon1, tCommonResp);
            list.add(tCommonResp);
        }
        return list;
    }

    @Override
    public List<TCommonResp> listByIds(List<Integer> ids) {
        List<TCommonResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TCommon> tCommons = tCommonDao.listByIds(ids);
        if (null != tCommons && !tCommons.isEmpty()) {
            for (TCommon tCommon1 : tCommons) {
                TCommonResp tCommonResp = new TCommonResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tCommon1)) {
                    log.error("根据ids【" + ids.toString() + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids.toString() + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tCommon1, tCommonResp);
                list.add(tCommonResp);
            }
        }
        return list;
    }

    @Override
    public int insert(TCommonReq tCommonReq) {
        TCommon tCommon = new TCommon();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommonReq, tCommon);
        Date date = new Date();
        tCommon.setCreateTime(date);
        tCommon.setUpdateTime(date);
        return tCommonDao.insert(tCommon);
    }

    @Override
    public int insertBatch(List<TCommonReq> list) {
        List<TCommon> tCommons = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TCommonReq tCommonReq : list) {
            TCommon tCommon = new TCommon();
            if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tCommonReq, tCommon);
            tCommons.add(tCommon);
        }
        return tCommonDao.insertBatch(tCommons);
    }

    @Override
    public int update(TCommonReq tCommonReq) {
        TCommon tCommon = new TCommon();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommonReq, tCommon);
        tCommon.setUpdateTime(new Date());
        return tCommonDao.update(tCommon);
    }

    @Override
    public int updateBatch(List<TCommonReq> list) {
        List<TCommon> tCommons = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TCommonReq tCommonReq : list) {
            TCommon tCommon = new TCommon();
            if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tCommonReq, tCommon);
            tCommons.add(tCommon);
        }
        return tCommonDao.updateBatch(tCommons);
    }

    @Override
    public int deleteById(Integer id) {
        return tCommonDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TCommonReq tCommonReq) {
        TCommon tCommon = new TCommon();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommonReq, tCommon);
        return tCommonDao.deleteByEntity(tCommon);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tCommonDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tCommonDao.countAll();
    }

    @Override
    public int countByEntity(TCommonReq tCommonReq) {
        TCommon tCommon = new TCommon();
        if (ObjectUtils.checkObjAllFieldsIsNull(tCommonReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tCommonReq, tCommon);
        return tCommonDao.countByEntity(tCommon);
    }

}