package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TUserDao;

import java.util.List;

/**
 * (TUser)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
 */
public interface TUserServiceI {
     
    TUserResp getById(Integer id);

    TUserResp getByEntity(TUserReq tUserReq);

    List<TUserResp> listByEntity(TUserReq tUserReq);

    List<TUserResp> listByIds(List<Integer> ids);

    int insert(TUserReq tUserReq);

    int insertBatch(List<TUserReq> list);

    int update(TUserReq tUserReq);

    int updateBatch(List<TUserReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TUserReq tUserReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TUserReq tUserReq);
}