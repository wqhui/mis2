package com.ssh.hui.specification;

import java.util.List;
import java.util.Set;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;

/** 
 * @author hui 
 * @date 创建时间：2017年7月3日 下午4:43:53 吴清辉新建
 * @version 1.0 
 **/
public interface Specification {
	
	/**
	 * 是否有先修课
	 * @param c
	 * @return
	 */
	boolean hasPrerequisites(Course c);
	
	 /**
	 * @param c
	 * @param s
	 * @return
	 */
	boolean isCoursePass(Course c,Student s);

	/**
	 * 先修课是否通过
	 * @param prerequisites
	 * @param s
	 * @return
	 */
	boolean isPassPrerequisites(Set<Course> prerequisites,Student s);
}
