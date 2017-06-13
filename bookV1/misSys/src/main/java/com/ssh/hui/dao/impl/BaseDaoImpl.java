/******************************************************************************
* Copyright (C) 2017 
* All Rights Reserved.
*****************************************************************************/
package com.ssh.hui.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.BaseDao;
import com.ssh.hui.service.BaseService;
@Lazy(true)
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>{
    
    @SuppressWarnings("rawtypes")
    private Class clazz; 
    
    @Resource(name="sessionFactory")//注入sqliteSession工厂
    protected SessionFactory sessionFactory;//注入session工厂
    
    @SuppressWarnings("rawtypes")
    public BaseDaoImpl(){
        ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
        clazz=(Class)type.getActualTypeArguments()[0];
    }
    protected Session getSession(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();            
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    /**
    * @param entity
    * @return ֵ
    */
    @Override
    public Serializable save(T entity) {
        System.out.println("保存"+entity);
        getSession().saveOrUpdate(entity);
          return "ok";       
    }
    
    /**
    * getByID
    * @param id
    * @return 
    */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int id) {
        // TODO Auto-generated method stub
        return(T)getSession().get(clazz, id);
    }

    /**
    * 
    * @param entity
    * @returnֵ
    */
    @Override
    public void update(T entity) {
        try{
            getSession().saveOrUpdate(entity);; 
        }catch(Exception e) {
            e.printStackTrace();
        }        
    }
    
    /**
    * 
    * @param entity
    * @return ֵ
    */
    @Override
    public void delete(T entity) {
        try{
            getSession().delete(entity);
        }catch(Exception e) {
            e.printStackTrace();
        }       
    }
    
    /**
    * 
    * @param id
    * @return ֵ
    */
    @Override
    public void delete(int id) {
        try{
            getSession().createQuery("delete " + clazz.getSimpleName()
            + " en where en.id = ?0")
            .setParameter("0" , id)
            .executeUpdate();
            
        }catch(Exception e) {
            e.printStackTrace();
        }        
    }
    
    /**
    * 
    * @param 
    * @return List<T>
    */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> queryAll() {
        String hql=" SELECT en FROM "+ clazz.getSimpleName() + " en";
        return (List<T>)getSession()
                .createQuery(hql)
                .list();
    }
    
    /**
    *
    * @param hql
    * @param pageNo
    * @param pageSize 
    * @return List<T>
    */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> queryByPage(String hql, int pageNo, int pageSize) {
        return getSession()
                .createQuery(hql)
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    /**
    * 
    * @param entityClazz
    * @return count
    */
    @Override
    public long countAll() {
        List<?> l = getSession().createQuery("select count(*) from "
                + clazz.getSimpleName()).list();
        if (l != null && l.size() == 1 )
        {
            return (Long)l.get(0);
        }
        return 0;
    }

}
