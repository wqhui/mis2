package com.ssh.hui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.service.PlanOfStudyService;

import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年6月27日 下午4:49:10 吴清辉新建
 * @version 1.0 
 **/
@Service("planOfStudyService")
public class PlanOfStudyServiceImpl extends BaseServiceImpl<PlanOfStudy> implements PlanOfStudyService{

	@Override
	public JSONObject queryList() {
		PlanOfStudy p=new PlanOfStudy();
		List<PlanOfStudy> pList=planOfStudyDao.queryAll();		
		return p.toJSONObjectList(pList);
	}

	@Override
	public JSONObject getPlanById(int id) {
		JSONObject jo=new JSONObject();
		if(id>0){
			PlanOfStudy p=planOfStudyDao.get(id);
			jo=p.toJSONObject();
		}
		return jo;
	}

	@Override
	public JSONObject queryCourseListExPlan(PlanOfStudy p) {
		Course pc=new Course();
		List<Course> newList=new ArrayList<Course>();
		List<Course> cList=courseDao.queryAll();
		for(Course c:cList){
			if(!p.isPlanCourse(c)){		
				newList.add(c);
			}
		}
		return pc.toJSONObjectList(newList);
	}

	@Override
	public void setPlanCourse(PlanOfStudy p, Course c) {
		p.addCourse(c);
		planOfStudyDao.update(p);
		
	}

}
