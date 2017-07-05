package com.ssh.hui.dao.impl;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.TranscriptDao;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.Transcript;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:49:04 吴清辉新建
 * @version 1.0 
 **/
@Repository("transcriptDao")
public class TranscriptDaoImpl extends BaseDaoImpl<Transcript> implements TranscriptDao{

	@Override
	public Transcript getByStu(Student studentOwner) {
		String hql="select t from Transcript t where t.studentOwner=:studentOwner";
		return (Transcript) getSession().createQuery(hql).setParameter("studentOwner", studentOwner).uniqueResult();
	}

}
