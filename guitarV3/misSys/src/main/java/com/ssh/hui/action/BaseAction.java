/******************************************************************************
* Copyright (C) 2017 
* All Rights Reserved.
*****************************************************************************/
package com.ssh.hui.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.hui.service.GuitarService;

/**
 * baseAction实现公共变量和注入Service
 * @author 吴清辉
 * @since JDK 1.8
 * @version 1.0
 */
public class BaseAction<T> extends ActionSupport implements RequestAware,
SessionAware, ApplicationAware, ModelDriven<T> {
    //实体po
    protected T model;
    //用于封装请求request
    protected Map<String, Object> request;
    //用于封装会话session
    protected Map<String, Object> session;
    //用于封装application
    protected Map<String, Object> application;
    //page用于接收客户端传递的页码
    protected Integer page;
    //rows用于接收客户端传递的每页行数
    protected Integer rows;
    
    @Resource(name="guitarService")
    protected GuitarService guitarService;
    
    @Override
    public T getModel() {
        return model;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application=application;
        
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
        
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request=request;
        
    }
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
