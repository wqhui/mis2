package com.ssh.hui.service.impl;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.Transcript;
import com.ssh.hui.domain.model.TranscriptEntry;
import com.ssh.hui.service.TranscriptService;

import net.sf.json.JSONObject;
@Service("transcriptService")
public class TranscriptServiceImpl extends BaseServiceImpl<Transcript> implements TranscriptService{

	@Override
	public JSONObject getByStu(Student studentOwner) {
		Transcript t=transcriptDao.getByStu(studentOwner);	
		JSONObject jo=new JSONObject();
		if(t!=null){
			t.toJSONObjectTE();
		}else{
			jo.put("recordsTotal", 0);
			jo.put("data", "[]");
		}
		return jo;//每科成绩转化为jsonObject
	}

}
