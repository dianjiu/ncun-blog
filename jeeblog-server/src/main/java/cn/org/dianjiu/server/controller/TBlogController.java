package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.common.pojo.vo.RespVO;
import cn.org.dianjiu.common.pojo.vo.req.TBlogReq;
import cn.org.dianjiu.common.pojo.vo.resp.TBlogResp;
import cn.org.dianjiu.server.service.TBlogServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * (TBlog)表控制层
 *
 * @author makejava
 * @since 2020-09-04 15:06:11
 */
@RestController
@RequestMapping("/tBlog")
public class TBlogController {

    /**
     * 服务对象
     */
    @Autowired
    private TBlogServiceI tBlogService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogResp> getById(@PathVariable Integer id) {
        RespVO<TBlogResp> result = new RespVO<>();
        TBlogResp tBlogResp = tBlogService.getById(id);
        if (null == tBlogResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tBlogReq
     * @return 实例对象
     */
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogResp> getByEntity(TBlogReq tBlogReq) {
        RespVO<TBlogResp> result = new RespVO<>();
        TBlogResp tBlogResp = tBlogService.getByEntity(tBlogReq);
        if (null == tBlogResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tBlogReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TBlogReq tBlogReq) {
        RespVO<List> result = new RespVO<>();
        List<TBlogResp> tBlogRespList = tBlogService.listByEntity(tBlogReq);
        if (null == tBlogRespList || tBlogRespList.isEmpty()) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tBlogRespList);
        return result;
    }

    /**
     * 新增实体属性不为null的记录
     *
     * @param tBlogReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogResp> insert(@RequestBody @Validated TBlogReq tBlogReq) {
        RespVO<TBlogResp> result = new RespVO<>();
        int insert = tBlogService.insert(tBlogReq);
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
     * @param tBlogReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogResp> update(@RequestBody @Validated TBlogReq tBlogReq) {
        RespVO<TBlogResp> result = new RespVO<>();
        int update = tBlogService.update(tBlogReq);
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
    public RespVO<TBlogResp> deleteOne(@PathVariable Integer id) {
        RespVO<TBlogResp> result = new RespVO<>();
        int delete = tBlogService.deleteById(id);
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
    public RespVO<TBlogResp> deleteBatch(@RequestBody List<Integer> ids) {
        RespVO<TBlogResp> result = new RespVO<>();
        int dels = 0;
        if (ids != null && ids.size() > 0) {
            dels = tBlogService.deleteByIds(ids);
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