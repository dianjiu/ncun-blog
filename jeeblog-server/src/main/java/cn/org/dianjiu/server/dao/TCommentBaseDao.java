package cn.org.dianjiu.server.dao;

import cn.org.dianjiu.server.entity.TCommentBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import javax.validation.constraints.*;
import java.util.List;

/**
 * (TCommentBase)表数据库访问层
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Mapper
public interface TCommentBaseDao {
    
    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    TCommentBase getById(@NotNull Integer id);
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tCommentBase 实例对象
     * @return 对象列表
     */
    List<TCommentBase> listByEntity(TCommentBase tCommentBase);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tCommentBase
     * @return 实例对象
     */
    TCommentBase getByEntity(TCommentBase tCommentBase);

    /**
     * 通过Id列表作为筛选条件查询对象列表，列表长度不为0
     *
     * @param list 实例对象
     * @return 对象列表
     */
    List<TCommentBase> listByIds(@NotEmpty List<Integer> list);

    /**
     * 新增实体属性不为null的记录
     *
     * @param tCommentBase 实例对象
     * @return 影响行数
     */
    int insert(@NotNull TCommentBase tCommentBase);

    /**
     * 批量新增所有列，列表长度不能为0，且列表id统一为null或者统一不为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int insertBatch(@NotEmpty List<TCommentBase> list);
    
    /**
     * 通过主键修改实体属性不为null的列
     *
     * @param tCommentBase 实例对象
     * @return 影响行数
     */
    int update(@NotNull TCommentBase tCommentBase);
    
    /**
     * 通过表字段修改实体属性不为null的列
     *
     * @param where 实例对象
     * @param set 实例对象
     * @return 影响行数
     */
    int updateByField(@NotNull @Param("where") TCommentBase where, @NotNull @Param("set") TCommentBase set);
    
    /**
     * 通过主键修改实体列表，列表长度不能为0，注意：当实体属性为null时，对应的列也会别更新为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int updateBatch(@NotEmpty List<TCommentBase> list);
    
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
     * @param tCommentBase 实例对象
     * @return 影响行数
     */
    int deleteByEntity(@NotNull TCommentBase tCommentBase);
    
    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int deleteByIds(@NotEmpty List<Integer> list);
    
    int countAll();
    
    int countByEntity(TCommentBase tCommentBase);
    
}