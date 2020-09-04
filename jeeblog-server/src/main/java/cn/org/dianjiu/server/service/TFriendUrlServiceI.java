package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TFriendUrlDao;

import java.util.List;

/**
 * (TFriendUrl)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
public interface TFriendUrlServiceI {
     
    TFriendUrlResp getById(Integer id);

    TFriendUrlResp getByEntity(TFriendUrlReq tFriendUrlReq);

    List<TFriendUrlResp> listByEntity(TFriendUrlReq tFriendUrlReq);

    List<TFriendUrlResp> listByIds(List<Integer> ids);

    int insert(TFriendUrlReq tFriendUrlReq);

    int insertBatch(List<TFriendUrlReq> list);

    int update(TFriendUrlReq tFriendUrlReq);

    int updateBatch(List<TFriendUrlReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TFriendUrlReq tFriendUrlReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TFriendUrlReq tFriendUrlReq);
}