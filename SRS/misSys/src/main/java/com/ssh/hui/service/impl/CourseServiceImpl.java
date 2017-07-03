package com.ssh.hui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.service.CourseService;

import net.sf.json.JSONObject;

@Service("courseService")
public class CourseServiceImpl extends  BaseServiceImpl<Course> implements CourseService{

	@Override
	public JSONObject queryList() {
		Course c=new Course();
		List<Course> cList=courseDao.queryAll();
		return c.toJSONObjectList(cList);
	}

	@Override
	public JSONObject getCourseById(int id) {
		Course c=courseDao.get(id);
		return c.toJSONObject();
	}

	@Override
	public JSONObject queryListExPre(int id) {
		Course newC=new Course();
		newC.setId(id);
		List<Course> newList=new ArrayList<Course>();
		List<Course> oldList=courseDao.queryAll();
		for(Course c:oldList){
			if(!c.isPrerequisit(newC)){
				newList.add(c);
			}
		}
		return newC.toJSONObjectList(newList);
	}

	@Override
	public void setPreCourse(Course oriCourse,Course preCourse) {
		oriCourse.addPrerequisite(preCourse);//添加先修课程
		courseDao.update(oriCourse);
		
	}

}
