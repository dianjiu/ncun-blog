package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogReq;
import cn.org.dianjiu.common.pojo.resp.TBlogResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 博客操作(TBlog)表服务接口
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:02
 */
public interface TBlogServiceI {

    TBlogResp getById(Integer id);

    TBlogResp getByEntity(TBlogReq tBlogReq);

    List<TBlogResp> listByEntity(TBlogReq tBlogReq);

    List<TBlogResp> listByIds(List<Integer> ids);

    PageInfo<TBlogResp> listByPage(PageReq<TBlogReq> pageReq);

    int insert(TBlogReq tBlogReq);

    int insertBatch(List<TBlogReq> list);

    int update(TBlogReq tBlogReq);

    int updateBatch(List<TBlogReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TBlogReq tBlogReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TBlogReq tBlogReq);
}
