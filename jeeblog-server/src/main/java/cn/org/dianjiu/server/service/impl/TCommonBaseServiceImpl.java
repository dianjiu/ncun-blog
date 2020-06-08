package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TCommonBaseReq;
import cn.org.dianjiu.core.pojo.resp.TCommonBaseResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TCommonBaseDao;
import cn.org.dianjiu.server.service.TCommonBaseServiceI;
import cn.org.dianjiu.server.entity.TCommonBase;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TCommonBase)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Slf4j
@Service
public class TCommonBaseServiceImpl implements TCommonBaseServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TCommonBaseDao tCommonBaseDao;

    public TCommonBaseResp getById(Integer id) {
        TCommonBaseResp tCommonBaseResp = new TCommonBaseResp();
        TCommonBase tCommonBase = tCommonBaseDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBase)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tCommonBase,tCommonBaseResp);
        return tCommonBaseResp;
    }

    public TCommonBaseResp getByEntity(TCommonBaseReq tCommonBaseReq) {
      TCommonBaseResp tCommonBaseResp = new TCommonBaseResp();
        TCommonBase tCommonBase = new TCommonBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
        TCommonBase tCommonBase1 = tCommonBaseDao.getByEntity(tCommonBase);
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBase1)){
            log.error("根据tCommonBaseReq【"+tCommonBaseReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tCommonBase1,tCommonBaseResp);
        return tCommonBaseResp;
    }

    public List<TCommonBaseResp> listByEntity(TCommonBaseReq tCommonBaseReq) {
        List<TCommonBaseResp> list = new ArrayList<>();
        TCommonBase tCommonBase = new TCommonBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
        List<TCommonBase> tCommonBases = tCommonBaseDao.listByEntity(tCommonBase);
        if(null == tCommonBases || tCommonBases.isEmpty()){
            log.error("根据tCommonBaseReq【"+tCommonBaseReq+"】没有查到相关记录！");
            return list;
        }
        for (TCommonBase tCommonBase1 : tCommonBases ) {
            TCommonBaseResp tCommonBaseResp = new TCommonBaseResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBase1)){
                log.error("根据tCommonBaseReq【"+tCommonBaseReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tCommonBase1,tCommonBaseResp);
            list.add(tCommonBaseResp);
        }
        return list;
    }

    public List<TCommonBaseResp> listByIds(List<Integer> ids) {
      List<TCommonBaseResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TCommonBase> tCommonBases  = tCommonBaseDao.listByIds(ids);
        if(null != tCommonBases && !tCommonBases.isEmpty()){
            for (TCommonBase tCommonBase1 : tCommonBases ) {
                TCommonBaseResp tCommonBaseResp = new TCommonBaseResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBase1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tCommonBase1,tCommonBaseResp);
                list.add(tCommonBaseResp);
            }
        }
        return list;
    }

    public int insert(TCommonBaseReq tCommonBaseReq) {
      TCommonBase tCommonBase = new TCommonBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
        Date date = new Date();
        tCommonBase.setCreateTime(date);
        tCommonBase.setUpdateTime(date);
        return tCommonBaseDao.insert(tCommonBase);
    }

    public int insertBatch(List<TCommonBaseReq> list) {
      List<TCommonBase> tCommonBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TCommonBaseReq tCommonBaseReq : list) {
            TCommonBase tCommonBase = new TCommonBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
            tCommonBases.add(tCommonBase);
        }
        return tCommonBaseDao.insertBatch(tCommonBases);
    }

    public int update(TCommonBaseReq tCommonBaseReq) {
      TCommonBase tCommonBase = new TCommonBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
        tCommonBase.setUpdateTime(new Date());
        return tCommonBaseDao.update(tCommonBase);
    }

    public int updateBatch(List<TCommonBaseReq> list) {
      List<TCommonBase> tCommonBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TCommonBaseReq tCommonBaseReq : list) {
            TCommonBase tCommonBase = new TCommonBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
            tCommonBases.add(tCommonBase);
        }
        return tCommonBaseDao.updateBatch(tCommonBases);
    }

    public int deleteById(Integer id) {
        return tCommonBaseDao.deleteById(id);
    }

    public int deleteByEntity(TCommonBaseReq tCommonBaseReq) {
      TCommonBase tCommonBase = new TCommonBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
        return tCommonBaseDao.deleteByEntity(tCommonBase);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tCommonBaseDao.deleteByIds(ids);
    }

    public int countAll() {
        return tCommonBaseDao.countAll();
    }
    
    public int countByEntity(TCommonBaseReq tCommonBaseReq) {
      TCommonBase tCommonBase = new TCommonBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommonBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommonBaseReq,tCommonBase);
        return tCommonBaseDao.countByEntity(tCommonBase);
    }

}