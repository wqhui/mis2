package com.ssh.hui.specification;

import com.ssh.hui.domain.model.Course;

/** 
 * @author hui 
 * @date 创建时间：2017年7月3日 下午4:43:53 吴清辉新建
 * @version 1.0 
 **/
public interface Specification {
	boolean hasPrerequisites(Course c);
}
