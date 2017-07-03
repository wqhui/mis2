package com.ssh.hui.action;

import java.util.HashSet;
import java.util.Set;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Department;
import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.domain.model.Student;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月3日 下午5:36:29 吴清辉新建
 * @version 1.0 
 **/
public class PlanOfStudyAction extends BaseAction<PlanOfStudy>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private int departmentId;
	private int courseId;
	private String planName;//培养计划名称
	private Set<Student> students=new HashSet<Student>(); //学生
	private Set<Course> courses=new HashSet <Course>();//培养计划课程
	private Department theDepartment;//对应部门 暂认为每个系只有一种培养计划
	
	/**
	 * 
	 * @return 列表
	 */
	public String queryList(){
		jsonObject=planOfStudyService.queryList();
		return "jsonObject";
	}
	
	
	/**
	 * 保存课程
	 * @return
	 */
	public String saveOrUpdatePlan(){
		PlanOfStudy planOfStudy=new PlanOfStudy();
		try {
			if(id>0){
				planOfStudy=planOfStudyService.get(id);
			}
			planOfStudy.setPlanName(planName);		
			if(departmentId>0){
				Department d= departmentService.get(departmentId);
				planOfStudy.setTheDepartment(d);
			}
			planOfStudyService.update(planOfStudy);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();
		}
		return "jsonObject";
	}
	
	/**
	 * @return
	 */
	public String deletePlan(){
		try {
			if(id>0){
				planOfStudyService.delete(id);
			}
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();

		}
		return "jsonObject";
	}
	
	/**
	 * 根据id查询
	 * @return jsonArray
	 */
	public String getPlanById(){
		JSONObject jo=new JSONObject();
		try {
			jo=planOfStudyService.getPlanById(id);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");	
			e.printStackTrace();
		}finally{
			jsonObject.put("data", jo);
		}
		
		return "jsonObject";
	}
	
	
	/**
	 * @return
	 */
	public String queryListExPlan(){
		PlanOfStudy p=planOfStudyService.get(id);
		jsonObject=planOfStudyService.queryCourseListExPlan(p);
		return "jsonObject";
	}
	
	/**
	 * @return
	 */
	public String setPlanCourse(){
		try {
			Course c=courseService.get(courseId);
			PlanOfStudy p=planOfStudyService.get(id);
			planOfStudyService.setPlanCourse(p,c);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("status", "error");	
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
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Department getTheDepartment() {
		return theDepartment;
	}
	public void setTheDepartment(Department theDepartment) {
		this.theDepartment = theDepartment;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
	
	
	
}
