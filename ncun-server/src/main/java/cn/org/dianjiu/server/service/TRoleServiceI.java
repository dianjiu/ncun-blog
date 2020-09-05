package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.TRoleReq;
import cn.org.dianjiu.common.pojo.resp.TRoleResp;

import java.util.List;

/**
 * (TRole)表服务接口
 *
 * @author makejava
 * @since 2020-09-05 21:31:05
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