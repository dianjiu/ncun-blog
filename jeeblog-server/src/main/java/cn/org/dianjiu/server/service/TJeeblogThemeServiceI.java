package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TJeeblogThemeDao;

import java.util.List;

/**
 * (TJeeblogTheme)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:16
 */
public interface TJeeblogThemeServiceI {
     
    TJeeblogThemeResp getById(Integer id);

    TJeeblogThemeResp getByEntity(TJeeblogThemeReq tJeeblogThemeReq);

    List<TJeeblogThemeResp> listByEntity(TJeeblogThemeReq tJeeblogThemeReq);

    List<TJeeblogThemeResp> listByIds(List<Integer> ids);

    int insert(TJeeblogThemeReq tJeeblogThemeReq);

    int insertBatch(List<TJeeblogThemeReq> list);

    int update(TJeeblogThemeReq tJeeblogThemeReq);

    int updateBatch(List<TJeeblogThemeReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TJeeblogThemeReq tJeeblogThemeReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TJeeblogThemeReq tJeeblogThemeReq);
}