package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TMenuReq;
import cn.org.dianjiu.common.pojo.resp.TMenuResp;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.dao.TMenuDao;
import cn.org.dianjiu.server.entity.TMenu;
import cn.org.dianjiu.server.exception.BusinessException;
import cn.org.dianjiu.server.service.TMenuServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 菜单操作(TMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-10-06 18:38:43
 */
@Slf4j
@Service
public class TMenuServiceImpl implements TMenuServiceI {

    @Autowired
    private TMenuDao tMenuDao;

    @Override
    public TMenuResp getById(Integer id) {
        TMenuResp tMenuResp = new TMenuResp();
        TMenu tMenu = tMenuDao.getById(id);
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenu)) {
            log.error("根据id【" + id + "】没有查到相关记录！");
            throw new BusinessException("400", "根据id【" + id + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tMenu, tMenuResp);
        return tMenuResp;
    }

    @Override
    public TMenuResp getByEntity(TMenuReq tMenuReq) {
        TMenuResp tMenuResp = new TMenuResp();
        TMenu tMenu = new TMenu();
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tMenuReq, tMenu);
        TMenu tMenu1 = tMenuDao.getByEntity(tMenu);
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenu1)) {
            log.error("根据tMenuReq【" + tMenuReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tMenuReq【" + tMenuReq + "】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tMenu1, tMenuResp);
        return tMenuResp;
    }

    @Override
    public List<TMenuResp> listByEntity(TMenuReq tMenuReq) {
        List<TMenuResp> list = new ArrayList<>();
        TMenu tMenu = new TMenu();
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tMenuReq, tMenu);
        List<TMenu> tMenus = tMenuDao.listByEntity(tMenu);
        if (null == tMenus || tMenus.isEmpty()) {
            log.error("根据tMenuReq【" + tMenuReq + "】没有查到相关记录！");
            throw new BusinessException("400", "根据tMenuReq【" + tMenuReq + "】没有查到相关记录！");
        }
        for (TMenu tMenu1 : tMenus) {
            TMenuResp tMenuResp = new TMenuResp();
            if (ObjectUtils.checkObjAllFieldsIsNull(tMenu1)) {
                log.error("根据tMenuReq【" + tMenuReq + "】没有查到相关记录！");
                throw new BusinessException("400", "根据tMenuReq【" + tMenuReq + "】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tMenu1, tMenuResp);
            list.add(tMenuResp);
        }
        return list;
    }

    @Override
    public List<TMenuResp> listByIds(List<Integer> ids) {
        List<TMenuResp> list = new ArrayList<>();
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        List<TMenu> tMenus = tMenuDao.listByIds(ids);
        if (null != tMenus && !tMenus.isEmpty()) {
            for (TMenu tMenu1 : tMenus) {
                TMenuResp tMenuResp = new TMenuResp();
                if (ObjectUtils.checkObjAllFieldsIsNull(tMenu1)) {
                    log.error("根据ids【" + ids.toString() + "】没有查到相关记录！");
                    throw new BusinessException("400", "根据ids【" + ids.toString() + "】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tMenu1, tMenuResp);
                list.add(tMenuResp);
            }
        }
        return list;
    }

    @Override
    public PageInfo<TMenuResp> listByPage(PageReq<TMenuReq> pageReq) {
        //获取第1页，10条内容，默认查询总数count
        //PageHelper.startPage(1, 10);
        //紧跟着的第一个select方法会被分页
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<TMenuResp> list = listByEntity(pageReq.getData());
        //PageInfo<Object> objectPageInfo = new PageInfo<>();
        PageInfo<TMenuResp> pages = new PageInfo<>(list);
        //分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
        //Page<TTaskDetailsResp> pages = (Page<TTaskDetailsResp>) list;
        return pages;
    }

    @Override
    public int insert(TMenuReq tMenuReq) {
        TMenu tMenu = new TMenu();
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tMenuReq, tMenu);
        Date date = new Date();
        tMenu.setCreateTime(date);
        tMenu.setUpdateTime(date);
        return tMenuDao.insert(tMenu);
    }

    @Override
    public int insertBatch(List<TMenuReq> list) {
        List<TMenu> tMenus = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400", "执行批量插入的集合为空！");
        }
        for (TMenuReq tMenuReq : list) {
            TMenu tMenu = new TMenu();
            if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400", "执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tMenuReq, tMenu);
            tMenus.add(tMenu);
        }
        return tMenuDao.insertBatch(tMenus);
    }

    @Override
    public int update(TMenuReq tMenuReq) {
        TMenu tMenu = new TMenu();
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tMenuReq, tMenu);
        tMenu.setUpdateTime(new Date());
        return tMenuDao.update(tMenu);
    }

    @Override
    public int updateBatch(List<TMenuReq> list) {
        List<TMenu> tMenus = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400", "执行批量更新的集合为空！");
        }
        for (TMenuReq tMenuReq : list) {
            TMenu tMenu = new TMenu();
            if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400", "执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tMenuReq, tMenu);
            tMenus.add(tMenu);
        }
        return tMenuDao.updateBatch(tMenus);
    }

    @Override
    public int deleteById(Integer id) {
        return tMenuDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(TMenuReq tMenuReq) {
        TMenu tMenu = new TMenu();
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tMenuReq, tMenu);
        return tMenuDao.deleteByEntity(tMenu);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        if (null == ids || ids.isEmpty()) {
            log.error("id集合不能为空！");
            throw new BusinessException("400", "id集合不能为空！");
        }
        return tMenuDao.deleteByIds(ids);
    }

    @Override
    public int countAll() {
        return tMenuDao.countAll();
    }

    @Override
    public int countByEntity(TMenuReq tMenuReq) {
        TMenu tMenu = new TMenu();
        if (ObjectUtils.checkObjAllFieldsIsNull(tMenuReq)) {
            log.error("入参对象不能为空！");
            throw new BusinessException("400", "入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tMenuReq, tMenu);
        return tMenuDao.countByEntity(tMenu);
    }

}