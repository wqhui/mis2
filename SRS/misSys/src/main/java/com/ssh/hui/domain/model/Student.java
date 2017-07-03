package com.ssh.hui.domain.model;
// Student.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="student")
public class Student{
	//------------
	// Attributes.
	//------------
	private int id;
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
	
	//----------------
	// Constructor(s).
	//----------------
	public Student(){}

	public Student(String name, String ssn, String major, String degree) {
		// Reuse the code of the parent's constructor.

		this.setMajor(major);
		this.setDegree(degree);

		// Create a brand new Transcript.

		this.setTranscript(new Transcript(this));

		// Note that we're instantiating empty support Collection(s).

		//attends = new ArrayList<Section>();
	}
	
	// A second simpler form of constructor.

	public Student(String ssn) {
		// Reuse the code of the other Student constructor.

		this("TBD", ssn, "TBD", "TBD");
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
	@Column(name="stu_major")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	@Column(name="stu_degree")
	public String getDegree() {
		return degree;
	}			

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name="stu_real_name")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Column(name="stu_login_name")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Column(name="stu_password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="stu_ssn")		
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@OneToOne(mappedBy="studentOwner",fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name ="section_student_relation",
	joinColumns = {@JoinColumn(name = "section_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName ="id")})
	public Set<Section> getAttends() {
		return attends;
	}

	public void setAttends(Set<Section> attends) {
		this.attends = attends;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinTable(name ="plan_student_relation",
	joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "plan_of_study_id", referencedColumnName ="id")})
	public PlanOfStudy getPlanOfStudy() {
		return planOfStudy;
	}

	public void setPlanOfStudy(PlanOfStudy planOfStudy) {
		this.planOfStudy = planOfStudy;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="department_id",referencedColumnName="id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------






	public void display() {
		
		// Then, display Student-specific info.
		System.out.println("Student-Specific Information:");
		System.out.println("\tMajor:  " + this.getRealName());
		System.out.println("\tMajor:  " + this.getMajor());
		System.out.println("\tDegree:  " + this.getDegree());
		this.displayCourseSchedule();
		this.printTranscript();

		// Finish with a blank line.
		System.out.println();
	}	
	
	// We are forced to program this method because it is specified
	// as an abstract method in our parent class (Person); failing to
	// do so would render the Student class abstract, as well.
	//
	// For a Student, we wish to return a String as follows:
	//
	// 	Joe Blow (123-45-6789) [Master of Science - Math]

	
	@Override
	public String toString() {
		return this.getRealName() + " (" + this.getSsn() + ") [" + this.getDegree() +
		       " - " + this.getMajor() + "]";
	}

	public void displayCourseSchedule() {
		// Display a title first.

		System.out.println("Course Schedule for " + this.getRealName());
		
		// Step through the ArrayList of Section objects, 
		// processing these one by one.

		for (Section s : attends) {
		    // Since the attends ArrayList contains Sections that the
		    // Student took in the past as well as those for which
		    // the Student is currently enrolled, we only want to
		    // report on those for which a grade has not yet been
		    // assigned.
            
                    if (s.getGrade(this) == null) {
			System.out.println("\tCourse No.:  " + 
				s.getRepresentedCourse().getCourseNo());
			System.out.println("\tSection No.:  " + 
				s.getSectionNo());
			System.out.println("\tCourse Name:  " + 
				s.getRepresentedCourse().getCourseName());
			System.out.println("\tMeeting Day and Time Held:  "  +
				s.getDayOfWeek() + " - " +
				s.getTimeOfDay());
			System.out.println("\tRoom Location:  "  +
				s.getRoom());
			System.out.println("\tProfessor's Name:  " +
				s.getInstructor().getRealName());
			System.out.println("\t-----");
		    }
		}
	}
	
	/**
	 * 选课
	 * */
	public void addSection(Section s) {
		attends.add(s);
	}
	
	/**
	 * 退课
	 * */
	public void dropSection(Section s) {
		attends.remove(s);
	}
	
	// Determine whether the Student is already enrolled in THIS
	// EXACT Section.
	
	/**
	 * */
	public boolean isEnrolledIn(Section s) {
		if (attends.contains(s)) return true;
		else return false;
	}
		
	// Determine whether the Student is already enrolled in ANOTHER
	// Section of this SAME Course.
	
	/**
	 * 现在选的课
	 * */
	public boolean isCurrentlyEnrolledInSimilar(Section s1) {
		boolean foundMatch = false;

		Course c1 = s1.getRepresentedCourse();

		for (Section s2 : attends) {
			Course c2 = s2.getRepresentedCourse();
			if (c1 == c2) {
				// There is indeed a Section in the attends()
				// ArrayList representing the same Course.
				// Check to see if the Student is CURRENTLY
				// ENROLLED (i.e., whether or not he has
				// yet received a grade).  If there is no
				// grade, he/she is currently enrolled; if
				// there is a grade, then he/she completed
				// the course some time in the past.
				if (s2.getGrade(this) == null) {
					// No grade was assigned!  This means
					// that the Student is currently
					// enrolled in a Section of this
					// same Course.
					foundMatch = true;
					break;
				}
			}
		}

		return foundMatch;
	}
		
	public void printTranscript() {
		this.getTranscript().display();
	}
	
	

}
