package com.ssh.hui.service;

import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.Transcript;

import net.sf.json.JSONObject;

public interface TranscriptService extends BaseService<Transcript>{

	JSONObject getByStu(Student studentOwner);

}
