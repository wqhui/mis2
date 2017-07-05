package com.ssh.hui.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.service.StudentService;
import com.ssh.hui.specification.Specification;
import com.ssh.hui.specification.impl.CourseSpecificationImpl;
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
	public void chooseCourse(Student s, int sectionId) {		
		Section st=sectionDao.get(sectionId);//获得该section
		if(courseSpecificationImpl.hasPrerequisites(st.getRepresentedCourse())){//判断是否有先修课
			for(Course c:st.getRepresentedCourse().getPrerequisites()){
				
			}
			
		}else{
			Student ns=studentDao.get(s.getId());
			ns.addSection(st);
			studentDao.update(ns);
		};

		
	}

}
