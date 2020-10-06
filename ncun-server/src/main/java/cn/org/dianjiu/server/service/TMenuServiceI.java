package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TMenuReq;
import cn.org.dianjiu.common.pojo.resp.TMenuResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 菜单操作(TMenu)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 18:38:42
 */
public interface TMenuServiceI {

    TMenuResp getById(Integer id);

    TMenuResp getByEntity(TMenuReq tMenuReq);

    List<TMenuResp> listByEntity(TMenuReq tMenuReq);

    List<TMenuResp> listByIds(List<Integer> ids);

    PageInfo<TMenuResp> listByPage(PageReq<TMenuReq> pageReq);

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