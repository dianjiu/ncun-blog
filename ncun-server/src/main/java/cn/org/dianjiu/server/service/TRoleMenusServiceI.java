package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TRoleMenusReq;
import cn.org.dianjiu.common.pojo.resp.TRoleMenusResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 角色菜单操作(TRoleMenus)表服务接口
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:10
 */
public interface TRoleMenusServiceI {

    TRoleMenusResp getById(Integer id);

    TRoleMenusResp getByEntity(TRoleMenusReq tRoleMenusReq);

    List<TRoleMenusResp> listByEntity(TRoleMenusReq tRoleMenusReq);

    List<TRoleMenusResp> listByIds(List<Integer> ids);

    PageInfo<TRoleMenusResp> listByPage(PageReq<TRoleMenusReq> pageReq);

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
