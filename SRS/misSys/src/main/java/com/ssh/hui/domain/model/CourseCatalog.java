package com.ssh.hui.domain.model;
// CourseCatalog.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// An IMPLEMENTATION class.


// As mentioned in Chapter 14, we've decided to encapsulate a Collection
// of Courses within the CourseCatalog class the way that we encapsulated a
// Collection of Sections within the ScheduleOfClasses class in Chapter 14.
// This provides an increased level of abstraction in our application.

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
@Entity
@Table(name="course_catalog")
public class CourseCatalog {
	//------------
	// Attributes.
	//------------

	// This HashMap stores Course object references, using
	// the course no. of the Course (a String) as the key.
	private int id;
	private String catalogName;//类别名字
	private Set<Course> courses=new HashSet<Course>();

	//----------------
	// Constructor(s).
	//----------------

	public CourseCatalog() {
		// Note that we're instantiating empty support Collection(s).
	}
	
	public CourseCatalog(HashSet<Course> courses) {
		// Note that we're instantiating empty support Collection(s).

		this.courses = courses;
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

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="courseCatalog")
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@Column(name="catalog_name")
	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------





	public void display() {
		// Iterate through the HashMap and display all entries.

		for (Course c : courses) {
			c.display();
			System.out.println();
		}
	}



	public void addCourse(Course c) {
		// We use the course no. as the key.

		String key = c.getCourseNo();
		courses.add( c);
	}
	/**
	 * 根据课程号查询课程
	 * @param
	 * @return course
	 * */
	public Course findCourse(String courseNo) {
		Course cs=new Course();
		for(Course c: courses ){
			if(c.getCourseNo().equals(courseNo)){
				return c;
			}
		}
		return cs;
	}
	
//	/**
//	 * 根据课程类别查询课程列表
//	 * @param
//	 * @return courses
//	 * */
//	public List<Course> findCourses(String catalogName) {
//		List<Course> myCourses=ArrayList<>();
//		
//		for(Course c: courses){
//			if(c.getCourseNo().equals(courseNo)){
//				return c;
//			}
//		}
//		return myCourses;
//	}
	@Transient
	public boolean isEmpty() {
		if (courses.size() == 0) return true;
		else return false;
	}
	/**
	 * 装配列表
	 * @param cList
	 * @return
	 */
	public JSONObject toJSONObjectList(List<CourseCatalog> cList) {
		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(CourseCatalog c:cList){
			JSONObject jo=new JSONObject();
			jo.put("id",c.getId());
			jo.put("catalogName",c.getCatalogName());
			ja.add(jo);
		}
		rjo.put("recordsTotal", cList.size());
		rjo.put("data", ja.toString());
		return rjo;
	}
}
