package com.ssh.hui.service;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.PlanOfStudy;

import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年6月27日 下午4:48:19 吴清辉新建
 * @version 1.0 
 **/
public interface PlanOfStudyService extends BaseService<PlanOfStudy>{

	JSONObject queryList();

	JSONObject getPlanById(int id);

	JSONObject queryCourseListExPlan(PlanOfStudy p);

	void setPlanCourse(PlanOfStudy p, Course c);

}
