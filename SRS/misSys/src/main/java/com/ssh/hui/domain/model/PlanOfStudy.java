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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年6月27日 下午4:18:31 吴清辉新建
 * @version 1.0 
 **/
@Entity
@Table(name="plan_of_study")
public class PlanOfStudy {
	
	//------------
	// Attributes.
	//------------
	private int id;
	private String planName;//培养计划名称
	private Set<Student> students=new HashSet<Student>(); //学生
	private Set<Course> courses=new HashSet <Course>();//培养计划课程
	private Department theDepartment;//对应部门 暂认为每个系只有一种培养计划
	
	
	//----------------
	// Constructor(s).
	//----------------
	public PlanOfStudy(){}
	
	
	//------------------
	// Accessor methods.
	//------------------
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	@Column(name="plan_name")		
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="planOfStudy")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name ="plan_course_relation",
	joinColumns = {@JoinColumn(name = "plan_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName ="id")})
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name = "department_id",referencedColumnName="id")
	public Department getTheDepartment() {
		return theDepartment;
	}


	public void setTheDepartment(Department theDepartment) {
		this.theDepartment = theDepartment;
	}

	
	
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------
	/**
	 * 装配列表
	 * @param pList
	 * @return
	 */
	public JSONObject toJSONObjectList(List<PlanOfStudy> pList) {
		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(PlanOfStudy p:pList){
			JSONObject jo=new JSONObject();
			jo.put("id", p.getId());
			jo.put("planName", p.getPlanName());
			if(null!=p.getTheDepartment()){
				jo.put("theDepartment", p.getTheDepartment().getDepartmentName());
			}else{
				jo.put("theDepartment","其他");
			}
			
			ja.add(jo);
		}
		rjo.put("recordsTotal", pList.size());
		rjo.put("data", ja.toString());
		return rjo;
		
		
	}

	
	/**
	 * 添加课程
	 */
	public void addCourse(Course c){
		courses.add(c);
	}
	
	/**
	 * 将自身属性输出成json对象
	 * @return JSONObject
	 */
	public JSONObject toJSONObject() {
		JSONObject jo=new JSONObject();
		jo.put("id", id);
		jo.put("planName", planName);
		if(null!=theDepartment){
			jo.put("departmentId", theDepartment.getId());
		}else{
			jo.put("theDepartment","其他");
		}
		return jo;
	}
	
	/**
	 * 该课程是否为以经是param的计划课程
	 * */
	@Transient
	public boolean isPlanCourse(Course oriCourse){
		for(Course c:courses){
			if(c.getId()==oriCourse.getId()){				
				return true;
			}
		}

		return false;
	}
	
}
