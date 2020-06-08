package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.core.pojo.req.TCommentBaseReq;
import cn.org.dianjiu.core.pojo.resp.TCommentBaseResp;
import cn.org.dianjiu.core.pojo.vo.RespVO;
import cn.org.dianjiu.server.service.TCommentBaseServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TCommentBase)表控制层
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@RestController
@RequestMapping("/tCommentBase")
public class TCommentBaseController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TCommentBaseServiceI tCommentBaseService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentBaseResp> getById(@PathVariable Integer id) {
      RespVO<TCommentBaseResp> result = new RespVO<>();
        TCommentBaseResp tCommentBaseResp = tCommentBaseService.getById(id);
      if(null == tCommentBaseResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tCommentBaseResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tCommentBaseReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentBaseResp> getByEntity(TCommentBaseReq tCommentBaseReq) {
      RespVO<TCommentBaseResp> result = new RespVO<>();
        TCommentBaseResp tCommentBaseResp = tCommentBaseService.getByEntity(tCommentBaseReq);
      if(null == tCommentBaseResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tCommentBaseResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tCommentBaseReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TCommentBaseReq tCommentBaseReq) {
        RespVO<List> result = new RespVO<>();
      List<TCommentBaseResp> tCommentBaseRespList = tCommentBaseService.listByEntity(tCommentBaseReq);
        if(null == tCommentBaseRespList || tCommentBaseRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tCommentBaseRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tCommentBaseReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentBaseResp> insert(@RequestBody @Validated TCommentBaseReq tCommentBaseReq){
        RespVO<TCommentBaseResp> result = new RespVO<>();
      int insert = tCommentBaseService.insert(tCommentBaseReq);
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
     * @param tCommentBaseReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TCommentBaseResp> update(@RequestBody @Validated TCommentBaseReq tCommentBaseReq){
        RespVO<TCommentBaseResp> result = new RespVO<>();
      int update = tCommentBaseService.update(tCommentBaseReq);
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
    public RespVO<TCommentBaseResp> deleteOne(@PathVariable Integer id){
      RespVO<TCommentBaseResp> result = new RespVO<>();
        int delete = tCommentBaseService.deleteById(id);
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
    public RespVO<TCommentBaseResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TCommentBaseResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tCommentBaseService.deleteByIds(ids);
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