package com.ssh.hui.service;

import com.ssh.hui.domain.model.Student;

public interface StudentService extends BaseService<Student>{

	Student loginJudgment(Student s);

	void chooseCourse(Student s, int sectionId);

}
