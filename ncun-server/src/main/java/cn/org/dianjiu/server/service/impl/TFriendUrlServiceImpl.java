package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TFriendUrlReq;
import cn.org.dianjiu.common.pojo.resp.TFriendUrlResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TFriendUrlDao;
import cn.org.dianjiu.server.entity.TFriendUrl;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TFriendUrlServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 友链操作(TFriendUrl)表服务实现类
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:09
 */
@Slf4j
@Service
public class TFriendUrlServiceImpl implements TFriendUrlServiceI {

    @Autowired
    private TFriendUrlDao tFriendUrlDao;

    @Override
    public TFriendUrlResp getById(Integer id) {
        TFriendUrlResp tFriendUrlResp = new TFriendUrlResp();
        TFriendUrl tFriendUrl = tFriendUrlDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrl)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tFriendUrl, tFriendUrlResp);
        return tFriendUrlResp;
    }

    @Override
    public TFriendUrlResp getByEntity(TFriendUrlReq tFriendUrlReq) {
        TFriendUrlResp tFriendUrlResp = new TFriendUrlResp();
        TFriendUrl tFriendUrl = new TFriendUrl();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
        TFriendUrl tFriendUrl1 = tFriendUrlDao.getByEntity(tFriendUrl);
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrl1)) {
            log.error("根据tFriendUrlReq【" + tFriendUrlReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tFriendUrlReq【" + tFriendUrlReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tFriendUrl1, tFriendUrlResp);
        return tFriendUrlResp;
    }

    @Override
    public List<TFriendUrlResp> listByEntity(TFriendUrlReq tFriendUrlReq) {
        List<TFriendUrlResp> list = new ArrayList<>();
        TFriendUrl tFriendUrl = new TFriendUrl();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
        List<TFriendUrl> tFriendUrls = tFriendUrlDao.listByEntity(tFriendUrl);
        if (null == tFriendUrls || tFriendUrls.isEmpty()) {
            log.error("根据tFriendUrlReq【" + tFriendUrlReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tFriendUrlReq【" + tFriendUrlReq + "】没有查到相关记录！");
        }
        for (TFriendUrl tFriendUrl1 : tFriendUrls) {
            TFriendUrlResp tFriendUrlResp = new TFriendUrlResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrl1)) {
                log.error("根据tFriendUrlReq【" + tFriendUrlReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tFriendUrlReq【" + tFriendUrlReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tFriendUrl1, tFriendUrlResp);
            list.add(tFriendUrlResp);
        }
        return list;
    }

    @Override
    public List<TFriendUrlResp> listByIds(List<Integer> ids) {
        List<TFriendUrlResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TFriendUrl> tFriendUrls = tFriendUrlDao.listByIds(ids);
        if (null != tFriendUrls && !tFriendUrls.isEmpty()) {
            for (TFriendUrl tFriendUrl1 : tFriendUrls) {
                TFriendUrlResp tFriendUrlResp = new TFriendUrlResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrl1)) {
                    log.error("根据ids【" + ids + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tFriendUrl1, tFriendUrlResp);
                list.add(tFriendUrlResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TFriendUrlResp> listByPage(PageReq<TFriendUrlReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TFriendUrlResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TFriendUrlResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TFriendUrlReq tFriendUrlReq) {
        TFriendUrl tFriendUrl = new TFriendUrl();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
        Date date = new Date();
        tFriendUrl.setCreatedTime(date);
        tFriendUrl.setCreatedBy("admin");
        tFriendUrl.setUpdatedTime(date);
        tFriendUrl.setUpdatedBy("admin");
        return tFriendUrlDao.insert(tFriendUrl);
    }

    @Override
    public int insertBatch(List<TFriendUrlReq> list) {
        List<TFriendUrl> tFriendUrls = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TFriendUrlReq tFriendUrlReq : list) {
            TFriendUrl tFriendUrl = new TFriendUrl();
            if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
            tFriendUrls.add(tFriendUrl);
        }
        return tFriendUrlDao.insertBatch(tFriendUrls);
    }

    @Override
    public int update(TFriendUrlReq tFriendUrlReq) {
        TFriendUrl tFriendUrl = new TFriendUrl();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
        tFriendUrl.setUpdatedTime(new Date());
        return tFriendUrlDao.update(tFriendUrl);
    }

    @Override
    public int updateBatch(List<TFriendUrlReq> list) {
        List<TFriendUrl> tFriendUrls = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TFriendUrlReq tFriendUrlReq : list) {
            TFriendUrl tFriendUrl = new TFriendUrl();
            if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
            tFriendUrls.add(tFriendUrl);
        }
        return tFriendUrlDao.updateBatch(tFriendUrls);
    }

    @Override
    public int deleteById(Integer id) {
        return tFriendUrlDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TFriendUrlReq tFriendUrlReq) {
        TFriendUrl tFriendUrl = new TFriendUrl();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
        return tFriendUrlDao.deleteByEntity(tFriendUrl);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tFriendUrlDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tFriendUrlDao.countAll();
    }

    @Override
    public int countByEntity(TFriendUrlReq tFriendUrlReq) {
        TFriendUrl tFriendUrl = new TFriendUrl();
        if (ObjectUtils.checkObjAllFieldsIsNull(tFriendUrlReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tFriendUrlReq, tFriendUrl);
        return tFriendUrlDao.countByEntity(tFriendUrl);
    }

}
