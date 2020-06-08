package cn.org.dianjiu.server.service;


import cn.org.dianjiu.core.pojo.req.TUserBaseReq;
import cn.org.dianjiu.core.pojo.resp.TUserBaseResp;

import java.util.List;

/**
 * (TUserBase)表服务接口
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
public interface TUserBaseServiceI {
   
    TUserBaseResp getById(Integer id);

    TUserBaseResp getByEntity(TUserBaseReq tUserBaseReq);

    List<TUserBaseResp> listByEntity(TUserBaseReq tUserBaseReq);

    List<TUserBaseResp> listByIds(List<Integer> ids);

    int insert(TUserBaseReq tUserBaseReq);

    int insertBatch(List<TUserBaseReq> list);

    int update(TUserBaseReq tUserBaseReq);

    int updateBatch(List<TUserBaseReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TUserBaseReq tUserBaseReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TUserBaseReq tUserBaseReq);
}