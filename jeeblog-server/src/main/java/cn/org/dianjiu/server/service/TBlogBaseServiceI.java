package cn.org.dianjiu.server.service;


import cn.org.dianjiu.core.pojo.req.TBlogBaseReq;
import cn.org.dianjiu.core.pojo.resp.TBlogBaseResp;

import java.util.List;

/**
 * (TBlogBase)表服务接口
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:54
 */
public interface TBlogBaseServiceI {
   
    TBlogBaseResp getById(Integer id);

    TBlogBaseResp getByEntity(TBlogBaseReq tBlogBaseReq);

    List<TBlogBaseResp> listByEntity(TBlogBaseReq tBlogBaseReq);

    List<TBlogBaseResp> listByIds(List<Integer> ids);

    int insert(TBlogBaseReq tBlogBaseReq);

    int insertBatch(List<TBlogBaseReq> list);

    int update(TBlogBaseReq tBlogBaseReq);

    int updateBatch(List<TBlogBaseReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TBlogBaseReq tBlogBaseReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TBlogBaseReq tBlogBaseReq);
}