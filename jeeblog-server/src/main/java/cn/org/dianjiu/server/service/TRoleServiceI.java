package cn.org.dianjiu.server.service;


import cn.org.dianjiu.core.pojo.req.TRoleReq;
import cn.org.dianjiu.core.pojo.resp.TRoleResp;

import java.util.List;

/**
 * (TRole)表服务接口
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
public interface TRoleServiceI {
   
    TRoleResp getById(Integer id);

    TRoleResp getByEntity(TRoleReq tRoleReq);

    List<TRoleResp> listByEntity(TRoleReq tRoleReq);

    List<TRoleResp> listByIds(List<Integer> ids);

    int insert(TRoleReq tRoleReq);

    int insertBatch(List<TRoleReq> list);

    int update(TRoleReq tRoleReq);

    int updateBatch(List<TRoleReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TRoleReq tRoleReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TRoleReq tRoleReq);
}