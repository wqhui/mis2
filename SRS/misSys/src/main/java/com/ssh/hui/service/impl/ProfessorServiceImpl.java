package com.ssh.hui.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Professor;
import com.ssh.hui.service.ProfessorService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("professorService")
public class ProfessorServiceImpl extends BaseServiceImpl<Professor> implements ProfessorService{
	
	
	@Override
	public Professor loginJudgment(Professor p) {
		Professor pf=new Professor();
		if("sa".equals(p.getLoginName())){//sa表示超级管理员
			pf.setLoginName("sa");
			pf.setPassword("1");
			pf.setRealName("超管");
			pf.setTitle("超级管理员");

		}else{
			pf=professorDao.getUniqueByT(p);		
		}
		if(null!=pf){
			if(pf.loginJudgment(p)){
				return pf;//匹配则返回数据
			}
		}
		return null;//null表示不匹配
	}

	@Override
	public JSONObject queryList() {
		Professor pf=new Professor();
		List<Professor> pList=professorDao.queryAll();//查询列表		
		return pf.matchList(pList);
	}

	@Override
	public JSONObject getProfessorById(int id) {
		JSONObject jo=new JSONObject();
		if(id>0){
			Professor p=professorDao.get(id);
			jo=p.toJSONObject();
		}else{
			
		}		
		return jo;
	}

}
