package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TFileReq;
import cn.org.dianjiu.common.pojo.resp.TFileResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 文件操作(TFile)表服务接口
 *
 * @author dianjiu
 * @since 2021-05-08 18:15:08
 */
public interface TFileServiceI {

    TFileResp getById(Integer id);

    TFileResp getByEntity(TFileReq tFileReq);

    List<TFileResp> listByEntity(TFileReq tFileReq);

    List<TFileResp> listByIds(List<Integer> ids);

    PageInfo<TFileResp> listByPage(PageReq<TFileReq> pageReq);

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
