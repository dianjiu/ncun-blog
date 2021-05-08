package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TRoleMenusReq;
import cn.org.dianjiu.common.pojo.resp.TRoleMenusResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TRoleMenusDao;
import cn.org.dianjiu.server.entity.TRoleMenus;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TRoleMenusServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色菜单操作(TRoleMenus)表服务实现类
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:10
 */
@Slf4j
@Service
public class TRoleMenusServiceImpl implements TRoleMenusServiceI {

    @Autowired
    private TRoleMenusDao tRoleMenusDao;

    @Override
    public TRoleMenusResp getById(Integer id) {
        TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
        TRoleMenus tRoleMenus = tRoleMenusDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tRoleMenus, tRoleMenusResp);
        return tRoleMenusResp;
    }

    @Override
    public TRoleMenusResp getByEntity(TRoleMenusReq tRoleMenusReq) {
        TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
        TRoleMenus tRoleMenus = new TRoleMenus();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
        TRoleMenus tRoleMenus1 = tRoleMenusDao.getByEntity(tRoleMenus);
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus1)) {
            log.error("根据tRoleMenusReq【" + tRoleMenusReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tRoleMenusReq【" + tRoleMenusReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tRoleMenus1, tRoleMenusResp);
        return tRoleMenusResp;
    }

    @Override
    public List<TRoleMenusResp> listByEntity(TRoleMenusReq tRoleMenusReq) {
        List<TRoleMenusResp> list = new ArrayList<>();
        TRoleMenus tRoleMenus = new TRoleMenus();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
        List<TRoleMenus> tRoleMenuss = tRoleMenusDao.listByEntity(tRoleMenus);
        if (null == tRoleMenuss || tRoleMenuss.isEmpty()) {
            log.error("根据tRoleMenusReq【" + tRoleMenusReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tRoleMenusReq【" + tRoleMenusReq + "】没有查到相关记录！");
        }
        for (TRoleMenus tRoleMenus1 : tRoleMenuss) {
            TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus1)) {
                log.error("根据tRoleMenusReq【" + tRoleMenusReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tRoleMenusReq【" + tRoleMenusReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tRoleMenus1, tRoleMenusResp);
            list.add(tRoleMenusResp);
        }
        return list;
    }

    @Override
    public List<TRoleMenusResp> listByIds(List<Integer> ids) {
        List<TRoleMenusResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TRoleMenus> tRoleMenuss = tRoleMenusDao.listByIds(ids);
        if (null != tRoleMenuss && !tRoleMenuss.isEmpty()) {
            for (TRoleMenus tRoleMenus1 : tRoleMenuss) {
                TRoleMenusResp tRoleMenusResp = new TRoleMenusResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenus1)) {
                    log.error("根据ids【" + ids + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tRoleMenus1, tRoleMenusResp);
                list.add(tRoleMenusResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TRoleMenusResp> listByPage(PageReq<TRoleMenusReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TRoleMenusResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TRoleMenusResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TRoleMenusReq tRoleMenusReq) {
        TRoleMenus tRoleMenus = new TRoleMenus();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
        Date date = new Date();
        tRoleMenus.setCreatedTime(date);
        tRoleMenus.setCreatedBy("admin");
        tRoleMenus.setUpdatedTime(date);
        tRoleMenus.setUpdatedBy("admin");
        return tRoleMenusDao.insert(tRoleMenus);
    }

    @Override
    public int insertBatch(List<TRoleMenusReq> list) {
        List<TRoleMenus> tRoleMenuss = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TRoleMenusReq tRoleMenusReq : list) {
            TRoleMenus tRoleMenus = new TRoleMenus();
            if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
            tRoleMenuss.add(tRoleMenus);
        }
        return tRoleMenusDao.insertBatch(tRoleMenuss);
    }

    @Override
    public int update(TRoleMenusReq tRoleMenusReq) {
        TRoleMenus tRoleMenus = new TRoleMenus();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
        tRoleMenus.setUpdatedTime(new Date());
        return tRoleMenusDao.update(tRoleMenus);
    }

    @Override
    public int updateBatch(List<TRoleMenusReq> list) {
        List<TRoleMenus> tRoleMenuss = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TRoleMenusReq tRoleMenusReq : list) {
            TRoleMenus tRoleMenus = new TRoleMenus();
            if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
            tRoleMenuss.add(tRoleMenus);
        }
        return tRoleMenusDao.updateBatch(tRoleMenuss);
    }

    @Override
    public int deleteById(Integer id) {
        return tRoleMenusDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TRoleMenusReq tRoleMenusReq) {
        TRoleMenus tRoleMenus = new TRoleMenus();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
        return tRoleMenusDao.deleteByEntity(tRoleMenus);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tRoleMenusDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tRoleMenusDao.countAll();
    }

    @Override
    public int countByEntity(TRoleMenusReq tRoleMenusReq) {
        TRoleMenus tRoleMenus = new TRoleMenus();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleMenusReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleMenusReq, tRoleMenus);
        return tRoleMenusDao.countByEntity(tRoleMenus);
    }

}
