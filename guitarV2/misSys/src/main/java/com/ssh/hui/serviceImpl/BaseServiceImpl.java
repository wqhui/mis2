/******************************************************************************
* Copyright (C) 2017 
* All Rights Reserved.
*****************************************************************************/
package com.ssh.hui.serviceImpl;



import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ssh.hui.dao.BaseDao;
import com.ssh.hui.dao.GuitarDao;
import com.ssh.hui.service.BaseService;
@Lazy(true)
@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T>{
    

    @SuppressWarnings("rawtypes")
    private Class clazz; //获取class

    /**
     * @Description: TODO(利用反射获取对象,对泛型T的Class类型进行初始化赋值，this表示继承该类的子类对象)
     * 
     * */
    @SuppressWarnings("rawtypes")
    public BaseServiceImpl() {       
        ParameterizedType type = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
    }
    
    @SuppressWarnings("rawtypes")
    protected BaseDao baseDao; //**泛型，不能被实例化**
    
    @Resource(name="guitarDao")
    protected GuitarDao guitarDao; //
    
    //**BaseServiceImpl构造时执行**
    /**
     * @Description: TODO(获取指定类型中的特定field类型)
     * */   
    @PostConstruct 
    public void init() throws Exception{
        //1**.获取当前clazz的类型，即注入的实体PO类名称
        String clazzName=clazz.getSimpleName();
        //2**.获取当前clazz的DAO,
        String clazzDaoName=clazzName.substring(0,1).toLowerCase() + clazzName.substring(1) + "Dao";
        //3**.通过clazzDaoName获取相应的Field字段
        Field clazzField=this.getClass().getSuperclass().getDeclaredField(clazzDaoName);   
        //4**.获取DAO字段
        Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");       
        baseField.set(this,clazzField.get(this));
    }
    


    @SuppressWarnings("unchecked")
    @Override
    public Serializable  save(T t) {
        return baseDao.save(t);        
    }

    @Override
    public T get(int id) {
        return (T) baseDao.get(id);
    }

    @Override
    public void update(T entity) {
        baseDao.save(entity);
        
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
        
    }

    @Override
    public void delete(int id) {
        baseDao.delete(id);
        
    }

    @Override
    public List<T> queryAll() {
        return baseDao.queryAll();
    }

    @Override
    public List<T> queryByPage(String hql, int pageNo, int pageSize) {
        return baseDao.queryByPage(hql, pageNo, pageSize);
    }

    @Override
    public long countAll() {
        // TODO Auto-generated method stub
        return baseDao.countAll();
    }
}
