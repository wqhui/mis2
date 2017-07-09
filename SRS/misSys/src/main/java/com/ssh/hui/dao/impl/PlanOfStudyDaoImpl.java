package com.ssh.hui.dao.impl;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.PlanOfStudyDao;
import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.domain.model.Student;

/** 
 * @author hui 
 * @date 创建时间：2017年6月27日 下午4:51:31 吴清辉新建
 * @version 1.0 
 **/
@Repository("planOfStudyDao")
public class PlanOfStudyDaoImpl extends BaseDaoImpl<PlanOfStudy> implements PlanOfStudyDao{

	@Override
	public PlanOfStudy getByStu(Student s) {
		String hql="select p from PlanOfStudy p where p.theDepartment=:theDepartment";
		return  (PlanOfStudy) getSession().createQuery(hql).setParameter("theDepartment", s.getDepartment()).uniqueResult();
	}

}
