package com.ssh.hui.action;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.ssh.hui.domain.model.Department;
import com.ssh.hui.domain.model.PlanOfStudy;
import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.Transcript;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月3日 下午10:03:35 吴清辉新建
 * @version 1.0 
 **/
public class StudentAction extends BaseAction<Student>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private int sectionId;
	private int courseId;
	private String ssn;
	private String realName;
	private String loginName;
	private String password;
	private String major;
	private String degree;
	private Transcript transcript;
	//private ArrayList<Section> attends; 
	private Set<Section> attends=new HashSet<Section>();
	private PlanOfStudy planOfStudy;
	private Department department;
	
	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	public String login(){
		jsonObject.put("status", "error");
		System.out.println(loginName+":"+password);
		if(null==loginName||null==password||loginName.equals("") || password.equals("")){
			
		}else{			
			Student s=new Student();
			s.setLoginName(loginName);
			s.setPassword(password);
			Student st=studentService.loginJudgment(s);
			if(null!=st){
				jsonObject.put("status", "ok");
				session.put("student",st);//放入session
				session.put("studentId", st.getId());
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
	 * 选课
	 * @return
	 */
	public String chooseCourse(){
		try {
			if(sectionId>0){
				Student s=new Student();
				id=(int) session.get("studentId");
				System.out.println(id);
				s.setId(id);
				studentService.chooseCourse(s,sectionId);
				jsonObject.put("status", "ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("status", "error");
		}

		return "jsonObject";
	}
	
	/**
	 * 查看成绩
	 * @return
	 */
	public String getTranscriptByStu(){
			id=(int) session.get("studentId");
			
			if(id>0){
				Student s=studentService.get(id);
				jsonObject=studentService.getTranscriptByStu(s);
			}else{
				jsonObject.put("recordsTotal", 0);
				jsonObject.put("data", "[]");
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Transcript getTranscript() {
		return transcript;
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public Set<Section> getAttends() {
		return attends;
	}
	public void setAttends(Set<Section> attends) {
		this.attends = attends;
	}
	public PlanOfStudy getPlanOfStudy() {
		return planOfStudy;
	}
	public void setPlanOfStudy(PlanOfStudy planOfStudy) {
		this.planOfStudy = planOfStudy;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	
	
	
	
}
