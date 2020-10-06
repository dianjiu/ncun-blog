package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TUserReq;
import cn.org.dianjiu.common.pojo.resp.TUserResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 用户操作(TUser)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 20:22:37
 */
public interface TUserServiceI {

    TUserResp getById(Integer id);

    TUserResp getByEntity(TUserReq tUserReq);

    List<TUserResp> listByEntity(TUserReq tUserReq);

    List<TUserResp> listByIds(List<Integer> ids);

    PageInfo<TUserResp> listByPage(PageReq<TUserReq> pageReq);

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