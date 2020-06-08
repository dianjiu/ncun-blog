package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TCommentBaseReq;
import cn.org.dianjiu.core.pojo.resp.TCommentBaseResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TCommentBaseDao;
import cn.org.dianjiu.server.service.TCommentBaseServiceI;
import cn.org.dianjiu.server.entity.TCommentBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TCommentBase)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Slf4j
@Service
public class TCommentBaseServiceImpl implements TCommentBaseServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TCommentBaseDao tCommentBaseDao;

    public TCommentBaseResp getById(Integer id) {
        TCommentBaseResp tCommentBaseResp = new TCommentBaseResp();
        TCommentBase tCommentBase = tCommentBaseDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBase)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tCommentBase,tCommentBaseResp);
        return tCommentBaseResp;
    }

    public TCommentBaseResp getByEntity(TCommentBaseReq tCommentBaseReq) {
      TCommentBaseResp tCommentBaseResp = new TCommentBaseResp();
        TCommentBase tCommentBase = new TCommentBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
        TCommentBase tCommentBase1 = tCommentBaseDao.getByEntity(tCommentBase);
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBase1)){
            log.error("根据tCommentBaseReq【"+tCommentBaseReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tCommentBase1,tCommentBaseResp);
        return tCommentBaseResp;
    }

    public List<TCommentBaseResp> listByEntity(TCommentBaseReq tCommentBaseReq) {
        List<TCommentBaseResp> list = new ArrayList<>();
        TCommentBase tCommentBase = new TCommentBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
        List<TCommentBase> tCommentBases = tCommentBaseDao.listByEntity(tCommentBase);
        if(null == tCommentBases || tCommentBases.isEmpty()){
            log.error("根据tCommentBaseReq【"+tCommentBaseReq+"】没有查到相关记录！");
            return list;
        }
        for (TCommentBase tCommentBase1 : tCommentBases ) {
            TCommentBaseResp tCommentBaseResp = new TCommentBaseResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBase1)){
                log.error("根据tCommentBaseReq【"+tCommentBaseReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tCommentBase1,tCommentBaseResp);
            list.add(tCommentBaseResp);
        }
        return list;
    }

    public List<TCommentBaseResp> listByIds(List<Integer> ids) {
      List<TCommentBaseResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TCommentBase> tCommentBases  = tCommentBaseDao.listByIds(ids);
        if(null != tCommentBases && !tCommentBases.isEmpty()){
            for (TCommentBase tCommentBase1 : tCommentBases ) {
                TCommentBaseResp tCommentBaseResp = new TCommentBaseResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBase1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tCommentBase1,tCommentBaseResp);
                list.add(tCommentBaseResp);
            }
        }
        return list;
    }

    public int insert(TCommentBaseReq tCommentBaseReq) {
      TCommentBase tCommentBase = new TCommentBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
        Date date = new Date();
        tCommentBase.setCreateTime(date);
        tCommentBase.setUpdateTime(date);
        return tCommentBaseDao.insert(tCommentBase);
    }

    public int insertBatch(List<TCommentBaseReq> list) {
      List<TCommentBase> tCommentBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TCommentBaseReq tCommentBaseReq : list) {
            TCommentBase tCommentBase = new TCommentBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
            tCommentBases.add(tCommentBase);
        }
        return tCommentBaseDao.insertBatch(tCommentBases);
    }

    public int update(TCommentBaseReq tCommentBaseReq) {
      TCommentBase tCommentBase = new TCommentBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
        tCommentBase.setUpdateTime(new Date());
        return tCommentBaseDao.update(tCommentBase);
    }

    public int updateBatch(List<TCommentBaseReq> list) {
      List<TCommentBase> tCommentBases = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TCommentBaseReq tCommentBaseReq : list) {
            TCommentBase tCommentBase = new TCommentBase();
            if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
            tCommentBases.add(tCommentBase);
        }
        return tCommentBaseDao.updateBatch(tCommentBases);
    }

    public int deleteById(Integer id) {
        return tCommentBaseDao.deleteById(id);
    }

    public int deleteByEntity(TCommentBaseReq tCommentBaseReq) {
      TCommentBase tCommentBase = new TCommentBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
        return tCommentBaseDao.deleteByEntity(tCommentBase);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tCommentBaseDao.deleteByIds(ids);
    }

    public int countAll() {
        return tCommentBaseDao.countAll();
    }
    
    public int countByEntity(TCommentBaseReq tCommentBaseReq) {
      TCommentBase tCommentBase = new TCommentBase();
        if(ObjectUtils.checkObjAllFieldsIsNull(tCommentBaseReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tCommentBaseReq,tCommentBase);
        return tCommentBaseDao.countByEntity(tCommentBase);
    }

}