package com.ssh.hui.domain.model;
// Professor.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
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
import javax.persistence.Table;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Entity
@Table(name="professor")
public class Professor {
	//------------
	// Attributes.
	//------------
	private int id;
	private String ssn;
	private String realName;
	private String loginName;
	private String password;
	private String title;//头衔
	private String department;//系 没有和表联系
	private Set<Section> teaches =new HashSet<Section>(); //老师上的课

	//----------------
	// Constructor(s).
	//----------------

	public Professor(){}
	
	public Professor(String name, String ssn, String title, String dept) {
		// Reuse the parent constructor with two arguments.


		setTitle(title);
		setDepartment(dept);

		// Note that we're instantiating empty support Collection(s).

		//teaches = new ArrayList<Section>();
	}
	
	/**
	 * @param ssn
	 * @param title
	 * @param realName
	 * @param dept
	 * @param loginName
	 * @param password
	 */
	public Professor(String ssn,String title,String realName,String dept,String loginName,String password) {
		// Reuse the parent constructor with two arguments.
		setSsn(ssn);
		setRealName(realName);
		setTitle(title);
		setDepartment(dept);
		setLoginName(loginName);
		setPassword(password);

		// Note that we're instantiating empty support Collection(s).

		//teaches = new ArrayList<Section>();
	}
	
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
	@Column(name="pro_title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="pro_department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(name="pro_ssn")
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Column(name="pro_real_name")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Column(name="pro_login_name")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Column(name="pro_password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="instructor")
	public Set<Section> getTeaches() {
		return teaches;
	}

	public void setTeaches(Set<Section> teaches) {
		this.teaches = teaches;
	}
	
	
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	


	public void display() {
		// First, let's display the generic Person info.
		
		// Then, display Professor-specific info.

		System.out.println("Professor-Specific Information:");
		System.out.println("\tTitle:  " + getTitle());
		System.out.println("\tTeaches for Dept.:  " + getDepartment());
		displayTeachingAssignments();

		// Finish with a blank line.

		System.out.println();
	}
	
	// We are forced to program this method because it is specified
	// as an abstract method in our parent class (Person); failing to
	// do so would render the Professor class abstract, as well.
	//
	// For a Professor, we wish to return a String as follows:
	//
	// 	Josephine Blow (Associate Professor, Math)



	@Override
	public String toString() {
		return getRealName() + " (" + getTitle() + ", " +
		       getDepartment() + ")";
	}

	public void displayTeachingAssignments() {
		System.out.println("Teaching Assignments for " + getRealName() + ":");
		
		// We'll step through the teaches ArrayList, processing
		// Section objects one at a time.

		if (teaches.size() == 0) {
			System.out.println("\t(none)");
		}

		else for (Section s : teaches) {
			// Note how we call upon the Section object to do
			// a lot of the work for us!

			System.out.println("\tCourse No.:  " +
				s.getRepresentedCourse().getCourseNo());
			System.out.println("\tSection No.:  " + 
				s.getSectionNo());
			System.out.println("\tCourse Name:  " +
				s.getRepresentedCourse().getCourseName());
			System.out.println("\tDay and Time:  " +
				s.getDayOfWeek() + " - " + 
				s.getTimeOfDay());
			System.out.println("\t-----");
		}
	}
	
	public void agreeToTeach(Section s) {
		teaches.add(s);

		// We need to link this bidirectionally.

		s.setInstructor(this);
	}
	
	/**
	 * 密码判断
	 * @param orgnPs 用户输入的帐号密码
	 * */
	public boolean loginJudgment(Professor orgnPs){
		if(null!=orgnPs){			
			if(password.equals(orgnPs.getPassword())){
				return true;
			}
		}
			return false;		
	}

	/**
	 * 装配列表
	 * @param pList
	 * @return
	 */
	public JSONObject matchList(List<Professor> pList) {
		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(Professor p: pList){
			JSONObject jo=new JSONObject();
			jo.put("id", p.getId());
			jo.put("ssn", p.getSsn());
			jo.put("realName", p.getRealName());
			jo.put("title", p.getTitle());
			jo.put("department", p.getDepartment());
			ja.add(jo);
		}
		rjo.put("recordsTotal", pList.size());
		rjo.put("data", ja.toString());
		return rjo;
	}
	
	
	/**
	 * 将自身属性输出成json对象
	 * @return JSONObject
	 */
	public JSONObject toJSONObject(){
		JSONObject jo=new JSONObject();
		jo.put("id", id);
		jo.put("ssn", ssn);
		jo.put("realName",realName );
		jo.put("loginName", loginName);
		jo.put("password",password );
		jo.put("title", title);
		jo.put("department", department);
		return jo;
	}
}
