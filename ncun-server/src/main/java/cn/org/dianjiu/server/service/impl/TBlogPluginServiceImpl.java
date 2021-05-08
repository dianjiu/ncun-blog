package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogPluginReq;
import cn.org.dianjiu.common.pojo.resp.TBlogPluginResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TBlogPluginDao;
import cn.org.dianjiu.server.entity.TBlogPlugin;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TBlogPluginServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 插件操作(TBlogPlugin)表服务实现类
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:05
 */
@Slf4j
@Service
public class TBlogPluginServiceImpl implements TBlogPluginServiceI {

    @Autowired
    private TBlogPluginDao tBlogPluginDao;

    @Override
    public TBlogPluginResp getById(Integer id) {
        TBlogPluginResp tBlogPluginResp = new TBlogPluginResp();
        TBlogPlugin tBlogPlugin = tBlogPluginDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPlugin)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogPlugin, tBlogPluginResp);
        return tBlogPluginResp;
    }

    @Override
    public TBlogPluginResp getByEntity(TBlogPluginReq tBlogPluginReq) {
        TBlogPluginResp tBlogPluginResp = new TBlogPluginResp();
        TBlogPlugin tBlogPlugin = new TBlogPlugin();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
        TBlogPlugin tBlogPlugin1 = tBlogPluginDao.getByEntity(tBlogPlugin);
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPlugin1)) {
            log.error("根据tBlogPluginReq【" + tBlogPluginReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogPluginReq【" + tBlogPluginReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogPlugin1, tBlogPluginResp);
        return tBlogPluginResp;
    }

    @Override
    public List<TBlogPluginResp> listByEntity(TBlogPluginReq tBlogPluginReq) {
        List<TBlogPluginResp> list = new ArrayList<>();
        TBlogPlugin tBlogPlugin = new TBlogPlugin();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
        List<TBlogPlugin> tBlogPlugins = tBlogPluginDao.listByEntity(tBlogPlugin);
        if (null == tBlogPlugins || tBlogPlugins.isEmpty()) {
            log.error("根据tBlogPluginReq【" + tBlogPluginReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tBlogPluginReq【" + tBlogPluginReq + "】没有查到相关记录！");
        }
        for (TBlogPlugin tBlogPlugin1 : tBlogPlugins) {
            TBlogPluginResp tBlogPluginResp = new TBlogPluginResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPlugin1)) {
                log.error("根据tBlogPluginReq【" + tBlogPluginReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tBlogPluginReq【" + tBlogPluginReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tBlogPlugin1, tBlogPluginResp);
            list.add(tBlogPluginResp);
        }
        return list;
    }

    @Override
    public List<TBlogPluginResp> listByIds(List<Integer> ids) {
        List<TBlogPluginResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TBlogPlugin> tBlogPlugins = tBlogPluginDao.listByIds(ids);
        if (null != tBlogPlugins && !tBlogPlugins.isEmpty()) {
            for (TBlogPlugin tBlogPlugin1 : tBlogPlugins) {
                TBlogPluginResp tBlogPluginResp = new TBlogPluginResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPlugin1)) {
                    log.error("根据ids【" + ids + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tBlogPlugin1, tBlogPluginResp);
                list.add(tBlogPluginResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TBlogPluginResp> listByPage(PageReq<TBlogPluginReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TBlogPluginResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TBlogPluginResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TBlogPluginReq tBlogPluginReq) {
        TBlogPlugin tBlogPlugin = new TBlogPlugin();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
        Date date = new Date();
        tBlogPlugin.setCreatedTime(date);
        tBlogPlugin.setCreatedBy("admin");
        tBlogPlugin.setUpdatedTime(date);
        tBlogPlugin.setUpdatedBy("admin");
        return tBlogPluginDao.insert(tBlogPlugin);
    }

    @Override
    public int insertBatch(List<TBlogPluginReq> list) {
        List<TBlogPlugin> tBlogPlugins = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TBlogPluginReq tBlogPluginReq : list) {
            TBlogPlugin tBlogPlugin = new TBlogPlugin();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
            tBlogPlugins.add(tBlogPlugin);
        }
        return tBlogPluginDao.insertBatch(tBlogPlugins);
    }

    @Override
    public int update(TBlogPluginReq tBlogPluginReq) {
        TBlogPlugin tBlogPlugin = new TBlogPlugin();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
        tBlogPlugin.setUpdatedTime(new Date());
        return tBlogPluginDao.update(tBlogPlugin);
    }

    @Override
    public int updateBatch(List<TBlogPluginReq> list) {
        List<TBlogPlugin> tBlogPlugins = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TBlogPluginReq tBlogPluginReq : list) {
            TBlogPlugin tBlogPlugin = new TBlogPlugin();
            if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
            tBlogPlugins.add(tBlogPlugin);
        }
        return tBlogPluginDao.updateBatch(tBlogPlugins);
    }

    @Override
    public int deleteById(Integer id) {
        return tBlogPluginDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TBlogPluginReq tBlogPluginReq) {
        TBlogPlugin tBlogPlugin = new TBlogPlugin();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
        return tBlogPluginDao.deleteByEntity(tBlogPlugin);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tBlogPluginDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tBlogPluginDao.countAll();
    }

    @Override
    public int countByEntity(TBlogPluginReq tBlogPluginReq) {
        TBlogPlugin tBlogPlugin = new TBlogPlugin();
        if (ObjectUtils.checkObjAllFieldsIsNull(tBlogPluginReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogPluginReq, tBlogPlugin);
        return tBlogPluginDao.countByEntity(tBlogPlugin);
    }

}
