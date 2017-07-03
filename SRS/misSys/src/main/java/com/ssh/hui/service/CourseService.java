package com.ssh.hui.service;

import com.ssh.hui.domain.model.Course;

import net.sf.json.JSONObject;

/**
 * @author hui
 *
 */
public interface CourseService extends BaseService<Course>{

	/**
	 * 查询列表
	 * @return
	 */
	JSONObject queryList();
		
	/**
	 * 
	 * @param id
	 * @return
	 */
	JSONObject getCourseById(int id);

	/**
	 * 查询列表排除已是先修
	 * @param id
	 * @return
	 */
	JSONObject queryListExPre(int id);

	void setPreCourse(Course oriCourse,Course preCourse);

}
