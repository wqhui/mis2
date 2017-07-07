package com.ssh.hui.action;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.ssh.hui.domain.model.Professor;
import com.ssh.hui.domain.model.Section;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年6月28日 下午2:15:05 吴清辉新建
 * @version 1.0 
 **/
public class ProfessorAction extends BaseAction<Professor>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private String ssn;
	private String realName;
	private String loginName;
	private String password;
	private String title;//头衔
	private String department;//系
	private Set<Section> teaches =new HashSet<Section>(); //老师上的课
	
	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	public String login(){		
		jsonObject.put("status", "error");
		if(null==loginName||null==password||loginName.equals("") || password.equals("")){
			
		}else{
			Professor p=new Professor();
			p.setLoginName(loginName);
			p.setPassword(password);
			Professor pf=professorService.loginJudgment(p);
			if(null!=pf){
				jsonObject.put("status", "ok");
				session.put("professor",pf);//放入session
				session.put("professorId", pf.getId());
			}
			
		}
		return "jsonObject";
	}
	
	
	/**
	 * 退出登录
	 * @return
	 */
	public String loginOut(){
		try {
			session.clear();
			ServletActionContext.getRequest().getSession().invalidate();
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("status", "error");
		}
		
		return "jsonObject";
	}

	
	/**
	 * 查询教师列表
	 * @return
	 */
	public String queryList(){
		jsonObject=professorService.queryList();
		return "jsonObject";
	}
	
	/**
	 * 保存教师
	 * @return
	 */
	public String saveOrUpdateProfessor(){
		Professor p=new Professor(ssn,title,realName,department,loginName,password);
		try {
			if(id>0){
				p.setId(id);
			}			
			professorService.update(p);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();
		}
		
		return "jsonObject";
	}
	
	
	/**
	 * 删除教师
	 * @return
	 */
	public String deleteProfessor(){		
		try {
			if(id>0){
				professorService.delete(id);
			}
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();
		}
		
		return "jsonObject";
	}
	
	/**
	 * 根据id查询教师
	 * @return jsonArray
	 */
	public String getProfessorById(){	
		JSONObject jo=new JSONObject();
		try {			
			jo=professorService.getProfessorById(id);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");	
			e.printStackTrace();
		}finally{
			jsonObject.put("data", jo);
		}
		
		return "jsonObject";
	}
	
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Section> getTeaches() {
		return teaches;
	}

	public void setTeaches(Set<Section> teaches) {
		this.teaches = teaches;
	}

	
	
}
