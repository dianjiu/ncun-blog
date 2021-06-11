package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogLabelReq;
import cn.org.dianjiu.common.pojo.resp.TBlogLabelResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 文章标签(TBlogLabel)表服务接口
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:25
 */
public interface TBlogLabelServiceI {

    TBlogLabelResp getById(Integer id);

    TBlogLabelResp getByEntity(TBlogLabelReq tBlogLabelReq);

    List<TBlogLabelResp> listByEntity(TBlogLabelReq tBlogLabelReq);

    List<TBlogLabelResp> listByIds(List<Integer> ids);

    PageInfo<TBlogLabelResp> listByPage(PageReq<TBlogLabelReq> pageReq);

    int insert(TBlogLabelReq tBlogLabelReq);

    int insertBatch(List<TBlogLabelReq> list);

    int update(TBlogLabelReq tBlogLabelReq);

    int updateBatch(List<TBlogLabelReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TBlogLabelReq tBlogLabelReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TBlogLabelReq tBlogLabelReq);
}
