package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogTypeReq;
import cn.org.dianjiu.common.pojo.resp.TBlogTypeResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分类操作(TBlogType)表服务接口
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:06
 */
public interface TBlogTypeServiceI {

    TBlogTypeResp getById(Integer id);

    TBlogTypeResp getByEntity(TBlogTypeReq tBlogTypeReq);

    List<TBlogTypeResp> listByEntity(TBlogTypeReq tBlogTypeReq);

    List<TBlogTypeResp> listByIds(List<Integer> ids);

    PageInfo<TBlogTypeResp> listByPage(PageReq<TBlogTypeReq> pageReq);

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
