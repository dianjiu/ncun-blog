package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.core.pojo.req.TBlogBaseReq;
import cn.org.dianjiu.core.pojo.resp.TBlogBaseResp;
import cn.org.dianjiu.core.pojo.vo.RespVO;
import cn.org.dianjiu.server.service.TBlogBaseServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TBlogBase)表控制层
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:55
 */
@RestController
@RequestMapping("/tBlogBase")
public class TBlogBaseController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TBlogBaseServiceI tBlogBaseService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogBaseResp> getById(@PathVariable Integer id) {
      RespVO<TBlogBaseResp> result = new RespVO<>();
        TBlogBaseResp tBlogBaseResp = tBlogBaseService.getById(id);
      if(null == tBlogBaseResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogBaseResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tBlogBaseReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogBaseResp> getByEntity(TBlogBaseReq tBlogBaseReq) {
      RespVO<TBlogBaseResp> result = new RespVO<>();
        TBlogBaseResp tBlogBaseResp = tBlogBaseService.getByEntity(tBlogBaseReq);
      if(null == tBlogBaseResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogBaseResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tBlogBaseReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TBlogBaseReq tBlogBaseReq) {
        RespVO<List> result = new RespVO<>();
      List<TBlogBaseResp> tBlogBaseRespList = tBlogBaseService.listByEntity(tBlogBaseReq);
        if(null == tBlogBaseRespList || tBlogBaseRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tBlogBaseRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tBlogBaseReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogBaseResp> insert(@RequestBody @Validated TBlogBaseReq tBlogBaseReq){
        RespVO<TBlogBaseResp> result = new RespVO<>();
      int insert = tBlogBaseService.insert(tBlogBaseReq);
        if(insert !=1 ){
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
     * @param tBlogBaseReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogBaseResp> update(@RequestBody @Validated TBlogBaseReq tBlogBaseReq){
        RespVO<TBlogBaseResp> result = new RespVO<>();
      int update = tBlogBaseService.update(tBlogBaseReq);
      if(update != 1){
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
    @DeleteMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogBaseResp> deleteOne(@PathVariable Integer id){
      RespVO<TBlogBaseResp> result = new RespVO<>();
        int delete = tBlogBaseService.deleteById(id);
      if(delete != 1){
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
    @DeleteMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogBaseResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TBlogBaseResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tBlogBaseService.deleteByIds(ids);
      }
      if(dels <= 0){
            result.setCode("400");
            result.setMsg("批量删除数据失败！");
            return result;
        }
        result.setCode("200");
        result.setMsg("批量删除数据成功！");
        return result;
    }

}