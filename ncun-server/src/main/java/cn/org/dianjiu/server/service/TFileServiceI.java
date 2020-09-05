package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.TFileReq;
import cn.org.dianjiu.common.pojo.resp.TFileResp;

import java.util.List;

/**
 * (TFile)表服务接口
 *
 * @author makejava
 * @since 2020-09-05 21:30:46
 */
public interface TFileServiceI {

    TFileResp getById(Integer id);

    TFileResp getByEntity(TFileReq tFileReq);

    List<TFileResp> listByEntity(TFileReq tFileReq);

    List<TFileResp> listByIds(List<Integer> ids);

    int insert(TFileReq tFileReq);

    int insertBatch(List<TFileReq> list);

    int update(TFileReq tFileReq);

    int updateBatch(List<TFileReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TFileReq tFileReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TFileReq tFileReq);
}