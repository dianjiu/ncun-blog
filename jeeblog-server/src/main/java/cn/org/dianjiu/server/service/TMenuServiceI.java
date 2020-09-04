package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TMenuDao;

import java.util.List;

/**
 * (TMenu)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:16
 */
public interface TMenuServiceI {
     
    TMenuResp getById(Integer id);

    TMenuResp getByEntity(TMenuReq tMenuReq);

    List<TMenuResp> listByEntity(TMenuReq tMenuReq);

    List<TMenuResp> listByIds(List<Integer> ids);

    int insert(TMenuReq tMenuReq);

    int insertBatch(List<TMenuReq> list);

    int update(TMenuReq tMenuReq);

    int updateBatch(List<TMenuReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TMenuReq tMenuReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TMenuReq tMenuReq);
}