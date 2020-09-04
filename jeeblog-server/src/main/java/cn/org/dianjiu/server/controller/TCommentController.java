package cn.org.dianjiu.server.controller;

    import cn.org.dianjiu.server.service.TCommentServiceI;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TComment)表控制层
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
@RestController
@RequestMapping("/tComment")
public class TCommentController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TCommentServiceI tCommentService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentResp> getById(@PathVariable Integer id) {
      RespVO<TCommentResp> result = new RespVO<>();
        TCommentResp tCommentResp = tCommentService.getById(id);
      if(null == tCommentResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tCommentResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tCommentReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentResp> getByEntity(TCommentReq tCommentReq) {
      RespVO<TCommentResp> result = new RespVO<>();
        TCommentResp tCommentResp = tCommentService.getByEntity(tCommentReq);
      if(null == tCommentResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tCommentResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tCommentReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TCommentReq tCommentReq) {
        RespVO<List> result = new RespVO<>();
      List<TCommentResp> tCommentRespList = tCommentService.listByEntity(tCommentReq);
        if(null == tCommentRespList || tCommentRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tCommentRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tCommentReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentResp> insert(@RequestBody @Validated TCommentReq tCommentReq){
        RespVO<TCommentResp> result = new RespVO<>();
      int insert = tCommentService.insert(tCommentReq);
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
     * @param tCommentReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentResp> update(@RequestBody @Validated TCommentReq tCommentReq){
        RespVO<TCommentResp> result = new RespVO<>();
      int update = tCommentService.update(tCommentReq);
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
    public RespVO<TCommentResp> deleteOne(@PathVariable Integer id){
      RespVO<TCommentResp> result = new RespVO<>();
        int delete = tCommentService.deleteById(id);
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
    public RespVO<TCommentResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TCommentResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tCommentService.deleteByIds(ids);
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