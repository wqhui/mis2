package com.ssh.hui.dao;

import com.ssh.hui.domain.model.Professor;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:45:54 吴清辉新建
 * @version 1.0 
 **/
public interface ProfessorDao  extends BaseDao<Professor> {

	Professor getUniqueByT(Professor p);

	

}
