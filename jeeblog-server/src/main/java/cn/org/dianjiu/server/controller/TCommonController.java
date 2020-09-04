package cn.org.dianjiu.server.controller;

    import cn.org.dianjiu.server.service.TCommonServiceI;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TCommon)表控制层
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
@RestController
@RequestMapping("/tCommon")
public class TCommonController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TCommonServiceI tCommonService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommonResp> getById(@PathVariable Integer id) {
      RespVO<TCommonResp> result = new RespVO<>();
        TCommonResp tCommonResp = tCommonService.getById(id);
      if(null == tCommonResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tCommonResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tCommonReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommonResp> getByEntity(TCommonReq tCommonReq) {
      RespVO<TCommonResp> result = new RespVO<>();
        TCommonResp tCommonResp = tCommonService.getByEntity(tCommonReq);
      if(null == tCommonResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tCommonResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tCommonReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TCommonReq tCommonReq) {
        RespVO<List> result = new RespVO<>();
      List<TCommonResp> tCommonRespList = tCommonService.listByEntity(tCommonReq);
        if(null == tCommonRespList || tCommonRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tCommonRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tCommonReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommonResp> insert(@RequestBody @Validated TCommonReq tCommonReq){
        RespVO<TCommonResp> result = new RespVO<>();
      int insert = tCommonService.insert(tCommonReq);
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
     * @param tCommonReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommonResp> update(@RequestBody @Validated TCommonReq tCommonReq){
        RespVO<TCommonResp> result = new RespVO<>();
      int update = tCommonService.update(tCommonReq);
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
    public RespVO<TCommonResp> deleteOne(@PathVariable Integer id){
      RespVO<TCommonResp> result = new RespVO<>();
        int delete = tCommonService.deleteById(id);
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
    public RespVO<TCommonResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TCommonResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tCommonService.deleteByIds(ids);
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