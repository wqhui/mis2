package com.ssh.hui.action;

import java.util.HashSet;
import java.util.Set;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.CourseCatalog;
import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.domain.model.Section;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年6月30日 下午9:37:17 吴清辉新建
 * @version 1.0 
 **/
public class CourseAction extends BaseAction<Course>{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private int preId;
	private int curseCatalogId;
	private String courseNo;//课程编号
	private String courseName;//课程名字
	private double credits;//学分	
	private boolean hasPrerequisites;//是否有先修课程
	private Set<Course> prerequisites=new HashSet<Course>() ;//先修课程 (自身多对多关系)
	private Set<Course>  postCondition=new HashSet<Course>() ;//后修课程(自身多对多关系)
	private Set<Section> offeredAsSection=new HashSet<Section>() ;//相关的section 
	private Set<PlanOfStudy> planOfStudys=new HashSet<PlanOfStudy>();//对应的学习计划
	private CourseCatalog curseCatalog;
	
	
	
	/**
	 * 
	 * @return 列表
	 */
	public String queryList(){
		jsonObject=courseService.queryList();
		return "jsonObject";
	}
	
	/**
	 * 保存课程
	 * @return
	 */
	public String saveOrUpdateCourse(){
		Course c=new Course(courseNo,courseName,credits);
		if(curseCatalogId>0){
			curseCatalog=courseCatalogService.get(curseCatalogId);
			c.setCourseCatalog(curseCatalog);
		}
		try {
			if(id>0){
				c.setId(id);
			}
			courseService.update(c);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();
		}
		return "jsonObject";
	}
	
	/**
	 * 删除课程
	 * @return
	 */
	public String deleteCourse(){
		Course c=new Course();
		try {
			if(id>0){
				c.setId(id);
			}
			courseService.delete(c);;
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();
		}
		return "jsonObject";
	}
	
	/**
	 * 根据id查询课程
	 * @return jsonArray
	 */
	public String getCourseById(){	
		JSONObject jo=new JSONObject();
		try {			
			jo=courseService.getCourseById(id);
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
	 * 查询课程但排除已选的先修课程
	 * @param id
	 * @return
	 */
	public String queryListPre(){
		if(id>0){
			jsonObject=courseService.queryListExPre(id);
		}
		
		return "jsonObject";
	}
	
	/**
	 * 添加先修课程
	 * @return
	 */
	public String setPreCourse(){
		try {
			Course oriCourse=courseService.get(id);
			Course preCourse=courseService.get(preId);
			courseService.setPreCourse(oriCourse,preCourse);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
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
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public boolean isHasPrerequisites() {
		return hasPrerequisites;
	}
	public void setHasPrerequisites(boolean hasPrerequisites) {
		this.hasPrerequisites = hasPrerequisites;
	}
	public Set<Course> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(Set<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}
	public Set<Course> getPostCondition() {
		return postCondition;
	}
	public void setPostCondition(Set<Course> postCondition) {
		this.postCondition = postCondition;
	}
	public Set<Section> getOfferedAsSection() {
		return offeredAsSection;
	}
	public void setOfferedAsSection(Set<Section> offeredAsSection) {
		this.offeredAsSection = offeredAsSection;
	}
	public Set<PlanOfStudy> getPlanOfStudys() {
		return planOfStudys;
	}
	public void setPlanOfStudys(Set<PlanOfStudy> planOfStudys) {
		this.planOfStudys = planOfStudys;
	}
	public CourseCatalog getCurseCatalog() {
		return curseCatalog;
	}
	public void setCurseCatalog(CourseCatalog curseCatalog) {
		this.curseCatalog = curseCatalog;
	}

	public int getCurseCatalogId() {
		return curseCatalogId;
	}

	public void setCurseCatalogId(int curseCatalogId) {
		this.curseCatalogId = curseCatalogId;
	}

	public int getPreId() {
		return preId;
	}

	public void setPreId(int preId) {
		this.preId = preId;
	}
	
	
	
	
	
	
	
}
