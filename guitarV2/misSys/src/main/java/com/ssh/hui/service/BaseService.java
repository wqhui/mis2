/******************************************************************************
* Copyright (C) 2017 
* All Rights Reserved.
*****************************************************************************/
package com.ssh.hui.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
    //根据id查询实体
    T get(int id);
    //保存实体
    Serializable  save(T entity);    
    //更新实体
    void update(T entity);
    //删除实体   
    void delete(T entity);
    //根据id删除实体
    void delete(int id);
    //查询所有实体
    List<T> queryAll();
    //分页查询所有实体
    List<T> queryByPage(String hql , int pageNo, int pageSize);
    //查询所有记录数
    long countAll();
}
