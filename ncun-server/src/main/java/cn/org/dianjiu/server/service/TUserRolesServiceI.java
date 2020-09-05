package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.TUserRolesReq;
import cn.org.dianjiu.common.pojo.resp.TUserRolesResp;

import java.util.List;

/**
 * (TUserRoles)表服务接口
 *
 * @author makejava
 * @since 2020-09-05 21:33:30
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