package cn.org.dianjiu.server.controller;

    import cn.org.dianjiu.server.service.TBlogTypeServiceI;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TBlogType)表控制层
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
@RestController
@RequestMapping("/tBlogType")
public class TBlogTypeController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TBlogTypeServiceI tBlogTypeService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogTypeResp> getById(@PathVariable Integer id) {
      RespVO<TBlogTypeResp> result = new RespVO<>();
        TBlogTypeResp tBlogTypeResp = tBlogTypeService.getById(id);
      if(null == tBlogTypeResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogTypeResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tBlogTypeReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogTypeResp> getByEntity(TBlogTypeReq tBlogTypeReq) {
      RespVO<TBlogTypeResp> result = new RespVO<>();
        TBlogTypeResp tBlogTypeResp = tBlogTypeService.getByEntity(tBlogTypeReq);
      if(null == tBlogTypeResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tBlogTypeResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tBlogTypeReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TBlogTypeReq tBlogTypeReq) {
        RespVO<List> result = new RespVO<>();
      List<TBlogTypeResp> tBlogTypeRespList = tBlogTypeService.listByEntity(tBlogTypeReq);
        if(null == tBlogTypeRespList || tBlogTypeRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tBlogTypeRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tBlogTypeReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogTypeResp> insert(@RequestBody @Validated TBlogTypeReq tBlogTypeReq){
        RespVO<TBlogTypeResp> result = new RespVO<>();
      int insert = tBlogTypeService.insert(tBlogTypeReq);
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
     * @param tBlogTypeReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TBlogTypeResp> update(@RequestBody @Validated TBlogTypeReq tBlogTypeReq){
        RespVO<TBlogTypeResp> result = new RespVO<>();
      int update = tBlogTypeService.update(tBlogTypeReq);
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
    public RespVO<TBlogTypeResp> deleteOne(@PathVariable Integer id){
      RespVO<TBlogTypeResp> result = new RespVO<>();
        int delete = tBlogTypeService.deleteById(id);
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
    public RespVO<TBlogTypeResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TBlogTypeResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tBlogTypeService.deleteByIds(ids);
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