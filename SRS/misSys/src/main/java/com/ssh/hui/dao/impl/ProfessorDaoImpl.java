package com.ssh.hui.dao.impl;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.ProfessorDao;
import com.ssh.hui.domain.model.Professor;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:45:54 吴清辉新建
 * @version 1.0 
 **/
@Repository("professorDao")
public class ProfessorDaoImpl  extends BaseDaoImpl<Professor> implements ProfessorDao{

	@Override
	public Professor getUniqueByT(Professor p) {
		String hql="select p from Professor p where p.loginName=:loginName";				
		return (Professor) getSession().createQuery(hql).setString("loginName", p.getLoginName()).uniqueResult();
	}

}
