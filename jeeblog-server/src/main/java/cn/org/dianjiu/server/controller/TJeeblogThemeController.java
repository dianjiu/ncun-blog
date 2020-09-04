package cn.org.dianjiu.server.controller;

    import cn.org.dianjiu.server.service.TJeeblogThemeServiceI;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * (TJeeblogTheme)表控制层
 *
 * @author makejava
 * @since 2020-09-04 15:06:16
 */
@RestController
@RequestMapping("/tJeeblogTheme")
public class TJeeblogThemeController {
    
    /**
     * 服务对象
     */
    @Autowired
    private TJeeblogThemeServiceI tJeeblogThemeService;

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TJeeblogThemeResp> getById(@PathVariable Integer id) {
      RespVO<TJeeblogThemeResp> result = new RespVO<>();
        TJeeblogThemeResp tJeeblogThemeResp = tJeeblogThemeService.getById(id);
      if(null == tJeeblogThemeResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tJeeblogThemeResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tJeeblogThemeReq
     * @return 实例对象
     */
    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TJeeblogThemeResp> getByEntity(TJeeblogThemeReq tJeeblogThemeReq) {
      RespVO<TJeeblogThemeResp> result = new RespVO<>();
        TJeeblogThemeResp tJeeblogThemeResp = tJeeblogThemeService.getByEntity(tJeeblogThemeReq);
      if(null == tJeeblogThemeResp){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("查询成功！");
        result.setData(tJeeblogThemeResp);
        return result;
   }

   /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tJeeblogThemeReq 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<List> list(TJeeblogThemeReq tJeeblogThemeReq) {
        RespVO<List> result = new RespVO<>();
      List<TJeeblogThemeResp> tJeeblogThemeRespList = tJeeblogThemeService.listByEntity(tJeeblogThemeReq);
        if(null == tJeeblogThemeRespList || tJeeblogThemeRespList.isEmpty()){
            result.setCode("400");
            result.setMsg("没有查到数据！");
            return result;
        }
        result.setCode("200");
        result.setMsg("请求成功！");
        result.setData(tJeeblogThemeRespList);
        return result;
    }

   /**
     * 新增实体属性不为null的记录
     *
     * @param tJeeblogThemeReq 实例对象
     * @return 实例对象
     */
    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TJeeblogThemeResp> insert(@RequestBody @Validated TJeeblogThemeReq tJeeblogThemeReq){
        RespVO<TJeeblogThemeResp> result = new RespVO<>();
      int insert = tJeeblogThemeService.insert(tJeeblogThemeReq);
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
     * @param tJeeblogThemeReq 实例对象
     * @return 实例对象
     */
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public RespVO<TJeeblogThemeResp> update(@RequestBody @Validated TJeeblogThemeReq tJeeblogThemeReq){
        RespVO<TJeeblogThemeResp> result = new RespVO<>();
      int update = tJeeblogThemeService.update(tJeeblogThemeReq);
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
    public RespVO<TJeeblogThemeResp> deleteOne(@PathVariable Integer id){
      RespVO<TJeeblogThemeResp> result = new RespVO<>();
        int delete = tJeeblogThemeService.deleteById(id);
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
    public RespVO<TJeeblogThemeResp> deleteBatch(@RequestBody List<Integer> ids){
        RespVO<TJeeblogThemeResp> result = new RespVO<>();
      int dels = 0;
        if (ids!=null&&ids.size()>0) {
         dels = tJeeblogThemeService.deleteByIds(ids);
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