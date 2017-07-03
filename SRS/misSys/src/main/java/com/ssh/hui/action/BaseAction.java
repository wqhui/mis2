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
import com.ssh.hui.service.CourseCatalogService;
import com.ssh.hui.service.CourseService;
import com.ssh.hui.service.DepartmentService;
import com.ssh.hui.service.PlanOfStudyService;
import com.ssh.hui.service.ProfessorService;
import com.ssh.hui.service.ScheduleOfClassesService;
import com.ssh.hui.service.SectionService;
import com.ssh.hui.service.StudentService;
import com.ssh.hui.service.TranscriptEntryService;
import com.ssh.hui.service.TranscriptService;

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

    
	//----------------
	// 注入service
	//----------------
    
    @Resource(name="courseCatalogService")
    protected CourseCatalogService courseCatalogService;
    @Resource(name="courseService")
    protected CourseService courseService;    
    @Resource(name="professorService")
    protected ProfessorService professorService;
    
    @Resource(name="scheduleOfClassesService")
    protected ScheduleOfClassesService scheduleOfClassesService;
    @Resource(name="sectionService")
    protected SectionService sectionService;
    @Resource(name="studentService")
    protected StudentService studentService;
    
    @Resource(name="transcriptEntryService")
    protected TranscriptEntryService transcriptEntryService;
    @Resource(name="transcriptService")
    protected TranscriptService transcriptService;
    @Resource(name="planOfStudyService")
    protected PlanOfStudyService planOfStudyService;
    
    @Resource(name="departmentService")
    protected DepartmentService departmentService;
    
    
	//----------------
	// 公共方法
	//----------------
    
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
