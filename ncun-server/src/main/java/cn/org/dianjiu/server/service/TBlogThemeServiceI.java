package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.TBlogThemeReq;
import cn.org.dianjiu.common.pojo.resp.TBlogThemeResp;

import java.util.List;

/**
 * (TBlogTheme)表服务接口
 *
 * @author makejava
 * @since 2020-09-05 21:30:20
 */
public interface TBlogThemeServiceI {

    TBlogThemeResp getById(Integer id);

    TBlogThemeResp getByEntity(TBlogThemeReq tBlogThemeReq);

    List<TBlogThemeResp> listByEntity(TBlogThemeReq tBlogThemeReq);

    List<TBlogThemeResp> listByIds(List<Integer> ids);

    int insert(TBlogThemeReq tBlogThemeReq);

    int insertBatch(List<TBlogThemeReq> list);

    int update(TBlogThemeReq tBlogThemeReq);

    int updateBatch(List<TBlogThemeReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TBlogThemeReq tBlogThemeReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TBlogThemeReq tBlogThemeReq);
}