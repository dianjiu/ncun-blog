package cn.org.dianjiu.server.dao;

import cn.org.dianjiu.server.entity.TBlogTheme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.*;
import java.util.List;

/**
 * 主题操作(TBlogTheme)表数据库访问层
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:06
 */
@Mapper
public interface TBlogThemeDao {

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlogTheme getById(@NotNull Integer id);

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tBlogTheme 实例对象
     * @return 对象列表
     */
    List<TBlogTheme> listByEntity(TBlogTheme tBlogTheme);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tBlogTheme
     * @return 实例对象
     */
    TBlogTheme getByEntity(TBlogTheme tBlogTheme);

    /**
     * 通过Id列表作为筛选条件查询对象列表，列表长度不为0
     *
     * @param list 实例对象
     * @return 对象列表
     */
    List<TBlogTheme> listByIds(@NotEmpty List<Integer> list);

    /**
     * 新增实体属性不为null的记录
     *
     * @param tBlogTheme 实例对象
     * @return 影响行数
     */
    int insert(@NotNull TBlogTheme tBlogTheme);

    /**
     * 批量新增所有列，列表长度不能为0，且列表id统一为null或者统一不为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int insertBatch(@NotEmpty List<TBlogTheme> list);

    /**
     * 通过主键修改实体属性不为null的列
     *
     * @param tBlogTheme 实例对象
     * @return 影响行数
     */
    int update(@NotNull TBlogTheme tBlogTheme);

    /**
     * 通过表字段修改实体属性不为null的列
     *
     * @param where 实例对象
     * @param set   实例对象
     * @return 影响行数
     */
    int updateByField(@NotNull @Param("where") TBlogTheme where, @NotNull @Param("set") TBlogTheme set);

    /**
     * 通过主键修改实体列表，列表长度不能为0，注意：当实体属性为null时，对应的列也会别更新为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int updateBatch(@NotEmpty List<TBlogTheme> list);

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
     * @param tBlogTheme 实例对象
     * @return 影响行数
     */
    int deleteByEntity(@NotNull TBlogTheme tBlogTheme);

    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int deleteByIds(@NotEmpty List<Integer> list);

    int countAll();

    int countByEntity(TBlogTheme tBlogTheme);

}
