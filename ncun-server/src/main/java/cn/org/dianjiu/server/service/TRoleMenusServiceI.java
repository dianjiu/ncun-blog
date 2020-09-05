package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.TRoleMenusReq;
import cn.org.dianjiu.common.pojo.resp.TRoleMenusResp;

import java.util.List;

/**
 * (TRoleMenus)表服务接口
 *
 * @author makejava
 * @since 2020-09-05 21:31:11
 */
public interface TRoleMenusServiceI {

    TRoleMenusResp getById(Integer id);

    TRoleMenusResp getByEntity(TRoleMenusReq tRoleMenusReq);

    List<TRoleMenusResp> listByEntity(TRoleMenusReq tRoleMenusReq);

    List<TRoleMenusResp> listByIds(List<Integer> ids);

    int insert(TRoleMenusReq tRoleMenusReq);

    int insertBatch(List<TRoleMenusReq> list);

    int update(TRoleMenusReq tRoleMenusReq);

    int updateBatch(List<TRoleMenusReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TRoleMenusReq tRoleMenusReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TRoleMenusReq tRoleMenusReq);
}