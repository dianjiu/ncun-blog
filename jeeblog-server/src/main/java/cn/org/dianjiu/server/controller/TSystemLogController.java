package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.core.pojo.req.TSystemLogReq;
import cn.org.dianjiu.core.pojo.resp.TSystemLogResp;
import cn.org.dianjiu.core.pojo.vo.RespVO;
import cn.org.dianjiu.server.service.TSystemLogServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TSystemLog)表控制层
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@RestController
@RequestMapping("/tSystemLog")
public class TSystemLogController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TSystemLogServiceI tSystemLogService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TSystemLogResp> getById(@PathVariable Integer id) {
      RespVO<TSystemLogResp> result = new RespVO<>();
        TSystemLogResp tSystemLogResp = tSystemLogService.getById(id);
      if(null == tSystemLogResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tSystemLogResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tSystemLogReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TSystemLogResp> getByEntity(TSystemLogReq tSystemLogReq) {
      RespVO<TSystemLogResp> result = new RespVO<>();
        TSystemLogResp tSystemLogResp = tSystemLogService.getByEntity(tSystemLogReq);
      if(null == tSystemLogResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tSystemLogResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tSystemLogReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TSystemLogReq tSystemLogReq) {
        RespVO<List> result = new RespVO<>();
      List<TSystemLogResp> tSystemLogRespList = tSystemLogService.listByEntity(tSystemLogReq);
        if(null == tSystemLogRespList || tSystemLogRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tSystemLogRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tSystemLogReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TSystemLogResp> insert(@RequestBody @Validated TSystemLogReq tSystemLogReq){
        RespVO<TSystemLogResp> result = new RespVO<>();
      int insert = tSystemLogService.insert(tSystemLogReq);
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
     * @param tSystemLogReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TSystemLogResp> update(@RequestBody @Validated TSystemLogReq tSystemLogReq){
        RespVO<TSystemLogResp> result = new RespVO<>();
      int update = tSystemLogService.update(tSystemLogReq);
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
    public RespVO<TSystemLogResp> deleteOne(@PathVariable Integer id){
      RespVO<TSystemLogResp> result = new RespVO<>();
        int delete = tSystemLogService.deleteById(id);
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
    public RespVO<TSystemLogResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TSystemLogResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tSystemLogService.deleteByIds(ids);
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