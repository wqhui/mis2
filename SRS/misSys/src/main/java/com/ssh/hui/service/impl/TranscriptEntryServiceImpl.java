package com.ssh.hui.service.impl;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;
import com.ssh.hui.service.TranscriptEntryService;
@Service("transcriptEntryService")
public class TranscriptEntryServiceImpl extends BaseServiceImpl<TranscriptEntry> implements TranscriptEntryService{

	@Override
	public void setGradeByStu(Student student,Section section, String grade) {
		TranscriptEntry t=transcriptEntryDao.getByStuAndSection(student, section);
		t.setGrade(grade);
		transcriptEntryDao.update(t);
	}

}
