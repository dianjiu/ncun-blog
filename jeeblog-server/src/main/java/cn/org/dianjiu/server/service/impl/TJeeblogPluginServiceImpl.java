package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.server.dao.TJeeblogPluginDao;
import cn.org.dianjiu.server.service.TJeeblogPluginServiceI;
import cn.org.dianjiu.server.entity.TJeeblogPlugin;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.List;

/**
 * (TJeeblogPlugin)表服务实现类
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Slf4j
@Service
public class TJeeblogPluginServiceImpl implements TJeeblogPluginServiceI {

    @Autowired
    private TJeeblogPluginDao tJeeblogPluginDao;
    
    @Override
    public TJeeblogPluginResp getById(Integer id) {
        TJeeblogPluginResp tJeeblogPluginResp = new TJeeblogPluginResp();
        TJeeblogPlugin tJeeblogPlugin = tJeeblogPluginDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPlugin)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            throw new BusinessException("400","根据id【"+id+"】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tJeeblogPlugin,tJeeblogPluginResp);
        return tJeeblogPluginResp;
    }
    
    @Override
    public TJeeblogPluginResp getByEntity(TJeeblogPluginReq tJeeblogPluginReq) {
      TJeeblogPluginResp tJeeblogPluginResp = new TJeeblogPluginResp();
        TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
        TJeeblogPlugin tJeeblogPlugin1 = tJeeblogPluginDao.getByEntity(tJeeblogPlugin);
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPlugin1)){
            log.error("根据tJeeblogPluginReq【"+tJeeblogPluginReq+"】没有查到相关记录！");
            throw new BusinessException("400","根据tJeeblogPluginReq【"+tJeeblogPluginReq+"】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tJeeblogPlugin1,tJeeblogPluginResp);
        return tJeeblogPluginResp;
    }
    
    @Override
    public List<TJeeblogPluginResp> listByEntity(TJeeblogPluginReq tJeeblogPluginReq) {
        List<TJeeblogPluginResp> list = new ArrayList<>();
        TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
        List<TJeeblogPlugin> tJeeblogPlugins = tJeeblogPluginDao.listByEntity(tJeeblogPlugin);
        if(null == tJeeblogPlugins || tJeeblogPlugins.isEmpty()){
            log.error("根据tJeeblogPluginReq【"+tJeeblogPluginReq+"】没有查到相关记录！");
            throw new BusinessException("400","根据tJeeblogPluginReq【"+tJeeblogPluginReq+"】没有查到相关记录！");
        }
        for (TJeeblogPlugin tJeeblogPlugin1 : tJeeblogPlugins ) {
            TJeeblogPluginResp tJeeblogPluginResp = new TJeeblogPluginResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPlugin1)){
                log.error("根据tJeeblogPluginReq【"+tJeeblogPluginReq+"】没有查到相关记录！");
                throw new BusinessException("400","根据tJeeblogPluginReq【"+tJeeblogPluginReq+"】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tJeeblogPlugin1,tJeeblogPluginResp);
            list.add(tJeeblogPluginResp);
        }
        return list;
    }

    @Override
    public List<TJeeblogPluginResp> listByIds(List<Integer> ids) {
      List<TJeeblogPluginResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            throw new BusinessException("400","id集合不能为空！");
        }
        List<TJeeblogPlugin> tJeeblogPlugins  = tJeeblogPluginDao.listByIds(ids);
        if(null != tJeeblogPlugins && !tJeeblogPlugins.isEmpty()){
            for (TJeeblogPlugin tJeeblogPlugin1 : tJeeblogPlugins ) {
                TJeeblogPluginResp tJeeblogPluginResp = new TJeeblogPluginResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPlugin1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    throw new BusinessException("400","根据ids【"+ids.toString()+"】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tJeeblogPlugin1,tJeeblogPluginResp);
                list.add(tJeeblogPluginResp);
            }
        }
        return list;
    }
    
    @Override
    public int insert(TJeeblogPluginReq tJeeblogPluginReq) {
      TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
        Date date = new Date();
        tJeeblogPlugin.setCreateTime(date);
        tJeeblogPlugin.setUpdateTime(date);
        return tJeeblogPluginDao.insert(tJeeblogPlugin);
    }

    @Override
    public int insertBatch(List<TJeeblogPluginReq> list) {
      List<TJeeblogPlugin> tJeeblogPlugins = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400","执行批量插入的集合为空！");
        }
        for (TJeeblogPluginReq tJeeblogPluginReq : list) {
            TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
            if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400","执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
            tJeeblogPlugins.add(tJeeblogPlugin);
        }
        return tJeeblogPluginDao.insertBatch(tJeeblogPlugins);
    }
    
    @Override
    public int update(TJeeblogPluginReq tJeeblogPluginReq) {
      TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
        tJeeblogPlugin.setUpdateTime(new Date());
        return tJeeblogPluginDao.update(tJeeblogPlugin);
    }
    
    @Override
    public int updateBatch(List<TJeeblogPluginReq> list) {
      List<TJeeblogPlugin> tJeeblogPlugins = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400","执行批量更新的集合为空！");
        }
        for (TJeeblogPluginReq tJeeblogPluginReq : list) {
            TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
            if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400","执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
            tJeeblogPlugins.add(tJeeblogPlugin);
        }
        return tJeeblogPluginDao.updateBatch(tJeeblogPlugins);
    }

    @Override
    public int deleteById(Integer id) {
        return tJeeblogPluginDao.deleteById(id);
    }
    
    @Override
    public int deleteByEntity(TJeeblogPluginReq tJeeblogPluginReq) {
      TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
        return tJeeblogPluginDao.deleteByEntity(tJeeblogPlugin);
    }
    
    @Override
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            throw new BusinessException("400","id集合不能为空！");
        }
        return tJeeblogPluginDao.deleteByIds(ids);
    }
    
    @Override
    public int countAll() {
        return tJeeblogPluginDao.countAll();
    }
    
    @Override
    public int countByEntity(TJeeblogPluginReq tJeeblogPluginReq) {
      TJeeblogPlugin tJeeblogPlugin = new TJeeblogPlugin();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogPluginReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogPluginReq,tJeeblogPlugin);
        return tJeeblogPluginDao.countByEntity(tJeeblogPlugin);
    }

}