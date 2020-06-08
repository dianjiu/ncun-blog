package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TBlogBaseReq;
import cn.org.dianjiu.core.pojo.resp.TBlogBaseResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TBlogBaseDao;
import cn.org.dianjiu.server.service.TBlogBaseServiceI;
import cn.org.dianjiu.server.entity.TBlogBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TBlogBase)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:55
 */
@Slf4j
@Service
public class TBlogBaseServiceImpl implements TBlogBaseServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TBlogBaseDao tBlogBaseDao;

    public TBlogBaseResp getById(Integer id) {
        TBlogBaseResp tBlogBaseResp = new TBlogBaseResp();
        TBlogBase tBlogBase = tBlogBaseDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBase)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tBlogBase,tBlogBaseResp);
        return tBlogBaseResp;
    }

    public TBlogBaseResp getByEntity(TBlogBaseReq tBlogBaseReq) {
      TBlogBaseResp tBlogBaseResp = new TBlogBaseResp();
        TBlogBase tBlogBase = new TBlogBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
        TBlogBase tBlogBase1 = tBlogBaseDao.getByEntity(tBlogBase);
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBase1)){
            log.error("根据tBlogBaseReq【"+tBlogBaseReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tBlogBase1,tBlogBaseResp);
        return tBlogBaseResp;
    }

    public List<TBlogBaseResp> listByEntity(TBlogBaseReq tBlogBaseReq) {
        List<TBlogBaseResp> list = new ArrayList<>();
        TBlogBase tBlogBase = new TBlogBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
        List<TBlogBase> tBlogBases = tBlogBaseDao.listByEntity(tBlogBase);
        if(null == tBlogBases || tBlogBases.isEmpty()){
            log.error("根据tBlogBaseReq【"+tBlogBaseReq+"】没有查到相关记录！");
            return list;
        }
        for (TBlogBase tBlogBase1 : tBlogBases ) {
            TBlogBaseResp tBlogBaseResp = new TBlogBaseResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBase1)){
                log.error("根据tBlogBaseReq【"+tBlogBaseReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tBlogBase1,tBlogBaseResp);
            list.add(tBlogBaseResp);
        }
        return list;
    }

    public List<TBlogBaseResp> listByIds(List<Integer> ids) {
      List<TBlogBaseResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TBlogBase> tBlogBases  = tBlogBaseDao.listByIds(ids);
        if(null != tBlogBases && !tBlogBases.isEmpty()){
            for (TBlogBase tBlogBase1 : tBlogBases ) {
                TBlogBaseResp tBlogBaseResp = new TBlogBaseResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBase1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tBlogBase1,tBlogBaseResp);
                list.add(tBlogBaseResp);
            }
        }
        return list;
    }

    public int insert(TBlogBaseReq tBlogBaseReq) {
      TBlogBase tBlogBase = new TBlogBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
        Date date = new Date();
        tBlogBase.setCreateTime(date);
        tBlogBase.setUpdateTime(date);
        return tBlogBaseDao.insert(tBlogBase);
    }

    public int insertBatch(List<TBlogBaseReq> list) {
      List<TBlogBase> tBlogBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TBlogBaseReq tBlogBaseReq : list) {
            TBlogBase tBlogBase = new TBlogBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
            tBlogBases.add(tBlogBase);
        }
        return tBlogBaseDao.insertBatch(tBlogBases);
    }

    public int update(TBlogBaseReq tBlogBaseReq) {
      TBlogBase tBlogBase = new TBlogBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
        tBlogBase.setUpdateTime(new Date());
        return tBlogBaseDao.update(tBlogBase);
    }

    public int updateBatch(List<TBlogBaseReq> list) {
      List<TBlogBase> tBlogBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TBlogBaseReq tBlogBaseReq : list) {
            TBlogBase tBlogBase = new TBlogBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
            tBlogBases.add(tBlogBase);
        }
        return tBlogBaseDao.updateBatch(tBlogBases);
    }

    public int deleteById(Integer id) {
        return tBlogBaseDao.deleteById(id);
    }

    public int deleteByEntity(TBlogBaseReq tBlogBaseReq) {
      TBlogBase tBlogBase = new TBlogBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
        return tBlogBaseDao.deleteByEntity(tBlogBase);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tBlogBaseDao.deleteByIds(ids);
    }

    public int countAll() {
        return tBlogBaseDao.countAll();
    }
    
    public int countByEntity(TBlogBaseReq tBlogBaseReq) {
      TBlogBase tBlogBase = new TBlogBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tBlogBaseReq,tBlogBase);
        return tBlogBaseDao.countByEntity(tBlogBase);
    }

}