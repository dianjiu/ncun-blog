package cn.org.dianjiu.server.service;


import cn.org.dianjiu.core.pojo.req.TUserRolesReq;
import cn.org.dianjiu.core.pojo.resp.TUserRolesResp;

import java.util.List;

/**
 * (TUserRoles)表服务接口
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
public interface TUserRolesServiceI {
   
    TUserRolesResp getById(Integer id);

    TUserRolesResp getByEntity(TUserRolesReq tUserRolesReq);

    List<TUserRolesResp> listByEntity(TUserRolesReq tUserRolesReq);

    List<TUserRolesResp> listByIds(List<Integer> ids);

    int insert(TUserRolesReq tUserRolesReq);

    int insertBatch(List<TUserRolesReq> list);

    int update(TUserRolesReq tUserRolesReq);

    int updateBatch(List<TUserRolesReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TUserRolesReq tUserRolesReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TUserRolesReq tUserRolesReq);
}