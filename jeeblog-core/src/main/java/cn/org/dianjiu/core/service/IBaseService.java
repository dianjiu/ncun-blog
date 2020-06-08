package cn.org.dianjiu.core.service;

import java.util.List;

/**
 * Created by limengwei on 2019-11-25
 **/

public interface IBaseService<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    List<T> list();
}
