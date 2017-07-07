package com.ssh.hui.dao.impl;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.TranscriptEntryDao;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:48:30 吴清辉新建
 * @version 1.0 
 **/
@Repository("transcriptEntryDao")
public class TranscriptEntryDaoImpl extends BaseDaoImpl<TranscriptEntry> implements TranscriptEntryDao{

	@Override
	public TranscriptEntry getByStu(Student sd) {
		String hql="select t from TranscriptEntry t where t.student=:student";
		return (TranscriptEntry) getSession().createQuery(hql).setParameter("student", sd).uniqueResult();
	}

}
