package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.TBlogPluginReq;
import cn.org.dianjiu.common.pojo.resp.TBlogPluginResp;

import java.util.List;

/**
 * (TBlogPlugin)表服务接口
 *
 * @author makejava
 * @since 2020-09-05 21:30:13
 */
public interface TBlogPluginServiceI {

    TBlogPluginResp getById(Integer id);

    TBlogPluginResp getByEntity(TBlogPluginReq tBlogPluginReq);

    List<TBlogPluginResp> listByEntity(TBlogPluginReq tBlogPluginReq);

    List<TBlogPluginResp> listByIds(List<Integer> ids);

    int insert(TBlogPluginReq tBlogPluginReq);

    int insertBatch(List<TBlogPluginReq> list);

    int update(TBlogPluginReq tBlogPluginReq);

    int updateBatch(List<TBlogPluginReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TBlogPluginReq tBlogPluginReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TBlogPluginReq tBlogPluginReq);
}