package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogThemeReq;
import cn.org.dianjiu.common.pojo.resp.TBlogThemeResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 主题操作(TBlogTheme)表服务接口
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:06
 */
public interface TBlogThemeServiceI {

    TBlogThemeResp getById(Integer id);

    TBlogThemeResp getByEntity(TBlogThemeReq tBlogThemeReq);

    List<TBlogThemeResp> listByEntity(TBlogThemeReq tBlogThemeReq);

    List<TBlogThemeResp> listByIds(List<Integer> ids);

    PageInfo<TBlogThemeResp> listByPage(PageReq<TBlogThemeReq> pageReq);

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
