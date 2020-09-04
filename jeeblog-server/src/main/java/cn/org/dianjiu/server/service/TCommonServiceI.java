package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TCommonDao;

import java.util.List;

/**
 * (TCommon)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
public interface TCommonServiceI {
     
    TCommonResp getById(Integer id);

    TCommonResp getByEntity(TCommonReq tCommonReq);

    List<TCommonResp> listByEntity(TCommonReq tCommonReq);

    List<TCommonResp> listByIds(List<Integer> ids);

    int insert(TCommonReq tCommonReq);

    int insertBatch(List<TCommonReq> list);

    int update(TCommonReq tCommonReq);

    int updateBatch(List<TCommonReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TCommonReq tCommonReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TCommonReq tCommonReq);
}