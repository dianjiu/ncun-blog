package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.core.pojo.req.TSystemLogReq;
import cn.org.dianjiu.core.pojo.resp.TSystemLogResp;
import cn.org.dianjiu.core.utils.ObjectUtils;
import cn.org.dianjiu.server.dao.TSystemLogDao;
import cn.org.dianjiu.server.service.TSystemLogServiceI;
import cn.org.dianjiu.server.entity.TSystemLog;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (TSystemLog)表服务实现类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Slf4j
@Service
public class TSystemLogServiceImpl implements TSystemLogServiceI {
    
    /**
     * 服务对象
     */
    @Autowired
    private TSystemLogDao tSystemLogDao;

    public TSystemLogResp getById(Integer id) {
        TSystemLogResp tSystemLogResp = new TSystemLogResp();
        TSystemLog tSystemLog = tSystemLogDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLog)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tSystemLog,tSystemLogResp);
        return tSystemLogResp;
    }

    public TSystemLogResp getByEntity(TSystemLogReq tSystemLogReq) {
      TSystemLogResp tSystemLogResp = new TSystemLogResp();
        TSystemLog tSystemLog = new TSystemLog();
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
            log.error("入参对象不能为空！");
            return null;
        }
        ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
        TSystemLog tSystemLog1 = tSystemLogDao.getByEntity(tSystemLog);
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLog1)){
            log.error("根据tSystemLogReq【"+tSystemLogReq+"】没有查到相关记录！");
            return null;
        }
        ObjectUtils.copyProperties(tSystemLog1,tSystemLogResp);
        return tSystemLogResp;
    }

    public List<TSystemLogResp> listByEntity(TSystemLogReq tSystemLogReq) {
        List<TSystemLogResp> list = new ArrayList<>();
        TSystemLog tSystemLog = new TSystemLog();
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
            log.error("入参对象不能为空！");
            return list;
        }
        ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
        List<TSystemLog> tSystemLogs = tSystemLogDao.listByEntity(tSystemLog);
        if(null == tSystemLogs || tSystemLogs.isEmpty()){
            log.error("根据tSystemLogReq【"+tSystemLogReq+"】没有查到相关记录！");
            return list;
        }
        for (TSystemLog tSystemLog1 : tSystemLogs ) {
            TSystemLogResp tSystemLogResp = new TSystemLogResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLog1)){
                log.error("根据tSystemLogReq【"+tSystemLogReq+"】没有查到相关记录！");
                return list;
            }
            ObjectUtils.copyProperties(tSystemLog1,tSystemLogResp);
            list.add(tSystemLogResp);
        }
        return list;
    }

    public List<TSystemLogResp> listByIds(List<Integer> ids) {
      List<TSystemLogResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return list;
        }
        List<TSystemLog> tSystemLogs  = tSystemLogDao.listByIds(ids);
        if(null != tSystemLogs && !tSystemLogs.isEmpty()){
            for (TSystemLog tSystemLog1 : tSystemLogs ) {
                TSystemLogResp tSystemLogResp = new TSystemLogResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLog1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    return list;
                }
                ObjectUtils.copyProperties(tSystemLog1,tSystemLogResp);
                list.add(tSystemLogResp);
            }
        }
        return list;
    }

    public int insert(TSystemLogReq tSystemLogReq) {
      TSystemLog tSystemLog = new TSystemLog();
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
        Date date = new Date();
        tSystemLog.setCreateTime(date);
        tSystemLog.setUpdateTime(date);
        return tSystemLogDao.insert(tSystemLog);
    }

    public int insertBatch(List<TSystemLogReq> list) {
      List<TSystemLog> tSystemLogs = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            return 0;
        }
        for (TSystemLogReq tSystemLogReq : list) {
            TSystemLog tSystemLog = new TSystemLog();
            if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
                log.error("执行批量插入的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
            tSystemLogs.add(tSystemLog);
        }
        return tSystemLogDao.insertBatch(tSystemLogs);
    }

    public int update(TSystemLogReq tSystemLogReq) {
      TSystemLog tSystemLog = new TSystemLog();
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
        tSystemLog.setUpdateTime(new Date());
        return tSystemLogDao.update(tSystemLog);
    }

    public int updateBatch(List<TSystemLogReq> list) {
      List<TSystemLog> tSystemLogs = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            return 0;
        }
        for (TSystemLogReq tSystemLogReq : list) {
            TSystemLog tSystemLog = new TSystemLog();
            if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
                log.error("执行批量更新的集合为空！");
                return 0;
            }
            ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
            tSystemLogs.add(tSystemLog);
        }
        return tSystemLogDao.updateBatch(tSystemLogs);
    }

    public int deleteById(Integer id) {
        return tSystemLogDao.deleteById(id);
    }

    public int deleteByEntity(TSystemLogReq tSystemLogReq) {
      TSystemLog tSystemLog = new TSystemLog();
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
        return tSystemLogDao.deleteByEntity(tSystemLog);
    }
  
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            return 0;
        }
        return tSystemLogDao.deleteByIds(ids);
    }

    public int countAll() {
        return tSystemLogDao.countAll();
    }
    
    public int countByEntity(TSystemLogReq tSystemLogReq) {
      TSystemLog tSystemLog = new TSystemLog();
        if(ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)){
            log.error("入参对象不能为空！");
            return 0;
        }
        ObjectUtils.copyProperties(tSystemLogReq,tSystemLog);
        return tSystemLogDao.countByEntity(tSystemLog);
    }

}