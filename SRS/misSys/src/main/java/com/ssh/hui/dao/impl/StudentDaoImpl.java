package com.ssh.hui.dao.impl;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.StudentDao;
import com.ssh.hui.domain.model.Student;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:47:46 吴清辉新建
 * @version 1.0 
 **/
@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

	@Override
	public Student getUniqueByT(Student s) {
		String hql="select s from Student s where s.loginName=:loginName";			 
		return (Student) getSession().createQuery(hql).setString("loginName", s.getLoginName()).uniqueResult();
	}

}
