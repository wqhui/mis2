package com.ssh.hui.service.impl;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.service.StudentService;
@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService{

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
		Section st=sectionDao.get(sectionId);
		Student ns=studentDao.get(s.getId());
		ns.addSection(st);
		studentDao.update(ns);
		
	}

}
