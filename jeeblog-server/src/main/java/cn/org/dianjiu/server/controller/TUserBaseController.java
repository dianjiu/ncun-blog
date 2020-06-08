package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.core.pojo.req.TUserBaseReq;
import cn.org.dianjiu.core.pojo.resp.TUserBaseResp;
import cn.org.dianjiu.core.pojo.vo.RespVO;
import cn.org.dianjiu.server.service.TUserBaseServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TUserBase)表控制层
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@RestController
@RequestMapping("/tUserBase")
public class TUserBaseController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TUserBaseServiceI tUserBaseService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TUserBaseResp> getById(@PathVariable Integer id) {
      RespVO<TUserBaseResp> result = new RespVO<>();
        TUserBaseResp tUserBaseResp = tUserBaseService.getById(id);
      if(null == tUserBaseResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tUserBaseResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tUserBaseReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TUserBaseResp> getByEntity(TUserBaseReq tUserBaseReq) {
      RespVO<TUserBaseResp> result = new RespVO<>();
        TUserBaseResp tUserBaseResp = tUserBaseService.getByEntity(tUserBaseReq);
      if(null == tUserBaseResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tUserBaseResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tUserBaseReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TUserBaseReq tUserBaseReq) {
        RespVO<List> result = new RespVO<>();
      List<TUserBaseResp> tUserBaseRespList = tUserBaseService.listByEntity(tUserBaseReq);
        if(null == tUserBaseRespList || tUserBaseRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tUserBaseRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tUserBaseReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TUserBaseResp> insert(@RequestBody @Validated TUserBaseReq tUserBaseReq){
        RespVO<TUserBaseResp> result = new RespVO<>();
      int insert = tUserBaseService.insert(tUserBaseReq);
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
     * @param tUserBaseReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TUserBaseResp> update(@RequestBody @Validated TUserBaseReq tUserBaseReq){
        RespVO<TUserBaseResp> result = new RespVO<>();
      int update = tUserBaseService.update(tUserBaseReq);
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
    public RespVO<TUserBaseResp> deleteOne(@PathVariable Integer id){
      RespVO<TUserBaseResp> result = new RespVO<>();
        int delete = tUserBaseService.deleteById(id);
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
    public RespVO<TUserBaseResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TUserBaseResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tUserBaseService.deleteByIds(ids);
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