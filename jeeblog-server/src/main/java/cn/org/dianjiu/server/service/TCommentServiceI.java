package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TCommentDao;

import java.util.List;

/**
 * (TComment)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
public interface TCommentServiceI {
     
    TCommentResp getById(Integer id);

    TCommentResp getByEntity(TCommentReq tCommentReq);

    List<TCommentResp> listByEntity(TCommentReq tCommentReq);

    List<TCommentResp> listByIds(List<Integer> ids);

    int insert(TCommentReq tCommentReq);

    int insertBatch(List<TCommentReq> list);

    int update(TCommentReq tCommentReq);

    int updateBatch(List<TCommentReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TCommentReq tCommentReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TCommentReq tCommentReq);
}