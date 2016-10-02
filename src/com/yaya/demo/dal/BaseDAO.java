package com.yaya.demo.dal;

import java.util.List;

/**
 * 持久层接口
 *
 * @author ChW 2016-04-25 13:54:56
 */
public interface BaseDAO<T> {

    //写
    void saveEntity(T t);

    void saveOrUpdateEntity(T t);

    void deleteEntity(T t);

    void batchEntityByHQL(String jpql, Object... objects);


    void executeSQL(String sql, Object... objects);

    //读
    T loadEntity(Integer id);

    T getEntity(Integer id);

    List<T> findEntityByHQL(String jpql, Object... objects);

    Object uniqueResult(String jpql, Object... objects);

    List executeSQLQuery(String sql, Object... objects);

    List<T> getEntitiesByJPQL(String jpgl, Object... objects);

}
