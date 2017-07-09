package com.ssh.hui.service;

import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;

public interface TranscriptEntryService extends BaseService<TranscriptEntry> {

	void setGradeByStu(Student student,Section section, String grade);

}
