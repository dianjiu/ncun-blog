package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.TBlogTypeReq;
import cn.org.dianjiu.common.pojo.resp.TBlogTypeResp;

import java.util.List;

/**
 * (TBlogType)表服务接口
 *
 * @author makejava
 * @since 2020-09-05 21:30:26
 */
public interface TBlogTypeServiceI {

    TBlogTypeResp getById(Integer id);

    TBlogTypeResp getByEntity(TBlogTypeReq tBlogTypeReq);

    List<TBlogTypeResp> listByEntity(TBlogTypeReq tBlogTypeReq);

    List<TBlogTypeResp> listByIds(List<Integer> ids);

    int insert(TBlogTypeReq tBlogTypeReq);

    int insertBatch(List<TBlogTypeReq> list);

    int update(TBlogTypeReq tBlogTypeReq);

    int updateBatch(List<TBlogTypeReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TBlogTypeReq tBlogTypeReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TBlogTypeReq tBlogTypeReq);
}