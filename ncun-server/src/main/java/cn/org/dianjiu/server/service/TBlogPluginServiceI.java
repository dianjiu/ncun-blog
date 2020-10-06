package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogPluginReq;
import cn.org.dianjiu.common.pojo.resp.TBlogPluginResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 插件操作(TBlogPlugin)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 18:38:28
 */
public interface TBlogPluginServiceI {

    TBlogPluginResp getById(Integer id);

    TBlogPluginResp getByEntity(TBlogPluginReq tBlogPluginReq);

    List<TBlogPluginResp> listByEntity(TBlogPluginReq tBlogPluginReq);

    List<TBlogPluginResp> listByIds(List<Integer> ids);

    PageInfo<TBlogPluginResp> listByPage(PageReq<TBlogPluginReq> pageReq);

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