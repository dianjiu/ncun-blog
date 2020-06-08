package cn.org.dianjiu.server.service;


import cn.org.dianjiu.core.pojo.req.TCommentBaseReq;
import cn.org.dianjiu.core.pojo.resp.TCommentBaseResp;

import java.util.List;

/**
 * (TCommentBase)表服务接口
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
public interface TCommentBaseServiceI {
   
    TCommentBaseResp getById(Integer id);

    TCommentBaseResp getByEntity(TCommentBaseReq tCommentBaseReq);

    List<TCommentBaseResp> listByEntity(TCommentBaseReq tCommentBaseReq);

    List<TCommentBaseResp> listByIds(List<Integer> ids);

    int insert(TCommentBaseReq tCommentBaseReq);

    int insertBatch(List<TCommentBaseReq> list);

    int update(TCommentBaseReq tCommentBaseReq);

    int updateBatch(List<TCommentBaseReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TCommentBaseReq tCommentBaseReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TCommentBaseReq tCommentBaseReq);
}