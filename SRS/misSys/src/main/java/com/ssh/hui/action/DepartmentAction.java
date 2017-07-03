package com.ssh.hui.action;

import java.util.HashSet;
import java.util.Set;

import com.ssh.hui.domain.model.Department;
import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.domain.model.Student;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月1日 下午10:56:36 吴清辉新建
 * @version 1.0 
 **/
public class DepartmentAction extends BaseAction<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private String departmentName;
	private Set<Student> students=new HashSet<Student>();//该系学生
	private PlanOfStudy planOfStudy;//对应计划 暂认为每个系只有一种培养计划
	
	
	
	/**
	 * 
	 * @return 列表
	 */
	public String queryList(){
		jsonObject=departmentService.queryList();
		return  "jsonObject";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public PlanOfStudy getPlanOfStudy() {
		return planOfStudy;
	}
	public void setPlanOfStudy(PlanOfStudy planOfStudy) {
		this.planOfStudy = planOfStudy;
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
	
	
}
