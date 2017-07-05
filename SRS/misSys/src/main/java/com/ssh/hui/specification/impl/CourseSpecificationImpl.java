package com.ssh.hui.specification.impl;

import org.springframework.stereotype.Component;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.specification.Specification;

/** 
 * @author hui 
 * @date 创建时间：2017年7月3日 下午4:44:30 吴清辉新建
 * @version 1.0 
 **/
@Component("courseSpecificationImpl")
public class CourseSpecificationImpl implements Specification {
	
	/**
	 * 是否有先修课程
	 * */
	public boolean hasPrerequisites(Course c) {
		if (c.getPrerequisites().size() > 0) return true;
		else return false;
	}
	
	/**
	 * 先修课程是否通过
	 * */
	public boolean isPass(Course c){
		for(Course pre:c.getPrerequisites()){
			
		}
		return false;
	}
}
