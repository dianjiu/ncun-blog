package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TCommonReq;
import cn.org.dianjiu.common.pojo.resp.TCommonResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 字典操作(TCommon)表服务接口
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:07
 */
public interface TCommonServiceI {

    TCommonResp getById(Integer id);

    TCommonResp getByEntity(TCommonReq tCommonReq);

    List<TCommonResp> listByEntity(TCommonReq tCommonReq);

    List<TCommonResp> listByIds(List<Integer> ids);

    PageInfo<TCommonResp> listByPage(PageReq<TCommonReq> pageReq);

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
