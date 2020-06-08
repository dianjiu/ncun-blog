package cn.org.dianjiu.server.service;


import cn.org.dianjiu.core.pojo.req.TBlogTypeReq;
import cn.org.dianjiu.core.pojo.resp.TBlogTypeResp;

import java.util.List;

/**
 * (TBlogType)表服务接口
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
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