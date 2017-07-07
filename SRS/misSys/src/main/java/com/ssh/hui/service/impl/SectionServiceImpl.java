package com.ssh.hui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Professor;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;
import com.ssh.hui.service.SectionService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("sectionService")
public class SectionServiceImpl extends BaseServiceImpl<Section> implements SectionService{

	@Override
	public JSONObject queryList() {
		Section s=new Section();
		List<Section>sList=sectionDao.queryAll();
		return s.toJSONObjectList(sList);
	}

	@Override
	public JSONObject queryListByProfessor(Professor instructor) {
		List<Section>sList=sectionDao.queryListByProfessor(instructor);		
		Section sc=new Section();
		return sc.toJSONObjectCourseList(sList);
	}

	@Override
	public JSONObject queryStuMsgListById(int id) {
		Section s=sectionDao.get(id);
		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(Student sd:s.getEnrolledStudents()){			
			JSONObject jo=new JSONObject();
			jo.put("studentId", sd.getId());
			jo.put("ssn", sd.getSsn());
			jo.put("realName", sd.getRealName());
			TranscriptEntry ts= transcriptEntryDao.getByStu(sd);
			if(null!=ts && null!=ts.getGrade()){
				jo.put("grade", ts.getGrade());
			}else{
				jo.put("grade", "");
			}			
			ja.add(jo);
		}
		
		rjo.put("recordsTotal", s.getEnrolledStudents().size());
		rjo.put("data", ja.toString());
		return rjo;
	}

}
