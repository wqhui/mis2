package com.ssh.hui.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月1日 上午11:54:05 吴清辉新建
 * @version 1.0 
 **/
@Entity
@Table(name="department")
public class Department {
	//------------
	// Attributes.
	//------------
	private int id;
	private String departmentName;
	private Set<Student> students=new HashSet<Student>();//该系学生
	private PlanOfStudy planOfStudy;//对应计划 暂认为每个系只有一种培养计划
	
	
	//----------------
	// Constructor(s).
	//----------------
	public Department(){}
	
	/**
	 * @param departmentName
	 */
	public Department(String departmentName){}
	
	
	//----------------
	// Accessor methods.
	//----------------
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="department_Name")
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="department")
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@OneToOne(mappedBy="theDepartment",fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	public PlanOfStudy getPlanOfStudy() {
		return planOfStudy;
	}

	public void setPlanOfStudy(PlanOfStudy planOfStudy) {
		this.planOfStudy = planOfStudy;
	}
	
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------
	


	public void display() {
		System.out.println("tDepartmentName Information:");
		System.out.println("\tDepartmentName:  " +departmentName);
		System.out.println();
	}

	public JSONObject toJSONObjectList(List<Department> dList) {
		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(Department d :dList){
			JSONObject jo=new JSONObject();
			jo.put("id", d.getId());
			jo.put("departmentName", d.getDepartmentName());
			ja.add(jo);
		}
		rjo.put("recordsTotal", dList.size());
		rjo.put("data", ja.toString());
		return rjo;
	}
}
