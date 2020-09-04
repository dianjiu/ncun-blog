package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TJeeblogPluginDao;

import java.util.List;

/**
 * (TJeeblogPlugin)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
public interface TJeeblogPluginServiceI {
     
    TJeeblogPluginResp getById(Integer id);

    TJeeblogPluginResp getByEntity(TJeeblogPluginReq tJeeblogPluginReq);

    List<TJeeblogPluginResp> listByEntity(TJeeblogPluginReq tJeeblogPluginReq);

    List<TJeeblogPluginResp> listByIds(List<Integer> ids);

    int insert(TJeeblogPluginReq tJeeblogPluginReq);

    int insertBatch(List<TJeeblogPluginReq> list);

    int update(TJeeblogPluginReq tJeeblogPluginReq);

    int updateBatch(List<TJeeblogPluginReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TJeeblogPluginReq tJeeblogPluginReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TJeeblogPluginReq tJeeblogPluginReq);
}