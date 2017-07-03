package com.ssh.hui.dao.impl;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.CourseDao;
import com.ssh.hui.domain.model.Course;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:45:15 吴清辉新建
 * @version 1.0 
 **/
@Repository("courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{

}
