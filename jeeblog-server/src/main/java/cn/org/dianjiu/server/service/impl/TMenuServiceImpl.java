package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TMenuReq;
import cn.org.dianjiu.core.pojo.resp.TMenuResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TMenuDao;
import cn.org.dianjiu.server.service.TMenuServiceI;
import cn.org.dianjiu.server.entity.TMenu;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TMenu)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Slf4j
@Service
public class TMenuServiceImpl implements TMenuServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TMenuDao tMenuDao;

    public TMenuResp getById(Integer id) {
        TMenuResp tMenuResp = new TMenuResp();
        TMenu tMenu = tMenuDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenu)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tMenu,tMenuResp);
        return tMenuResp;
    }

    public TMenuResp getByEntity(TMenuReq tMenuReq) {
      TMenuResp tMenuResp = new TMenuResp();
        TMenu tMenu = new TMenu();
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tMenuReq,tMenu);
        TMenu tMenu1 = tMenuDao.getByEntity(tMenu);
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenu1)){
            log.error("根据tMenuReq【"+tMenuReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tMenu1,tMenuResp);
        return tMenuResp;
    }

    public List<TMenuResp> listByEntity(TMenuReq tMenuReq) {
        List<TMenuResp> list = new ArrayList<>();
        TMenu tMenu = new TMenu();
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tMenuReq,tMenu);
        List<TMenu> tMenus = tMenuDao.listByEntity(tMenu);
        if(null == tMenus || tMenus.isEmpty()){
            log.error("根据tMenuReq【"+tMenuReq+"】没有查到相关记录！");
            return list;
        }
        for (TMenu tMenu1 : tMenus ) {
            TMenuResp tMenuResp = new TMenuResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tMenu1)){
                log.error("根据tMenuReq【"+tMenuReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tMenu1,tMenuResp);
            list.add(tMenuResp);
        }
        return list;
    }

    public List<TMenuResp> listByIds(List<Integer> ids) {
      List<TMenuResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TMenu> tMenus  = tMenuDao.listByIds(ids);
        if(null != tMenus && !tMenus.isEmpty()){
            for (TMenu tMenu1 : tMenus ) {
                TMenuResp tMenuResp = new TMenuResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tMenu1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tMenu1,tMenuResp);
                list.add(tMenuResp);
            }
        }
        return list;
    }

    public int insert(TMenuReq tMenuReq) {
      TMenu tMenu = new TMenu();
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tMenuReq,tMenu);
        Date date = new Date();
        tMenu.setCreateTime(date);
        tMenu.setUpdateTime(date);
        return tMenuDao.insert(tMenu);
    }

    public int insertBatch(List<TMenuReq> list) {
      List<TMenu> tMenus = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TMenuReq tMenuReq : list) {
            TMenu tMenu = new TMenu();
            if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tMenuReq,tMenu);
            tMenus.add(tMenu);
        }
        return tMenuDao.insertBatch(tMenus);
    }

    public int update(TMenuReq tMenuReq) {
      TMenu tMenu = new TMenu();
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tMenuReq,tMenu);
        tMenu.setUpdateTime(new Date());
        return tMenuDao.update(tMenu);
    }

    public int updateBatch(List<TMenuReq> list) {
      List<TMenu> tMenus = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TMenuReq tMenuReq : list) {
            TMenu tMenu = new TMenu();
            if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tMenuReq,tMenu);
            tMenus.add(tMenu);
        }
        return tMenuDao.updateBatch(tMenus);
    }

    public int deleteById(Integer id) {
        return tMenuDao.deleteById(id);
    }

    public int deleteByEntity(TMenuReq tMenuReq) {
      TMenu tMenu = new TMenu();
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tMenuReq,tMenu);
        return tMenuDao.deleteByEntity(tMenu);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tMenuDao.deleteByIds(ids);
    }

    public int countAll() {
        return tMenuDao.countAll();
    }
    
    public int countByEntity(TMenuReq tMenuReq) {
      TMenu tMenu = new TMenu();
        if(ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tMenuReq,tMenu);
        return tMenuDao.countByEntity(tMenu);
    }

}