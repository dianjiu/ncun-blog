package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TRoleReq;
import cn.org.dianjiu.common.pojo.resp.TRoleResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TRoleDao;
import cn.org.dianjiu.server.entity.TRole;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TRoleServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色操作(TRole)表服务实现类
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:10
 */
@Slf4j
@Service
public class TRoleServiceImpl implements TRoleServiceI {

    @Autowired
    private TRoleDao tRoleDao;

    @Override
    public TRoleResp getById(Integer id) {
        TRoleResp tRoleResp = new TRoleResp();
        TRole tRole = tRoleDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tRole)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tRole, tRoleResp);
        return tRoleResp;
    }

    @Override
    public TRoleResp getByEntity(TRoleReq tRoleReq) {
        TRoleResp tRoleResp = new TRoleResp();
        TRole tRole = new TRole();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleReq, tRole);
        TRole tRole1 = tRoleDao.getByEntity(tRole);
        if (ObjectUtils.checkObjAllFieldsIsNull(tRole1)) {
            log.error("根据tRoleReq【" + tRoleReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tRoleReq【" + tRoleReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tRole1, tRoleResp);
        return tRoleResp;
    }

    @Override
    public List<TRoleResp> listByEntity(TRoleReq tRoleReq) {
        List<TRoleResp> list = new ArrayList<>();
        TRole tRole = new TRole();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleReq, tRole);
        List<TRole> tRoles = tRoleDao.listByEntity(tRole);
        if (null == tRoles || tRoles.isEmpty()) {
            log.error("根据tRoleReq【" + tRoleReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tRoleReq【" + tRoleReq + "】没有查到相关记录！");
        }
        for (TRole tRole1 : tRoles) {
            TRoleResp tRoleResp = new TRoleResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tRole1)) {
                log.error("根据tRoleReq【" + tRoleReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tRoleReq【" + tRoleReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tRole1, tRoleResp);
            list.add(tRoleResp);
        }
        return list;
    }

    @Override
    public List<TRoleResp> listByIds(List<Integer> ids) {
        List<TRoleResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TRole> tRoles = tRoleDao.listByIds(ids);
        if (null != tRoles && !tRoles.isEmpty()) {
            for (TRole tRole1 : tRoles) {
                TRoleResp tRoleResp = new TRoleResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tRole1)) {
                    log.error("根据ids【" + ids + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tRole1, tRoleResp);
                list.add(tRoleResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TRoleResp> listByPage(PageReq<TRoleReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TRoleResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TRoleResp> pages = new PageInfo<>(list);
        int count = countByEntity(pageReq.getData());
        int num = count % pageReq.getPageSize() == 0 ? count / pageReq.getPageSize() : count / pageReq.getPageSize() + 1;
        pages.setPageNum(pageReq.getPageNum());
        pages.setPageSize(pageReq.getPageSize());
        pages.setTotal(count);
        pages.setPages(num);
        return pages;
    }

    @Override
    public int insert(TRoleReq tRoleReq) {
        TRole tRole = new TRole();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleReq, tRole);
        Date date = new Date();
        tRole.setCreatedTime(date);
        tRole.setCreatedBy("admin");
        tRole.setUpdatedTime(date);
        tRole.setUpdatedBy("admin");
        return tRoleDao.insert(tRole);
    }

    @Override
    public int insertBatch(List<TRoleReq> list) {
        List<TRole> tRoles = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TRoleReq tRoleReq : list) {
            TRole tRole = new TRole();
            if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tRoleReq, tRole);
            tRoles.add(tRole);
        }
        return tRoleDao.insertBatch(tRoles);
    }

    @Override
    public int update(TRoleReq tRoleReq) {
        TRole tRole = new TRole();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleReq, tRole);
        tRole.setUpdatedTime(new Date());
        return tRoleDao.update(tRole);
    }

    @Override
    public int updateBatch(List<TRoleReq> list) {
        List<TRole> tRoles = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TRoleReq tRoleReq : list) {
            TRole tRole = new TRole();
            if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tRoleReq, tRole);
            tRoles.add(tRole);
        }
        return tRoleDao.updateBatch(tRoles);
    }

    @Override
    public int deleteById(Integer id) {
        return tRoleDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TRoleReq tRoleReq) {
        TRole tRole = new TRole();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleReq, tRole);
        return tRoleDao.deleteByEntity(tRole);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tRoleDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tRoleDao.countAll();
    }

    @Override
    public int countByEntity(TRoleReq tRoleReq) {
        TRole tRole = new TRole();
        if (ObjectUtils.checkObjAllFieldsIsNull(tRoleReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tRoleReq, tRole);
        return tRoleDao.countByEntity(tRole);
    }

}
