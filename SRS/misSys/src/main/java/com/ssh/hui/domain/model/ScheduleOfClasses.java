package com.ssh.hui.domain.model;
// ScheduleOfClasses.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.HashMap;
import java.util.HashSet;
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
import javax.persistence.Transient;
@Entity
@Table(name="schedule_of_classes")
public class ScheduleOfClasses {
	//------------
	// Attributes.
	//------------
	
	private int id;
	private String semester;//学期

	// This HashMap stores Section object references, using
	// a String concatenation of course no. and section no. as the
	// key, e.g., "MATH101 - 1".

	//private HashMap<String, Section> sectionsOffered; 
	private Set<Section> sectionsOffered=new HashSet<Section>() ;//相关的section 

	//----------------
	// Constructor(s).
	//----------------
	
	public ScheduleOfClasses(){}

	public ScheduleOfClasses(String semester) {
		setSemester(semester);
		
		// Note that we're instantiating empty support Collection(s).

		//sectionsOffered = new HashMap<String, Section>();
	}

	public ScheduleOfClasses(String semester, HashSet<Section> sectionsOffered ) {
		setSemester(semester);
		
		// Note that we're instantiating empty support Collection(s).

		this.sectionsOffered = sectionsOffered;
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

	@Column(name="soc_semester")
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="offeredIn")
	public Set<Section> getSectionsOffered() {
		return sectionsOffered;
	}

	public void setSectionsOffered(Set<Section> sectionsOffered) {
		this.sectionsOffered = sectionsOffered;
	}
		
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------



	public void display() {
		System.out.println("Schedule of Classes for " + getSemester());
		System.out.println();

		// Iterate through all the values in the HashMap.
		
		for(Section s : sectionsOffered){
			s.display();
			System.out.println();
		}
		
//		for (Section s : sectionsOffered.values()) {
//			s.display();
//			System.out.println();
//		}
	}
	
	

	


	/**
	 * 添加sesion
	 * */
	public void addSection(Section s) {
		// We formulate a key by concatenating the course no.
		// and section no., separated by a hyphen.

		String key = s.getRepresentedCourse().getCourseNo() + 
			     " - " + s.getSectionNo();
		sectionsOffered.add(s);
		//sectionsOffered.put(s);

		// Bidirectionally link the ScheduleOfClasses back to the Section.

		s.setOfferedIn(this);
	}

	// The full section number is a concatenation of the
	// course no. and section no., separated by a hyphen;
	// e.g., "ART101 - 1".
	
	/**
	 * 根据sessionNo查询Session
	 * @param 
	 * @return
	 * */
	public Section findSection(String fullSectionNo) {
		Section s=new Section();
		return s;	
		//return sectionsOffered.get(fullSectionNo);
	}
	@Transient
	public boolean isEmpty() {
		if (sectionsOffered.size() == 0) return true;
		else return false;
	}
}
