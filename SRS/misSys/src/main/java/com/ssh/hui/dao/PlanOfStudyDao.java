package com.ssh.hui.dao;

import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.domain.model.Student;

/** 
 * @author hui 
 * @date 创建时间：2017年6月27日 下午4:51:09 吴清辉新建
 * @version 1.0 
 **/
public interface PlanOfStudyDao extends BaseDao<PlanOfStudy>{

	PlanOfStudy getByStu(Student s);

}
