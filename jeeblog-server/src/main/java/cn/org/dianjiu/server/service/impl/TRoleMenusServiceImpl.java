package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TRoleMenusReq;
import cn.org.dianjiu.core.pojo.resp.TRoleMenusResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TRoleMenusDao;
import cn.org.dianjiu.server.service.TRoleMenusServiceI;
import cn.org.dianjiu.server.entity.TRoleMenus;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TRoleMenus)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Slf4j
@Service
public class TRoleMenusServiceImpl implements TRoleMenusServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TRoleMenusDao tRoleMenusDao;

    public TRoleMenusResp getById(Integer id) {
        TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
        TRoleMenus tRoleMenus = tRoleMenusDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tRoleMenus,tRoleMenusResp);
        return tRoleMenusResp;
    }

    public TRoleMenusResp getByEntity(TRoleMenusReq tRoleMenusReq) {
      TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
        TRoleMenus tRoleMenus = new TRoleMenus();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
        TRoleMenus tRoleMenus1 = tRoleMenusDao.getByEntity(tRoleMenus);
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus1)){
            log.error("根据tRoleMenusReq【"+tRoleMenusReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tRoleMenus1,tRoleMenusResp);
        return tRoleMenusResp;
    }

    public List<TRoleMenusResp> listByEntity(TRoleMenusReq tRoleMenusReq) {
        List<TRoleMenusResp> list = new ArrayList<>();
        TRoleMenus tRoleMenus = new TRoleMenus();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
        List<TRoleMenus> tRoleMenuss = tRoleMenusDao.listByEntity(tRoleMenus);
        if(null == tRoleMenuss || tRoleMenuss.isEmpty()){
            log.error("根据tRoleMenusReq【"+tRoleMenusReq+"】没有查到相关记录！");
            return list;
        }
        for (TRoleMenus tRoleMenus1 : tRoleMenuss ) {
            TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus1)){
                log.error("根据tRoleMenusReq【"+tRoleMenusReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tRoleMenus1,tRoleMenusResp);
            list.add(tRoleMenusResp);
        }
        return list;
    }

    public List<TRoleMenusResp> listByIds(List<Integer> ids) {
      List<TRoleMenusResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TRoleMenus> tRoleMenuss  = tRoleMenusDao.listByIds(ids);
        if(null != tRoleMenuss && !tRoleMenuss.isEmpty()){
            for (TRoleMenus tRoleMenus1 : tRoleMenuss ) {
                TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tRoleMenus1,tRoleMenusResp);
                list.add(tRoleMenusResp);
            }
        }
        return list;
    }

    public int insert(TRoleMenusReq tRoleMenusReq) {
      TRoleMenus tRoleMenus = new TRoleMenus();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
        Date date = new Date();
        tRoleMenus.setCreateTime(date);
        tRoleMenus.setUpdateTime(date);
        return tRoleMenusDao.insert(tRoleMenus);
    }

    public int insertBatch(List<TRoleMenusReq> list) {
      List<TRoleMenus> tRoleMenuss = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TRoleMenusReq tRoleMenusReq : list) {
            TRoleMenus tRoleMenus = new TRoleMenus();
            if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
            tRoleMenuss.add(tRoleMenus);
        }
        return tRoleMenusDao.insertBatch(tRoleMenuss);
    }

    public int update(TRoleMenusReq tRoleMenusReq) {
      TRoleMenus tRoleMenus = new TRoleMenus();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
        tRoleMenus.setUpdateTime(new Date());
        return tRoleMenusDao.update(tRoleMenus);
    }

    public int updateBatch(List<TRoleMenusReq> list) {
      List<TRoleMenus> tRoleMenuss = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TRoleMenusReq tRoleMenusReq : list) {
            TRoleMenus tRoleMenus = new TRoleMenus();
            if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
            tRoleMenuss.add(tRoleMenus);
        }
        return tRoleMenusDao.updateBatch(tRoleMenuss);
    }

    public int deleteById(Integer id) {
        return tRoleMenusDao.deleteById(id);
    }

    public int deleteByEntity(TRoleMenusReq tRoleMenusReq) {
      TRoleMenus tRoleMenus = new TRoleMenus();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
        return tRoleMenusDao.deleteByEntity(tRoleMenus);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tRoleMenusDao.deleteByIds(ids);
    }

    public int countAll() {
        return tRoleMenusDao.countAll();
    }
    
    public int countByEntity(TRoleMenusReq tRoleMenusReq) {
      TRoleMenus tRoleMenus = new TRoleMenus();
        if(ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tRoleMenusReq,tRoleMenus);
        return tRoleMenusDao.countByEntity(tRoleMenus);
    }

}