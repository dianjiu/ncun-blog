package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TBlogLabelReq;
import cn.org.dianjiu.common.pojo.resp.PageResp;
import cn.org.dianjiu.common.pojo.resp.TBlogLabelResp;
import cn.org.dianjiu.common.pojo.vo.RespVO;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.service.TBlogLabelServiceI;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章标签(TBlogLabel)表控制层
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:25
 */
@RestController
@Api(value = "TBlogLabel", tags = {"文章标签"})
@RequestMapping("/tBlogLabel")
public class TBlogLabelController {

    /**
     * 服务对象
     */
    @Autowired
    private TBlogLabelServiceI tBlogLabelService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @ApiOperation("通过Id查询单个对象")
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogLabelResp> getById(@PathVariable Integer id) {
        RespVO<TBlogLabelResp> result = new RespVO<>();
        TBlogLabelResp tBlogLabelResp = tBlogLabelService.getById(id);
        if (null == tBlogLabelResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogLabelResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tBlogLabelReq
     * @return 实例对象
     */
    @ApiOperation("通过属性查询单个对象")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogLabelResp> getByEntity(TBlogLabelReq tBlogLabelReq) {
        RespVO<TBlogLabelResp> result = new RespVO<>();
        TBlogLabelResp tBlogLabelResp = tBlogLabelService.getByEntity(tBlogLabelReq);
        if (null == tBlogLabelResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogLabelResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tBlogLabelReq 实例对象
     * @return 对象列表
     */
    @ApiOperation("通过属性查询对象列表")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TBlogLabelReq tBlogLabelReq) {
        RespVO<List> result = new RespVO<>();
        List<TBlogLabelResp> tBlogLabelRespList = tBlogLabelService.listByEntity(tBlogLabelReq);
        if (null == tBlogLabelRespList || tBlogLabelRespList.isEmpty()) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tBlogLabelRespList);
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
    public RespVO<PageResp> listByPage(@RequestBody PageReq<TBlogLabelReq> pageReq) {
        PageResp<List<TBlogLabelResp>> pageVO = new PageResp<>();
        RespVO<PageResp> result = new RespVO<>();
        PageInfo<TBlogLabelResp> pages = tBlogLabelService.listByPage(pageReq);
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
     * @param tBlogLabelReq 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增对象记录")
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogLabelResp> insert(@RequestBody @Validated TBlogLabelReq tBlogLabelReq) {
        RespVO<TBlogLabelResp> result = new RespVO<>();
        int insert = tBlogLabelService.insert(tBlogLabelReq);
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
    public RespVO<TBlogLabelResp> insertBatch(@RequestBody List<TBlogLabelReq> list) {
        RespVO<TBlogLabelResp> result = new RespVO<>();
        int insert = tBlogLabelService.insertBatch(list);
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
     * @param tBlogLabelReq 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新对象记录")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogLabelResp> update(@RequestBody @Validated TBlogLabelReq tBlogLabelReq) {
        RespVO<TBlogLabelResp> result = new RespVO<>();
        int update = tBlogLabelService.update(tBlogLabelReq);
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
    public RespVO<TBlogLabelResp> deleteOne(@PathVariable Integer id) {
        RespVO<TBlogLabelResp> result = new RespVO<>();
        int delete = tBlogLabelService.deleteById(id);
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
    public RespVO<TBlogLabelResp> deleteBatch(@RequestBody List<Integer> ids) {
        RespVO<TBlogLabelResp> result = new RespVO<>();
        int dels = 0;
        if (ids != null && ids.size() > 0) {
            dels = tBlogLabelService.deleteByIds(ids);
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
