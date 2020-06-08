package cn.org.dianjiu.server.dao;

import cn.org.dianjiu.server.entity.TCommonBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import javax.validation.constraints.*;
import java.util.List;

/**
 * (TCommonBase)表数据库访问层
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Mapper
public interface TCommonBaseDao {
    
    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    TCommonBase getById(@NotNull Integer id);
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tCommonBase 实例对象
     * @return 对象列表
     */
    List<TCommonBase> listByEntity(TCommonBase tCommonBase);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tCommonBase
     * @return 实例对象
     */
    TCommonBase getByEntity(TCommonBase tCommonBase);

    /**
     * 通过Id列表作为筛选条件查询对象列表，列表长度不为0
     *
     * @param list 实例对象
     * @return 对象列表
     */
    List<TCommonBase> listByIds(@NotEmpty List<Integer> list);

    /**
     * 新增实体属性不为null的记录
     *
     * @param tCommonBase 实例对象
     * @return 影响行数
     */
    int insert(@NotNull TCommonBase tCommonBase);

    /**
     * 批量新增所有列，列表长度不能为0，且列表id统一为null或者统一不为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int insertBatch(@NotEmpty List<TCommonBase> list);
    
    /**
     * 通过主键修改实体属性不为null的列
     *
     * @param tCommonBase 实例对象
     * @return 影响行数
     */
    int update(@NotNull TCommonBase tCommonBase);
    
    /**
     * 通过表字段修改实体属性不为null的列
     *
     * @param where 实例对象
     * @param set 实例对象
     * @return 影响行数
     */
    int updateByField(@NotNull @Param("where") TCommonBase where, @NotNull @Param("set") TCommonBase set);
    
    /**
     * 通过主键修改实体列表，列表长度不能为0，注意：当实体属性为null时，对应的列也会别更新为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int updateBatch(@NotEmpty List<TCommonBase> list);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@NotNull Integer id);
    
    /**
     * 通过实体非空属性删除
     *
     * @param tCommonBase 实例对象
     * @return 影响行数
     */
    int deleteByEntity(@NotNull TCommonBase tCommonBase);
    
    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int deleteByIds(@NotEmpty List<Integer> list);
    
    int countAll();
    
    int countByEntity(TCommonBase tCommonBase);
    
}