package cn.org.dianjiu.server.service;


import cn.org.dianjiu.core.pojo.req.TCommonBaseReq;
import cn.org.dianjiu.core.pojo.resp.TCommonBaseResp;

import java.util.List;

/**
 * (TCommonBase)表服务接口
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
public interface TCommonBaseServiceI {
   
    TCommonBaseResp getById(Integer id);

    TCommonBaseResp getByEntity(TCommonBaseReq tCommonBaseReq);

    List<TCommonBaseResp> listByEntity(TCommonBaseReq tCommonBaseReq);

    List<TCommonBaseResp> listByIds(List<Integer> ids);

    int insert(TCommonBaseReq tCommonBaseReq);

    int insertBatch(List<TCommonBaseReq> list);

    int update(TCommonBaseReq tCommonBaseReq);

    int updateBatch(List<TCommonBaseReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TCommonBaseReq tCommonBaseReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TCommonBaseReq tCommonBaseReq);
}