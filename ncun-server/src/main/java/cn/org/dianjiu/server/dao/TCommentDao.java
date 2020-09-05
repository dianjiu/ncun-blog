package cn.org.dianjiu.server.dao;

import cn.org.dianjiu.server.entity.TComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * (TComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-05 21:30:32
 */
@Mapper
public interface TCommentDao {

    /**
     * 通过Id查询单个对象
     *
     * @param id 主键
     * @return 实例对象
     */
    TComment getById(@NotNull Integer id);

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tComment 实例对象
     * @return 对象列表
     */
    List<TComment> listByEntity(TComment tComment);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个对象
     *
     * @param tComment
     * @return 实例对象
     */
    TComment getByEntity(TComment tComment);

    /**
     * 通过Id列表作为筛选条件查询对象列表，列表长度不为0
     *
     * @param list 实例对象
     * @return 对象列表
     */
    List<TComment> listByIds(@NotEmpty List<Integer> list);

    /**
     * 新增实体属性不为null的记录
     *
     * @param tComment 实例对象
     * @return 影响行数
     */
    int insert(@NotNull TComment tComment);

    /**
     * 批量新增所有列，列表长度不能为0，且列表id统一为null或者统一不为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int insertBatch(@NotEmpty List<TComment> list);

    /**
     * 通过主键修改实体属性不为null的列
     *
     * @param tComment 实例对象
     * @return 影响行数
     */
    int update(@NotNull TComment tComment);

    /**
     * 通过表字段修改实体属性不为null的列
     *
     * @param where 实例对象
     * @param set   实例对象
     * @return 影响行数
     */
    int updateByField(@NotNull @Param("where") TComment where, @NotNull @Param("set") TComment set);

    /**
     * 通过主键修改实体列表，列表长度不能为0，注意：当实体属性为null时，对应的列也会别更新为null
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int updateBatch(@NotEmpty List<TComment> list);

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
     * @param tComment 实例对象
     * @return 影响行数
     */
    int deleteByEntity(@NotNull TComment tComment);

    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int deleteByIds(@NotEmpty List<Integer> list);

    int countAll();

    int countByEntity(TComment tComment);

}