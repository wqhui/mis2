package com.ssh.hui.service;

import com.ssh.hui.domain.model.Professor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author hui
 *
 */
public interface ProfessorService extends BaseService<Professor>{
	
	
	/**
	 * 判断登录
	 * @param  p
	 * @return Professor
	 */
	Professor loginJudgment(Professor p);

	/**
	 * 查询所有列表
	 * @return
	 */
	JSONObject queryList();

	JSONObject getProfessorById(int id);

}
