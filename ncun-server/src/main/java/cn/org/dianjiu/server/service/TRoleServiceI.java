package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TRoleReq;
import cn.org.dianjiu.common.pojo.resp.TRoleResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 角色操作(TRole)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 18:38:45
 */
public interface TRoleServiceI {

    TRoleResp getById(Integer id);

    TRoleResp getByEntity(TRoleReq tRoleReq);

    List<TRoleResp> listByEntity(TRoleReq tRoleReq);

    List<TRoleResp> listByIds(List<Integer> ids);

    PageInfo<TRoleResp> listByPage(PageReq<TRoleReq> pageReq);

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