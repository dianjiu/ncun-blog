package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.common.pojo.req.TFileReq;
import cn.org.dianjiu.common.pojo.resp.TFileResp;
import cn.org.dianjiu.common.pojo.vo.RespVO;
import cn.org.dianjiu.server.service.TFileServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (TFile)表控制层
 *
 * @author makejava
 * @since 2020-09-05 21:30:48
 */
@RestController
@RequestMapping("/tFile")
public class TFileController {

    /**
     * 服务对象
     */
    @Autowired
    private TFileServiceI tFileService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFileResp> getById(@PathVariable Integer id) {
        RespVO<TFileResp> result = new RespVO<>();
        TFileResp tFileResp = tFileService.getById(id);
        if (null == tFileResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tFileResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tFileReq
     * @return 实例对象
     */
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFileResp> getByEntity(TFileReq tFileReq) {
        RespVO<TFileResp> result = new RespVO<>();
        TFileResp tFileResp = tFileService.getByEntity(tFileReq);
        if (null == tFileResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tFileResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tFileReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TFileReq tFileReq) {
        RespVO<List> result = new RespVO<>();
        List<TFileResp> tFileRespList = tFileService.listByEntity(tFileReq);
        if (null == tFileRespList || tFileRespList.isEmpty()) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tFileRespList);
        return result;
    }

    /**
     * 新增实体属性不为null的记录
     *
     * @param tFileReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFileResp> insert(@RequestBody @Validated TFileReq tFileReq) {
        RespVO<TFileResp> result = new RespVO<>();
        int insert = tFileService.insert(tFileReq);
        if (insert != 1) {
            result.setCode("400");
            result.setMsg("新增数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("新增数据成功！");
        return result;
    }

    /**
     * 通过表字段修改实体属性不为null的列
     *
     * @param tFileReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFileResp> update(@RequestBody @Validated TFileReq tFileReq) {
        RespVO<TFileResp> result = new RespVO<>();
        int update = tFileService.update(tFileReq);
        if (update != 1) {
            result.setCode("400");
            result.setMsg("更新数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("更新数据成功！");
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFileResp> deleteOne(@PathVariable Integer id) {
        RespVO<TFileResp> result = new RespVO<>();
        int delete = tFileService.deleteById(id);
        if (delete != 1) {
            result.setCode("400");
            result.setMsg("删除数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("删除数据成功！");
        return result;
    }

    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param ids 实例对象
     * @return 实例对象
     */
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFileResp> deleteBatch(@RequestBody List<Integer> ids) {
        RespVO<TFileResp> result = new RespVO<>();
        int dels = 0;
        if (ids != null && ids.size() > 0) {
            dels = tFileService.deleteByIds(ids);
        }
        if (dels <= 0) {
            result.setCode("400");
            result.setMsg("批量删除数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("批量删除数据成功！");
        return result;
    }

}