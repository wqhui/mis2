package com.ssh.hui.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.Transcript;
import com.ssh.hui.domain.model.TranscriptEntry;
import com.ssh.hui.service.StudentService;
import com.ssh.hui.specification.Specification;
import com.ssh.hui.specification.impl.CourseSpecificationImpl;

import net.sf.json.JSONObject;
@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService{
	@Resource(name="courseSpecificationImpl")
	private Specification courseSpecificationImpl;
	@Override
	public Student loginJudgment(Student s) {
		Student st=studentDao.getUniqueByT(s);
		if(null!=st){
			if(st.loginJudgment(s)){
				return st;
			}
			
		}
		
		return null;
	}

	@Override
	public JSONObject chooseCourse(Student s, int sectionId) {	
		JSONObject jo=new JSONObject();			
		jo.put("status", "ok");
		Section st=sectionDao.get(sectionId);//获得该section
		int capacitySize=st.getSeatingCapacity();
		PlanOfStudy pos=planOfStudyDao.getByStu(s);
		if(pos.isPlanCourse(st.getRepresentedCourse())){
			if(capacitySize>0){//是否有余量
				st.setSeatingCapacity(capacitySize-1);//余量-1
				Course crs= st.getRepresentedCourse();
				if(courseSpecificationImpl.hasPrerequisites(crs)){//判断是否有先修课
					if(courseSpecificationImpl.isPassPrerequisites(crs.getPrerequisites(),s)){
						Student ns=studentDao.get(s.getId());
						sectionDao.update(st);
						ns.addSection(st);
						transcriptEntryDao.save(new TranscriptEntry(ns,null,st));						
						studentDao.update(ns);					
					}else{
						jo.put("status", "noPass");
					}
					
				}else{
					Student ns=studentDao.get(s.getId());
					sectionDao.update(st);
					ns.addSection(st);
					transcriptEntryDao.save(new TranscriptEntry(ns,null,st));						
					studentDao.update(ns);				
				};
			}else{
				jo.put("status", "noCapacity");
				
			}
		}else{
			jo.put("status", "noPlan");
		}
		
		

		return jo;
	}

	@Override
	public JSONObject getTranscriptByStu(Student s) {
		Transcript t =transcriptDao.getByStu(s);		
		return t.toJSONObjectTE();
	}

}
