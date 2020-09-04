package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.server.dao.TJeeblogThemeDao;
import cn.org.dianjiu.server.service.TJeeblogThemeServiceI;
import cn.org.dianjiu.server.entity.TJeeblogTheme;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.List;

/**
 * (TJeeblogTheme)表服务实现类
 *
 * @author makejava
 * @since 2020-09-04 15:06:16
 */
@Slf4j
@Service
public class TJeeblogThemeServiceImpl implements TJeeblogThemeServiceI {

    @Autowired
    private TJeeblogThemeDao tJeeblogThemeDao;
    
    @Override
    public TJeeblogThemeResp getById(Integer id) {
        TJeeblogThemeResp tJeeblogThemeResp = new TJeeblogThemeResp();
        TJeeblogTheme tJeeblogTheme = tJeeblogThemeDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogTheme)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            throw new BusinessException("400","根据id【"+id+"】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tJeeblogTheme,tJeeblogThemeResp);
        return tJeeblogThemeResp;
    }
    
    @Override
    public TJeeblogThemeResp getByEntity(TJeeblogThemeReq tJeeblogThemeReq) {
      TJeeblogThemeResp tJeeblogThemeResp = new TJeeblogThemeResp();
        TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
        TJeeblogTheme tJeeblogTheme1 = tJeeblogThemeDao.getByEntity(tJeeblogTheme);
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogTheme1)){
            log.error("根据tJeeblogThemeReq【"+tJeeblogThemeReq+"】没有查到相关记录！");
            throw new BusinessException("400","根据tJeeblogThemeReq【"+tJeeblogThemeReq+"】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tJeeblogTheme1,tJeeblogThemeResp);
        return tJeeblogThemeResp;
    }
    
    @Override
    public List<TJeeblogThemeResp> listByEntity(TJeeblogThemeReq tJeeblogThemeReq) {
        List<TJeeblogThemeResp> list = new ArrayList<>();
        TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
        List<TJeeblogTheme> tJeeblogThemes = tJeeblogThemeDao.listByEntity(tJeeblogTheme);
        if(null == tJeeblogThemes || tJeeblogThemes.isEmpty()){
            log.error("根据tJeeblogThemeReq【"+tJeeblogThemeReq+"】没有查到相关记录！");
            throw new BusinessException("400","根据tJeeblogThemeReq【"+tJeeblogThemeReq+"】没有查到相关记录！");
        }
        for (TJeeblogTheme tJeeblogTheme1 : tJeeblogThemes ) {
            TJeeblogThemeResp tJeeblogThemeResp = new TJeeblogThemeResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogTheme1)){
                log.error("根据tJeeblogThemeReq【"+tJeeblogThemeReq+"】没有查到相关记录！");
                throw new BusinessException("400","根据tJeeblogThemeReq【"+tJeeblogThemeReq+"】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tJeeblogTheme1,tJeeblogThemeResp);
            list.add(tJeeblogThemeResp);
        }
        return list;
    }

    @Override
    public List<TJeeblogThemeResp> listByIds(List<Integer> ids) {
      List<TJeeblogThemeResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            throw new BusinessException("400","id集合不能为空！");
        }
        List<TJeeblogTheme> tJeeblogThemes  = tJeeblogThemeDao.listByIds(ids);
        if(null != tJeeblogThemes && !tJeeblogThemes.isEmpty()){
            for (TJeeblogTheme tJeeblogTheme1 : tJeeblogThemes ) {
                TJeeblogThemeResp tJeeblogThemeResp = new TJeeblogThemeResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogTheme1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    throw new BusinessException("400","根据ids【"+ids.toString()+"】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tJeeblogTheme1,tJeeblogThemeResp);
                list.add(tJeeblogThemeResp);
            }
        }
        return list;
    }
    
    @Override
    public int insert(TJeeblogThemeReq tJeeblogThemeReq) {
      TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
        Date date = new Date();
        tJeeblogTheme.setCreateTime(date);
        tJeeblogTheme.setUpdateTime(date);
        return tJeeblogThemeDao.insert(tJeeblogTheme);
    }

    @Override
    public int insertBatch(List<TJeeblogThemeReq> list) {
      List<TJeeblogTheme> tJeeblogThemes = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400","执行批量插入的集合为空！");
        }
        for (TJeeblogThemeReq tJeeblogThemeReq : list) {
            TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
            if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400","执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
            tJeeblogThemes.add(tJeeblogTheme);
        }
        return tJeeblogThemeDao.insertBatch(tJeeblogThemes);
    }
    
    @Override
    public int update(TJeeblogThemeReq tJeeblogThemeReq) {
      TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
        tJeeblogTheme.setUpdateTime(new Date());
        return tJeeblogThemeDao.update(tJeeblogTheme);
    }
    
    @Override
    public int updateBatch(List<TJeeblogThemeReq> list) {
      List<TJeeblogTheme> tJeeblogThemes = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400","执行批量更新的集合为空！");
        }
        for (TJeeblogThemeReq tJeeblogThemeReq : list) {
            TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
            if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400","执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
            tJeeblogThemes.add(tJeeblogTheme);
        }
        return tJeeblogThemeDao.updateBatch(tJeeblogThemes);
    }

    @Override
    public int deleteById(Integer id) {
        return tJeeblogThemeDao.deleteById(id);
    }
    
    @Override
    public int deleteByEntity(TJeeblogThemeReq tJeeblogThemeReq) {
      TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
        return tJeeblogThemeDao.deleteByEntity(tJeeblogTheme);
    }
    
    @Override
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            throw new BusinessException("400","id集合不能为空！");
        }
        return tJeeblogThemeDao.deleteByIds(ids);
    }
    
    @Override
    public int countAll() {
        return tJeeblogThemeDao.countAll();
    }
    
    @Override
    public int countByEntity(TJeeblogThemeReq tJeeblogThemeReq) {
      TJeeblogTheme tJeeblogTheme = new TJeeblogTheme();
        if(ObjectUtils.checkObjAllFieldsIsNull(tJeeblogThemeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tJeeblogThemeReq,tJeeblogTheme);
        return tJeeblogThemeDao.countByEntity(tJeeblogTheme);
    }

}