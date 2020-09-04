package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TBlogDao;

import java.util.List;

/**
 * (TBlog)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:10
 */
public interface TBlogServiceI {
     
    TBlogResp getById(Integer id);

    TBlogResp getByEntity(TBlogReq tBlogReq);

    List<TBlogResp> listByEntity(TBlogReq tBlogReq);

    List<TBlogResp> listByIds(List<Integer> ids);

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