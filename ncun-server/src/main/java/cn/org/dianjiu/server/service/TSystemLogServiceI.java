package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TSystemLogReq;
import cn.org.dianjiu.common.pojo.resp.TSystemLogResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 日志操作(TSystemLog)表服务接口
 *
 * @author dianjiu
 * @since 2021-06-11 11:38:44
 */
public interface TSystemLogServiceI {

    TSystemLogResp getById(Integer id);

    TSystemLogResp getByEntity(TSystemLogReq tSystemLogReq);

    List<TSystemLogResp> listByEntity(TSystemLogReq tSystemLogReq);

    List<TSystemLogResp> listByIds(List<Integer> ids);

    PageInfo<TSystemLogResp> listByPage(PageReq<TSystemLogReq> pageReq);

    int insert(TSystemLogReq tSystemLogReq);

    int insertBatch(List<TSystemLogReq> list);

    int update(TSystemLogReq tSystemLogReq);

    int updateBatch(List<TSystemLogReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TSystemLogReq tSystemLogReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TSystemLogReq tSystemLogReq);
}
