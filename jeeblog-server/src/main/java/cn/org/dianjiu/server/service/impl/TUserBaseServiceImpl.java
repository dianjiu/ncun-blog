package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TUserBaseReq;
import cn.org.dianjiu.core.pojo.resp.TUserBaseResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TUserBaseDao;
import cn.org.dianjiu.server.service.TUserBaseServiceI;
import cn.org.dianjiu.server.entity.TUserBase;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TUserBase)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Slf4j
@Service
public class TUserBaseServiceImpl implements TUserBaseServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TUserBaseDao tUserBaseDao;

    public TUserBaseResp getById(Integer id) {
        TUserBaseResp tUserBaseResp = new TUserBaseResp();
        TUserBase tUserBase = tUserBaseDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBase)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tUserBase,tUserBaseResp);
        return tUserBaseResp;
    }

    public TUserBaseResp getByEntity(TUserBaseReq tUserBaseReq) {
      TUserBaseResp tUserBaseResp = new TUserBaseResp();
        TUserBase tUserBase = new TUserBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
        TUserBase tUserBase1 = tUserBaseDao.getByEntity(tUserBase);
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBase1)){
            log.error("根据tUserBaseReq【"+tUserBaseReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tUserBase1,tUserBaseResp);
        return tUserBaseResp;
    }

    public List<TUserBaseResp> listByEntity(TUserBaseReq tUserBaseReq) {
        List<TUserBaseResp> list = new ArrayList<>();
        TUserBase tUserBase = new TUserBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
        List<TUserBase> tUserBases = tUserBaseDao.listByEntity(tUserBase);
        if(null == tUserBases || tUserBases.isEmpty()){
            log.error("根据tUserBaseReq【"+tUserBaseReq+"】没有查到相关记录！");
            return list;
        }
        for (TUserBase tUserBase1 : tUserBases ) {
            TUserBaseResp tUserBaseResp = new TUserBaseResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tUserBase1)){
                log.error("根据tUserBaseReq【"+tUserBaseReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tUserBase1,tUserBaseResp);
            list.add(tUserBaseResp);
        }
        return list;
    }

    public List<TUserBaseResp> listByIds(List<Integer> ids) {
      List<TUserBaseResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TUserBase> tUserBases  = tUserBaseDao.listByIds(ids);
        if(null != tUserBases && !tUserBases.isEmpty()){
            for (TUserBase tUserBase1 : tUserBases ) {
                TUserBaseResp tUserBaseResp = new TUserBaseResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tUserBase1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tUserBase1,tUserBaseResp);
                list.add(tUserBaseResp);
            }
        }
        return list;
    }

    public int insert(TUserBaseReq tUserBaseReq) {
      TUserBase tUserBase = new TUserBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
        Date date = new Date();
        tUserBase.setCreateTime(date);
        tUserBase.setUpdateTime(date);
        return tUserBaseDao.insert(tUserBase);
    }

    public int insertBatch(List<TUserBaseReq> list) {
      List<TUserBase> tUserBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TUserBaseReq tUserBaseReq : list) {
            TUserBase tUserBase = new TUserBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
            tUserBases.add(tUserBase);
        }
        return tUserBaseDao.insertBatch(tUserBases);
    }

    public int update(TUserBaseReq tUserBaseReq) {
      TUserBase tUserBase = new TUserBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
        tUserBase.setUpdateTime(new Date());
        return tUserBaseDao.update(tUserBase);
    }

    public int updateBatch(List<TUserBaseReq> list) {
      List<TUserBase> tUserBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TUserBaseReq tUserBaseReq : list) {
            TUserBase tUserBase = new TUserBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
            tUserBases.add(tUserBase);
        }
        return tUserBaseDao.updateBatch(tUserBases);
    }

    public int deleteById(Integer id) {
        return tUserBaseDao.deleteById(id);
    }

    public int deleteByEntity(TUserBaseReq tUserBaseReq) {
      TUserBase tUserBase = new TUserBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
        return tUserBaseDao.deleteByEntity(tUserBase);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tUserBaseDao.deleteByIds(ids);
    }

    public int countAll() {
        return tUserBaseDao.countAll();
    }
    
    public int countByEntity(TUserBaseReq tUserBaseReq) {
      TUserBase tUserBase = new TUserBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tUserBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tUserBaseReq,tUserBase);
        return tUserBaseDao.countByEntity(tUserBase);
    }

}