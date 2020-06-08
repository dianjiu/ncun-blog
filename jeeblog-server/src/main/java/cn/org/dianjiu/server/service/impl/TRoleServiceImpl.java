package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TRoleReq;
import cn.org.dianjiu.core.pojo.resp.TRoleResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TRoleDao;
import cn.org.dianjiu.server.service.TRoleServiceI;
import cn.org.dianjiu.server.entity.TRole;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TRole)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Slf4j
@Service
public class TRoleServiceImpl implements TRoleServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TRoleDao tRoleDao;

    public TRoleResp getById(Integer id) {
        TRoleResp tRoleResp = new TRoleResp();
        TRole tRole = tRoleDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tRole)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tRole,tRoleResp);
        return tRoleResp;
    }

    public TRoleResp getByEntity(TRoleReq tRoleReq) {
      TRoleResp tRoleResp = new TRoleResp();
        TRole tRole = new TRole();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tRoleReq,tRole);
        TRole tRole1 = tRoleDao.getByEntity(tRole);
        if(ObjectUtils.checkObjAllFieldsIsNull(tRole1)){
            log.error("根据tRoleReq【"+tRoleReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tRole1,tRoleResp);
        return tRoleResp;
    }

    public List<TRoleResp> listByEntity(TRoleReq tRoleReq) {
        List<TRoleResp> list = new ArrayList<>();
        TRole tRole = new TRole();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tRoleReq,tRole);
        List<TRole> tRoles = tRoleDao.listByEntity(tRole);
        if(null == tRoles || tRoles.isEmpty()){
            log.error("根据tRoleReq【"+tRoleReq+"】没有查到相关记录！");
            return list;
        }
        for (TRole tRole1 : tRoles ) {
            TRoleResp tRoleResp = new TRoleResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tRole1)){
                log.error("根据tRoleReq【"+tRoleReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tRole1,tRoleResp);
            list.add(tRoleResp);
        }
        return list;
    }

    public List<TRoleResp> listByIds(List<Integer> ids) {
      List<TRoleResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TRole> tRoles  = tRoleDao.listByIds(ids);
        if(null != tRoles && !tRoles.isEmpty()){
            for (TRole tRole1 : tRoles ) {
                TRoleResp tRoleResp = new TRoleResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tRole1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tRole1,tRoleResp);
                list.add(tRoleResp);
            }
        }
        return list;
    }

    public int insert(TRoleReq tRoleReq) {
      TRole tRole = new TRole();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleReq,tRole);
        Date date = new Date();
        tRole.setCreateTime(date);
        tRole.setUpdateTime(date);
        return tRoleDao.insert(tRole);
    }

    public int insertBatch(List<TRoleReq> list) {
      List<TRole> tRoles = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TRoleReq tRoleReq : list) {
            TRole tRole = new TRole();
            if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tRoleReq,tRole);
            tRoles.add(tRole);
        }
        return tRoleDao.insertBatch(tRoles);
    }

    public int update(TRoleReq tRoleReq) {
      TRole tRole = new TRole();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleReq,tRole);
        tRole.setUpdateTime(new Date());
        return tRoleDao.update(tRole);
    }

    public int updateBatch(List<TRoleReq> list) {
      List<TRole> tRoles = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TRoleReq tRoleReq : list) {
            TRole tRole = new TRole();
            if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tRoleReq,tRole);
            tRoles.add(tRole);
        }
        return tRoleDao.updateBatch(tRoles);
    }

    public int deleteById(Integer id) {
        return tRoleDao.deleteById(id);
    }

    public int deleteByEntity(TRoleReq tRoleReq) {
      TRole tRole = new TRole();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleReq,tRole);
        return tRoleDao.deleteByEntity(tRole);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tRoleDao.deleteByIds(ids);
    }

    public int countAll() {
        return tRoleDao.countAll();
    }
    
    public int countByEntity(TRoleReq tRoleReq) {
      TRole tRole = new TRole();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleReq,tRole);
        return tRoleDao.countByEntity(tRole);
    }

}