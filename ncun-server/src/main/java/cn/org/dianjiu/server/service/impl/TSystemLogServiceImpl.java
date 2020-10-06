package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TSystemLogReq;
import cn.org.dianjiu.common.pojo.resp.TSystemLogResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TSystemLogDao;
import cn.org.dianjiu.server.entity.TSystemLog;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TSystemLogServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 日志操作(TSystemLog)表服务实现类
 *
 * @author makejava
 * @since 2020-10-06 20:22:36
 */
@Slf4j
@Service
public class TSystemLogServiceImpl implements TSystemLogServiceI {

    @Autowired
    private TSystemLogDao tSystemLogDao;

    @Override
    public TSystemLogResp getById(Integer id) {
        TSystemLogResp tSystemLogResp = new TSystemLogResp();
        TSystemLog tSystemLog = tSystemLogDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLog)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tSystemLog, tSystemLogResp);
        return tSystemLogResp;
    }

    @Override
    public TSystemLogResp getByEntity(TSystemLogReq tSystemLogReq) {
        TSystemLogResp tSystemLogResp = new TSystemLogResp();
        TSystemLog tSystemLog = new TSystemLog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
        TSystemLog tSystemLog1 = tSystemLogDao.getByEntity(tSystemLog);
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLog1)) {
            log.error("根据tSystemLogReq【" + tSystemLogReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tSystemLogReq【" + tSystemLogReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tSystemLog1, tSystemLogResp);
        return tSystemLogResp;
    }

    @Override
    public List<TSystemLogResp> listByEntity(TSystemLogReq tSystemLogReq) {
        List<TSystemLogResp> list = new ArrayList<>();
        TSystemLog tSystemLog = new TSystemLog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
        List<TSystemLog> tSystemLogs = tSystemLogDao.listByEntity(tSystemLog);
        if (null == tSystemLogs || tSystemLogs.isEmpty()) {
            log.error("根据tSystemLogReq【" + tSystemLogReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tSystemLogReq【" + tSystemLogReq + "】没有查到相关记录！");
        }
        for (TSystemLog tSystemLog1 : tSystemLogs) {
            TSystemLogResp tSystemLogResp = new TSystemLogResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLog1)) {
                log.error("根据tSystemLogReq【" + tSystemLogReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tSystemLogReq【" + tSystemLogReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tSystemLog1, tSystemLogResp);
            list.add(tSystemLogResp);
        }
        return list;
    }

    @Override
    public List<TSystemLogResp> listByIds(List<Integer> ids) {
        List<TSystemLogResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TSystemLog> tSystemLogs = tSystemLogDao.listByIds(ids);
        if (null != tSystemLogs && !tSystemLogs.isEmpty()) {
            for (TSystemLog tSystemLog1 : tSystemLogs) {
                TSystemLogResp tSystemLogResp = new TSystemLogResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLog1)) {
                    log.error("根据ids【" + ids.toString() + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids.toString() + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tSystemLog1, tSystemLogResp);
                list.add(tSystemLogResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TSystemLogResp> listByPage(PageReq<TSystemLogReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TSystemLogResp> list = listByEntity(pageReq.getData());
        PageInfo<TSystemLogResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TSystemLogReq tSystemLogReq) {
        TSystemLog tSystemLog = new TSystemLog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
        Date date = new Date();
        tSystemLog.setCreateTime(date);
        tSystemLog.setUpdateTime(date);
        return tSystemLogDao.insert(tSystemLog);
    }

    @Override
    public int insertBatch(List<TSystemLogReq> list) {
        List<TSystemLog> tSystemLogs = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TSystemLogReq tSystemLogReq : list) {
            TSystemLog tSystemLog = new TSystemLog();
            if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
            tSystemLogs.add(tSystemLog);
        }
        return tSystemLogDao.insertBatch(tSystemLogs);
    }

    @Override
    public int update(TSystemLogReq tSystemLogReq) {
        TSystemLog tSystemLog = new TSystemLog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
        tSystemLog.setUpdateTime(new Date());
        return tSystemLogDao.update(tSystemLog);
    }

    @Override
    public int updateBatch(List<TSystemLogReq> list) {
        List<TSystemLog> tSystemLogs = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TSystemLogReq tSystemLogReq : list) {
            TSystemLog tSystemLog = new TSystemLog();
            if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
            tSystemLogs.add(tSystemLog);
        }
        return tSystemLogDao.updateBatch(tSystemLogs);
    }

    @Override
    public int deleteById(Integer id) {
        return tSystemLogDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TSystemLogReq tSystemLogReq) {
        TSystemLog tSystemLog = new TSystemLog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
        return tSystemLogDao.deleteByEntity(tSystemLog);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tSystemLogDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tSystemLogDao.countAll();
    }

    @Override
    public int countByEntity(TSystemLogReq tSystemLogReq) {
        TSystemLog tSystemLog = new TSystemLog();
        if (ObjectUtils.checkObjAllFieldsIsNull(tSystemLogReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tSystemLogReq, tSystemLog);
        return tSystemLogDao.countByEntity(tSystemLog);
    }

}