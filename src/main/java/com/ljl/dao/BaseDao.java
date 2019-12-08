package com.ljl.dao;


import java.util.List;

public interface BaseDao<T> {
    void add(T t);

    void update(T t);

    void delete(String id);

    List<T> queryAll();

    T queryById(String id);

}
