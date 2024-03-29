package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TCommentReq;
import cn.org.dianjiu.common.pojo.resp.TCommentResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 评论操作(TComment)表服务接口
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:07
 */
public interface TCommentServiceI {

    TCommentResp getById(Integer id);

    TCommentResp getByEntity(TCommentReq tCommentReq);

    List<TCommentResp> listByEntity(TCommentReq tCommentReq);

    List<TCommentResp> listByIds(List<Integer> ids);

    PageInfo<TCommentResp> listByPage(PageReq<TCommentReq> pageReq);

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
