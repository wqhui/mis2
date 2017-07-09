package com.ssh.hui.specification.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;
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
	 * 课程是否通过
	 * */
	public boolean isCoursePass(Course c,Student s){
		return s.getTranscript().verifyCompletion(c);
	}

	@Override
	public boolean isPassPrerequisites(Set<Course> prerequisites,Student s) {
		for(Course c:prerequisites){//判断先修课是否通过				
			if(!isCoursePass(c,s)){//如果有一门未通过
				return false;
			}			
			
		}
		return true;
	}

}
