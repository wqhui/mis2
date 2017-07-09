package com.ssh.hui.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.TranscriptEntryDao;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:48:30 吴清辉新建
 * @version 1.0 
 **/
@Repository("transcriptEntryDao")
public class TranscriptEntryDaoImpl extends BaseDaoImpl<TranscriptEntry> implements TranscriptEntryDao{


	@SuppressWarnings("unchecked")
	@Override
	public List<TranscriptEntry> queryByStu(Student s) {
		String hql="select t from TranscriptEntry t where t.student=:student";
		return  getSession().createQuery(hql).setParameter("student", s).list();
	}

	@Override
	public TranscriptEntry getByStuAndSection(Student sd, Section s) {
		String hql="select t from TranscriptEntry t where t.student=:student and t.section=:section";
		return (TranscriptEntry) getSession().createQuery(hql).setParameter("student", sd).setParameter("section", s).uniqueResult();
	}

}
