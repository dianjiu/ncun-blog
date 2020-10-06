package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TFriendUrlReq;
import cn.org.dianjiu.common.pojo.resp.TFriendUrlResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 友链操作(TFriendUrl)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 20:22:29
 */
public interface TFriendUrlServiceI {

    TFriendUrlResp getById(Integer id);

    TFriendUrlResp getByEntity(TFriendUrlReq tFriendUrlReq);

    List<TFriendUrlResp> listByEntity(TFriendUrlReq tFriendUrlReq);

    List<TFriendUrlResp> listByIds(List<Integer> ids);

    PageInfo<TFriendUrlResp> listByPage(PageReq<TFriendUrlReq> pageReq);

    int insert(TFriendUrlReq tFriendUrlReq);

    int insertBatch(List<TFriendUrlReq> list);

    int update(TFriendUrlReq tFriendUrlReq);

    int updateBatch(List<TFriendUrlReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TFriendUrlReq tFriendUrlReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TFriendUrlReq tFriendUrlReq);
}