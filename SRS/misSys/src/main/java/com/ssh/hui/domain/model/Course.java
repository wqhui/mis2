package com.ssh.hui.domain.model;
// Course.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.persistence.JoinColumn;
@Entity
@Table(name="course")
public class Course {
	//------------
	// Attributes.
	//------------
	
	private int id;
	private String courseNo;//课程编号
	private String courseName;//课程名字
	private double credits;//学分	
	private boolean hasPrerequisites;//是否有先修课程
	private Set<Course> prerequisites=new HashSet<Course>() ;//先修课程 (自身多对多关系)
	private Set<Course>  postCondition=new HashSet<Course>() ;//后修课程(自身多对多关系)
	private Set<Section> offeredAsSection=new HashSet<Section>() ;//相关的section 
	private Set<PlanOfStudy> planOfStudys=new HashSet<PlanOfStudy>();//对应的学习计划
	private CourseCatalog courseCatalog;
	//----------------
	// Constructor(s).
	//----------------
	
	public Course(){}
	
	public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);

		// Note that we're instantiating empty support Collection(s).

		//offeredAsSection = new ArrayList<Section>();
		//prerequisites = new ArrayList<Course>();
	}

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
	@Column(name="course_no")		
	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	
	@Column(name="course_name")	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@Column(name="course_credits")	
	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="representedCourse")
	public Set<Section> getOfferedAsSection() {
		return offeredAsSection;
	}

	public void setOfferedAsSection(Set<Section> offeredAsSection) {
		this.offeredAsSection = offeredAsSection;
	}		

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name ="course_pre_post",
	joinColumns = {@JoinColumn(name = "post_condition_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "prerequisites_id", referencedColumnName ="id")})
	public Set<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Set<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "course_pre_post",
	joinColumns = {@JoinColumn(name = "prerequisites_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "post_condition_id", referencedColumnName ="id")})
	public Set<Course> getPostCondition() {
		return postCondition;
	}

	public void setPostCondition(Set<Course> postCondition) {
		this.postCondition = postCondition;
	}
	
	
	@Column(name="course_has_prerequisites")	
	public boolean isHasPrerequisites() {
		return hasPrerequisites;
	}

	public void setHasPrerequisites(boolean hasPrerequisites) {
		this.hasPrerequisites = hasPrerequisites;
	}

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="course_catalog_id",referencedColumnName="id")
	public CourseCatalog getCourseCatalog() {
		return courseCatalog;
	}

	public void setCourseCatalog(CourseCatalog courseCatalog) {
		this.courseCatalog = courseCatalog;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name ="plan_course_relation",
	joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "plan_id", referencedColumnName ="id")})
	public Set<PlanOfStudy> getPlanOfStudys() {
		return planOfStudys;
	}
	public void setPlanOfStudys(Set<PlanOfStudy> planOfStudys) {
		this.planOfStudys = planOfStudys;
	}
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------



	




	/**
	 * 显示
	 * */
	public void display() {
		System.out.println("Course Information:");
		System.out.println("\tCourse No.:  " + getCourseNo());
		System.out.println("\tCourse Name:  " + getCourseName());
		System.out.println("\tCredits:  " + getCredits());
		System.out.println("\tPrerequisite Courses:");

		for (Course c : prerequisites) {
			System.out.println("\t\t" + c.toString());
		}

		// Note use of print vs. println in next line of code.

		System.out.print("\tOffered As Section(s):  ");
		for (Section s : offeredAsSection) {
			System.out.print(s.getSectionNo() + " ");
		}

		// Finish with a blank line.

		System.out.println();
	}
	
	

	@Override
	public String toString() {
		return getCourseNo() + ":  " + getCourseName();
	}
	
	/**
	 * 添加先决条件
	 * */
	public void addPrerequisite(Course c) {
		prerequisites.add(c);
	}
	
	/**
	 * 是否有先修课程
	 * */
	public boolean hasPrerequisites() {
		if (prerequisites.size() > 0) return true;
		else return false;
	}
	
	/**
	 * 该课程是否为param的先修课程
	 * */
	@Transient
	public boolean isPrerequisit(Course c) {
		for(Course tc: postCondition){
			if (tc.getId()==c.getId()){
				return true;
			} 
		}
		return false;

	}

	public Section scheduleSection(char day, String time, String room,
				       int capacity) {
		// Create a new Section (note the creative way in
		// which we are assigning a section number) ...

		Section s = new Section(offeredAsSection.size() + 1, 
				day, time, this, room, capacity);
		
		// ... and then remember it!

		addSection(s);
		
		return s;
	}

	public void addSection(Section s) {
		offeredAsSection.add(s);
	}

	
	/**
	 * 装配列表
	 * @param cList
	 * @return
	 */
	public JSONObject toJSONObjectList(List<Course> cList) {
		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(Course c:cList){
			JSONObject jo=new JSONObject();
			jo.put("id", c.getId());
			jo.put("courseNo", c.getCourseNo());
			jo.put("courseName", c.getCourseName());
			jo.put("credits", c.getCredits());
			System.out.println(c.getCourseCatalog());
			if(null!=c.getCourseCatalog()){
				jo.put("courseCatalogName",c.getCourseCatalog().getCatalogName());
			}else{
				jo.put("courseCatalogName","其他");
			}
			
			ja.add(jo);
		}
		rjo.put("recordsTotal", cList.size());
		rjo.put("data", ja.toString());
		return rjo;
	}
	
	
	/**
	 * 自身转化为jsonObject
	 * @return
	 */
	public JSONObject toJSONObject() {
		JSONObject jo=new JSONObject();
		jo.put("id", id);
		jo.put("courseNo", courseNo);
		jo.put("courseName", courseName);
		jo.put("credits", credits);
		if(null!=courseCatalog){
			jo.put("courseCatalogName",courseCatalog.getCatalogName());
		}else{
			jo.put("courseCatalogName","其他");
		}
		return jo;
	}
}
