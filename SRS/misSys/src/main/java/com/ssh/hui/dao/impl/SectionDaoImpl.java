package com.ssh.hui.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssh.hui.dao.SectionDao;
import com.ssh.hui.domain.model.Professor;
import com.ssh.hui.domain.model.Section;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:47:17 吴清辉新建
 * @version 1.0 
 **/
@Repository("sectionDao")
public class SectionDaoImpl extends BaseDaoImpl<Section> implements SectionDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Section> queryListByProfessor(Professor instructor) {
		String hql="select s from Section s where s.instructor=:instructor";		
		return getSession().createQuery(hql).setParameter("instructor", instructor).list();
	}

}
