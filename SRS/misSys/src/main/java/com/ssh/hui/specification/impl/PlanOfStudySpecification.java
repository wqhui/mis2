package com.ssh.hui.specification.impl;

import java.util.Set;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.specification.Specification;

/** 
 * @author hui 
 * @date 创建时间：2017年7月9日 下午3:18:58 吴清辉新建
 * @version 1.0 
 **/
public class PlanOfStudySpecification implements Specification {

	@Override
	public boolean hasPrerequisites(Course c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCoursePass(Course c, Student s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPassPrerequisites(Set<Course> prerequisites, Student s) {
		// TODO Auto-generated method stub
		return false;
	}

}
