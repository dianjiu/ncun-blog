package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogPluginReq;
import cn.org.dianjiu.common.pojo.resp.PageResp;
import cn.org.dianjiu.common.pojo.resp.TBlogPluginResp;
import cn.org.dianjiu.common.pojo.vo.RespVO;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.service.TBlogPluginServiceI;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 插件操作(TBlogPlugin)表控制层
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:29
 */
@RestController
@Api(value = "TBlogPlugin", tags = {"插件操作"})
@RequestMapping("/tBlogPlugin")
public class TBlogPluginController {

    /**
     * 服务对象
     */
    @Autowired
    private TBlogPluginServiceI tBlogPluginService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @ApiOperation("通过Id查询单个对象")
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogPluginResp> getById(@PathVariable Integer id) {
        RespVO<TBlogPluginResp> result = new RespVO<>();
        TBlogPluginResp tBlogPluginResp = tBlogPluginService.getById(id);
        if (null == tBlogPluginResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogPluginResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tBlogPluginReq
     * @return 实例对象
     */
    @ApiOperation("通过属性查询单个对象")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogPluginResp> getByEntity(TBlogPluginReq tBlogPluginReq) {
        RespVO<TBlogPluginResp> result = new RespVO<>();
        TBlogPluginResp tBlogPluginResp = tBlogPluginService.getByEntity(tBlogPluginReq);
        if (null == tBlogPluginResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogPluginResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tBlogPluginReq 实例对象
     * @return 对象列表
     */
    @ApiOperation("通过属性查询对象列表")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TBlogPluginReq tBlogPluginReq) {
        RespVO<List> result = new RespVO<>();
        List<TBlogPluginResp> tBlogPluginRespList = tBlogPluginService.listByEntity(tBlogPluginReq);
        if (null == tBlogPluginRespList || tBlogPluginRespList.isEmpty()) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tBlogPluginRespList);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param pageReq 实例对象
     * @return 对象列表
     */
    @ApiOperation(value = "分页获取对象列表", notes = "当前页和页大小必传")
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public RespVO<PageResp> listByPage(@RequestBody PageReq<TBlogPluginReq> pageReq) {
        PageResp<List<TBlogPluginResp>> pageVO = new PageResp<>();
        RespVO<PageResp> result = new RespVO<>();
        PageInfo<TBlogPluginResp> pages = tBlogPluginService.listByPage(pageReq);
        if (ObjectUtils.checkObjAllFieldsIsNull(pages)) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        pageVO.setTotal(pages.getTotal());
        pageVO.setPages(pages.getPages());
        pageVO.setPageNum(pages.getPageNum());
        pageVO.setPageSize(pages.getPageSize());
        pageVO.setData(pages.getList());
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(pageVO);
        return result;
    }

    /**
     * 新增实体属性不为null的记录
     *
     * @param tBlogPluginReq 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增对象记录")
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogPluginResp> insert(@RequestBody @Validated TBlogPluginReq tBlogPluginReq) {
        RespVO<TBlogPluginResp> result = new RespVO<>();
        int insert = tBlogPluginService.insert(tBlogPluginReq);
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
     * 新增实体属性不为null的多条记录
     *
     * @param list 对象集合
     * @return 实例对象
     */
    @ApiOperation("批量新增对象记录")
    @PostMapping(value = "/insertBatch", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogPluginResp> insertBatch(@RequestBody List<TBlogPluginReq> list) {
        RespVO<TBlogPluginResp> result = new RespVO<>();
        int insert = tBlogPluginService.insertBatch(list);
        if (insert < 1) {
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
     * @param tBlogPluginReq 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新对象记录")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogPluginResp> update(@RequestBody @Validated TBlogPluginReq tBlogPluginReq) {
        RespVO<TBlogPluginResp> result = new RespVO<>();
        int update = tBlogPluginService.update(tBlogPluginReq);
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
     * 通过ID主键删除数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @ApiOperation("删除一条对象记录")
    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogPluginResp> deleteOne(@PathVariable Integer id) {
        RespVO<TBlogPluginResp> result = new RespVO<>();
        int delete = tBlogPluginService.deleteById(id);
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
    @ApiOperation("批量删除对象记录")
    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogPluginResp> deleteBatch(@RequestBody List<Integer> ids) {
        RespVO<TBlogPluginResp> result = new RespVO<>();
        int dels = 0;
        if (ids != null && ids.size() > 0) {
            dels = tBlogPluginService.deleteByIds(ids);
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
