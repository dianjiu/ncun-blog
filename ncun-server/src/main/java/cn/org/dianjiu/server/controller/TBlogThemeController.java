package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.common.pojo.req.TBlogThemeReq;
import cn.org.dianjiu.common.pojo.resp.TBlogThemeResp;
import cn.org.dianjiu.common.pojo.vo.RespVO;
import cn.org.dianjiu.server.service.TBlogThemeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (TBlogTheme)表控制层
 *
 * @author makejava
 * @since 2020-09-05 21:30:22
 */
@RestController
@RequestMapping("/tBlogTheme")
public class TBlogThemeController {

    /**
     * 服务对象
     */
    @Autowired
    private TBlogThemeServiceI tBlogThemeService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogThemeResp> getById(@PathVariable Integer id) {
        RespVO<TBlogThemeResp> result = new RespVO<>();
        TBlogThemeResp tBlogThemeResp = tBlogThemeService.getById(id);
        if (null == tBlogThemeResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogThemeResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tBlogThemeReq
     * @return 实例对象
     */
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogThemeResp> getByEntity(TBlogThemeReq tBlogThemeReq) {
        RespVO<TBlogThemeResp> result = new RespVO<>();
        TBlogThemeResp tBlogThemeResp = tBlogThemeService.getByEntity(tBlogThemeReq);
        if (null == tBlogThemeResp) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogThemeResp);
        return result;
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tBlogThemeReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TBlogThemeReq tBlogThemeReq) {
        RespVO<List> result = new RespVO<>();
        List<TBlogThemeResp> tBlogThemeRespList = tBlogThemeService.listByEntity(tBlogThemeReq);
        if (null == tBlogThemeRespList || tBlogThemeRespList.isEmpty()) {
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tBlogThemeRespList);
        return result;
    }

    /**
     * 新增实体属性不为null的记录
     *
     * @param tBlogThemeReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogThemeResp> insert(@RequestBody @Validated TBlogThemeReq tBlogThemeReq) {
        RespVO<TBlogThemeResp> result = new RespVO<>();
        int insert = tBlogThemeService.insert(tBlogThemeReq);
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
     * @param tBlogThemeReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogThemeResp> update(@RequestBody @Validated TBlogThemeReq tBlogThemeReq) {
        RespVO<TBlogThemeResp> result = new RespVO<>();
        int update = tBlogThemeService.update(tBlogThemeReq);
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
    public RespVO<TBlogThemeResp> deleteOne(@PathVariable Integer id) {
        RespVO<TBlogThemeResp> result = new RespVO<>();
        int delete = tBlogThemeService.deleteById(id);
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
    public RespVO<TBlogThemeResp> deleteBatch(@RequestBody List<Integer> ids) {
        RespVO<TBlogThemeResp> result = new RespVO<>();
        int dels = 0;
        if (ids != null && ids.size() > 0) {
            dels = tBlogThemeService.deleteByIds(ids);
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