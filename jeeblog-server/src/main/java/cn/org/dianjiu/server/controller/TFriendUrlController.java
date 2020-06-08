package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.core.pojo.req.TFriendUrlReq;
import cn.org.dianjiu.core.pojo.resp.TFriendUrlResp;
import cn.org.dianjiu.core.pojo.vo.RespVO;
import cn.org.dianjiu.server.service.TFriendUrlServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TFriendUrl)表控制层
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@RestController
@RequestMapping("/tFriendUrl")
public class TFriendUrlController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TFriendUrlServiceI tFriendUrlService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFriendUrlResp> getById(@PathVariable Integer id) {
      RespVO<TFriendUrlResp> result = new RespVO<>();
        TFriendUrlResp tFriendUrlResp = tFriendUrlService.getById(id);
      if(null == tFriendUrlResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tFriendUrlResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tFriendUrlReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFriendUrlResp> getByEntity(TFriendUrlReq tFriendUrlReq) {
      RespVO<TFriendUrlResp> result = new RespVO<>();
        TFriendUrlResp tFriendUrlResp = tFriendUrlService.getByEntity(tFriendUrlReq);
      if(null == tFriendUrlResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tFriendUrlResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tFriendUrlReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TFriendUrlReq tFriendUrlReq) {
        RespVO<List> result = new RespVO<>();
      List<TFriendUrlResp> tFriendUrlRespList = tFriendUrlService.listByEntity(tFriendUrlReq);
        if(null == tFriendUrlRespList || tFriendUrlRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tFriendUrlRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tFriendUrlReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFriendUrlResp> insert(@RequestBody @Validated TFriendUrlReq tFriendUrlReq){
        RespVO<TFriendUrlResp> result = new RespVO<>();
      int insert = tFriendUrlService.insert(tFriendUrlReq);
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
     * @param tFriendUrlReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TFriendUrlResp> update(@RequestBody @Validated TFriendUrlReq tFriendUrlReq){
        RespVO<TFriendUrlResp> result = new RespVO<>();
      int update = tFriendUrlService.update(tFriendUrlReq);
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
    public RespVO<TFriendUrlResp> deleteOne(@PathVariable Integer id){
      RespVO<TFriendUrlResp> result = new RespVO<>();
        int delete = tFriendUrlService.deleteById(id);
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
    public RespVO<TFriendUrlResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TFriendUrlResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tFriendUrlService.deleteByIds(ids);
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