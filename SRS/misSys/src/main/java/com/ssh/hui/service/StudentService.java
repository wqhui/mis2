package com.ssh.hui.service;

import com.ssh.hui.domain.model.Student;

import net.sf.json.JSONObject;

public interface StudentService extends BaseService<Student>{

	Student loginJudgment(Student s);

	void chooseCourse(Student s, int sectionId);

	JSONObject getTranscriptByStu(Student s);

}
