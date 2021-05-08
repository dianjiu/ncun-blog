package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TFileReq;
import cn.org.dianjiu.common.pojo.resp.TFileResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TFileDao;
import cn.org.dianjiu.server.entity.TFile;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TFileServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件操作(TFile)表服务实现类
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:08
 */
@Slf4j
@Service
public class TFileServiceImpl implements TFileServiceI {

    @Autowired
    private TFileDao tFileDao;

    @Override
    public TFileResp getById(Integer id) {
        TFileResp tFileResp = new TFileResp();
        TFile tFile = tFileDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tFile)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tFile, tFileResp);
        return tFileResp;
    }

    @Override
    public TFileResp getByEntity(TFileReq tFileReq) {
        TFileResp tFileResp = new TFileResp();
        TFile tFile = new TFile();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFileReq, tFile);
        TFile tFile1 = tFileDao.getByEntity(tFile);
        if (ObjectUtils.checkObjAllFieldsIsNull(tFile1)) {
            log.error("根据tFileReq【" + tFileReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tFileReq【" + tFileReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tFile1, tFileResp);
        return tFileResp;
    }

    @Override
    public List<TFileResp> listByEntity(TFileReq tFileReq) {
        List<TFileResp> list = new ArrayList<>();
        TFile tFile = new TFile();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFileReq, tFile);
        List<TFile> tFiles = tFileDao.listByEntity(tFile);
        if (null == tFiles || tFiles.isEmpty()) {
            log.error("根据tFileReq【" + tFileReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tFileReq【" + tFileReq + "】没有查到相关记录！");
        }
        for (TFile tFile1 : tFiles) {
            TFileResp tFileResp = new TFileResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tFile1)) {
                log.error("根据tFileReq【" + tFileReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tFileReq【" + tFileReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tFile1, tFileResp);
            list.add(tFileResp);
        }
        return list;
    }

    @Override
    public List<TFileResp> listByIds(List<Integer> ids) {
        List<TFileResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TFile> tFiles = tFileDao.listByIds(ids);
        if (null != tFiles && !tFiles.isEmpty()) {
            for (TFile tFile1 : tFiles) {
                TFileResp tFileResp = new TFileResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tFile1)) {
                    log.error("根据ids【" + ids + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tFile1, tFileResp);
                list.add(tFileResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TFileResp> listByPage(PageReq<TFileReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TFileResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TFileResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TFileReq tFileReq) {
        TFile tFile = new TFile();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFileReq, tFile);
        Date date = new Date();
        tFile.setCreatedTime(date);
        tFile.setCreatedBy("admin");
        tFile.setUpdatedTime(date);
        tFile.setUpdatedBy("admin");
        return tFileDao.insert(tFile);
    }

    @Override
    public int insertBatch(List<TFileReq> list) {
        List<TFile> tFiles = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TFileReq tFileReq : list) {
            TFile tFile = new TFile();
            if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tFileReq, tFile);
            tFiles.add(tFile);
        }
        return tFileDao.insertBatch(tFiles);
    }

    @Override
    public int update(TFileReq tFileReq) {
        TFile tFile = new TFile();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFileReq, tFile);
        tFile.setUpdatedTime(new Date());
        return tFileDao.update(tFile);
    }

    @Override
    public int updateBatch(List<TFileReq> list) {
        List<TFile> tFiles = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TFileReq tFileReq : list) {
            TFile tFile = new TFile();
            if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tFileReq, tFile);
            tFiles.add(tFile);
        }
        return tFileDao.updateBatch(tFiles);
    }

    @Override
    public int deleteById(Integer id) {
        return tFileDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TFileReq tFileReq) {
        TFile tFile = new TFile();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFileReq, tFile);
        return tFileDao.deleteByEntity(tFile);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tFileDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tFileDao.countAll();
    }

    @Override
    public int countByEntity(TFileReq tFileReq) {
        TFile tFile = new TFile();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFileReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFileReq, tFile);
        return tFileDao.countByEntity(tFile);
    }

}
