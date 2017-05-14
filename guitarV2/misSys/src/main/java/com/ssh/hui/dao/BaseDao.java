/******************************************************************************
* Copyright (C) 2017 
* All Rights Reserved.
*****************************************************************************/
package com.ssh.hui.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    /**
     * getByID
     * @param id

     */
     T get(int id);
     /**
      * save entity
     * @param entityֵ
     */
     Serializable save(T entity);
     
     /**
      * update entity
     * @param entity
     * @return ֵ
     */
     void update(T entity);
     
     /**
      * delete entity
     * @param entityֵ
     */
     void delete(T entity);
     
     
     /**
      * delete entity
     * @param idֵ
     */
     void delete(int id);
     
     /**
      * query all
     */
     List<T> queryAll();
     
     /**
     *query all By Page
     * @param hql
     * @param pageNo
     * @param pageSize
     * @return 
     */
     List<T> queryByPage(String hql , int pageNo, int pageSize);
     
     /**
      * 查询所有记录数
      * @return 
      */
      long countAll();
}
