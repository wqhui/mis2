package com.ssh.hui.domain.model;
// Section.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.HashMap;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Entity
@Table(name="section")

public class Section {
	//------------
	// Attributes.
	//------------
	private int id;
	private int sectionNo;
	private char dayOfWeek;//什么时候上课
	private String timeOfDay;//上课时间
	private String room;//教室
	private int seatingCapacity;//容量
	private Course representedCourse;//课程
	private ScheduleOfClasses offeredIn;//课程表
	private Professor instructor;//上课教师

	// The enrolledStudents HashMap stores Student object references,
	// using each Student's ssn as a String key.

	//private HashMap<String, Student> enrolledStudents; //选课的学生
	private Set<Student> enrolledStudents=new HashSet<Student>(); //选课的学生

	// The assignedGrades HashMap stores TranscriptEntry object
	// references, using a reference to the Student to whom it belongs 
	// as the key.

	//private HashMap<Student, TranscriptEntry> assignedGrades; //给予成绩
	private Set<TranscriptEntry> assignedGrades=new HashSet<TranscriptEntry>(); //给予成绩
	
	//----------------
	// Constructor(s).
	//----------------

	public Section(){}
	
	public Section(int sNo, char day, String time, Course course,
		       String room, int capacity) {
		setSectionNo(sNo);
		setDayOfWeek(day);
		setTimeOfDay(time);
		setRepresentedCourse(course);
		setRoom(room);
		setSeatingCapacity(capacity);

		// A Professor has not yet been identified.

		setInstructor(null);

		// Note that we're instantiating empty support Collection(s).

//		enrolledStudents = new HashMap<String, Student>();
//		assignedGrades = new HashMap<Student, TranscriptEntry>();
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
	@Column(name="section_no")
	public int getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}
	
	@Column(name="section_day_of_week")
	public char getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(char dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	@Column(name="section_time_of_day")
	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
	@Column(name="section_room")
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	@Column(name="section_seats")
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="course_id",referencedColumnName="id")
	public Course getRepresentedCourse() {
		return representedCourse;
	}

	public void setRepresentedCourse(Course representedCourse) {
		this.representedCourse = representedCourse;
	}

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="soc_id",referencedColumnName="id")
	public ScheduleOfClasses getOfferedIn() {
		return offeredIn;
	}

	public void setOfferedIn(ScheduleOfClasses offeredIn) {
		this.offeredIn = offeredIn;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="professor_id",referencedColumnName="id")
	public Professor getInstructor() {
		return instructor;
	}

	public void setInstructor(Professor instructor) {
		this.instructor = instructor;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name ="section_student_relation",
	joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "section_id", referencedColumnName ="id")})
	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Set<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="section")
	public Set<TranscriptEntry> getAssignedGrades() {
		return assignedGrades;
	}

	public void setAssignedGrades(Set<TranscriptEntry> assignedGrades) {
		this.assignedGrades = assignedGrades;
	}

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	// For a Section, we want its String representation to look
	// as follows:
	//
	//	MATH101 - 1 - M - 8:00 AM




	@Override
	public String toString() {
		return getRepresentedCourse().getCourseNo() + " - " +
		       getSectionNo() + " - " +
		       getDayOfWeek() + " - " +
		       getTimeOfDay();
	}

	// The full section number is a concatenation of the
	// course no. and section no., separated by a hyphen;
	// e.g., "ART101 - 1".

	

	/**
	 * 获得所有sectionNo
	 * */
	@Transient
	public String getFullSectionNo() {
		return getRepresentedCourse().getCourseNo() + 
		       " - " + getSectionNo();
	}

	/**
	 * 获得所有section信息
	 * */
	@Transient
	public String getFullSectionInfo() {
		return getRepresentedCourse().getCourseName() + 
			   "-" + getDayOfWeek() + "-" +
		       "" + getTimeOfDay() +
		       "-" + this.getRoom();
	}
	

	// We use an enum -- EnrollmentStatus -- to return an indication of the
	// outcome of the request to enroll Student s.  See EnrollmentStatus.java
	// for details on this enum.

	/**
	 * 给section添加学生
	 * */
	public EnrollmentStatus enroll(Student s) {
		// First, make sure that this Student is not already
		// enrolled for this Section, and that he/she has
		// NEVER taken and passed the course before.  
		
		Transcript transcript = s.getTranscript();

		if (s.isCurrentlyEnrolledInSimilar(this) || 
		    transcript.verifyCompletion(this.getRepresentedCourse())) {
			return EnrollmentStatus.prevEnroll;
		}

		// If there are any prerequisites for this course,
		// check to ensure that the Student has completed them.

		Course c = this.getRepresentedCourse();
		if (c.hasPrerequisites()) {
			for (Course pre : c.getPrerequisites()) {
				// See if the Student's Transcript reflects
				// successful completion of the prerequisite.

				if (!transcript.verifyCompletion(pre)) {
					return EnrollmentStatus.prereq;
				}
			}
		}
		
		// If the total enrollment is already at the
		// the capacity for this Section, we reject this 
		// enrollment request.

		if (!this.confirmSeatAvailability()) {
			return EnrollmentStatus.secFull;
		}
		
		// If we made it to here in the code, we're ready to
		// officially enroll the Student.

		// Note bidirectionality:  this Section holds
		// onto the Student via the HashMap, and then
		// the Student is given a handle on this Section.

//		enrolledStudents.put(s.getSsn(), s);
		enrolledStudents.add(s);
		s.addSection(this);

		return EnrollmentStatus.success;
	}
	
	// A private "housekeeping" method.

	private boolean confirmSeatAvailability() {
		if (enrolledStudents.size() < getSeatingCapacity()) return true;
		else return false;
	}

	public boolean drop(Student s) {
		// We may only drop a student if he/she is enrolled.

		if (!s.isEnrolledIn(this)) return false;
		else {
			// Find the student in our HashMap, and remove it.

			enrolledStudents.remove(s.getSsn());

			// Note bidirectionality.

			s.dropSection(this);
			return true;
		}
	}
	@Transient
	public int getTotalEnrollment() {
		return enrolledStudents.size();
	}	

	public void display() {
		System.out.println("Section Information:");
		System.out.println("\tSemester:  " + getOfferedIn().getSemester());
		System.out.println("\tCourse No.:  " + 
				   getRepresentedCourse().getCourseNo());
		System.out.println("\tSection No:  " + getSectionNo());
		System.out.println("\tOffered:  " + getDayOfWeek() + 
				   " at " + getTimeOfDay());
		System.out.println("\tIn Room:  " + getRoom());
		if (getInstructor() != null) 
			System.out.println("\tProfessor:  " + 
				   getInstructor().getRealName());
		displayStudentRoster();
	}
	
	public void displayStudentRoster() {
		System.out.print("\tTotal of " + getTotalEnrollment() + 
				   " students enrolled");

		// How we punctuate the preceding message depends on 
		// how many students are enrolled (note that we used
		// a print() vs. println() call above).

		if (getTotalEnrollment() == 0) System.out.println(".");
		else System.out.println(", as follows:");

		// Iterate through all of the values stored in the HashMap.

		for (Student s : enrolledStudents) {
			System.out.println("\t\t" + s.getRealName());
		}
	}

	// This method returns the value null if the Student has not
	// been assigned a grade.
	
	/**
	 * 根据学生获得分数
	 * */
	@Transient
	public String getGrade(Student s) {
		String grade = null;

		// Retrieve the associated TranscriptEntry object for this specific 
		// student from the assignedGrades HashMap, if one exists, and in turn 
		// retrieve its assigned grade.

//		TranscriptEntry te = assignedGrades.get(s);
//		if (te != null) {
//			grade = te.getGrade(); 
//		}
		s.getTranscript().getTranscriptEntries();
		for(TranscriptEntry te :assignedGrades){
			if (te != null ) {
				grade = te.getGrade(); 
			}
		}
		
		// If we found no TranscriptEntry for this Student, a null value
		// will be returned to signal this.

		return grade;
	}

	public boolean postGrade(Student s, String grade) {
		// First, validate that the grade is properly formed by calling
		// a utility method provided by the TranscriptEntry class.

//		if (!TranscriptEntry.validateGrade(grade)) return false;
//
//		// Make sure that we haven't previously assigned a
//		// grade to this Student by looking in the HashMap
//		// for an entry using this Student as the key.  If
//		// we discover that a grade has already been assigned,
//		// we return a value of false to indicate that
//		// we are at risk of overwriting an existing grade.  
//		// (A different method, eraseGrade(), can then be written
//		// to allow a Professor to change his/her mind.)
//
//		if (assignedGrades.get(s) != null) return false;
//
//		// First, we create a new TranscriptEntry object.  Note
//		// that we are passing in a reference to THIS Section,
//		// because we want the TranscriptEntry object,
//		// as an association class ..., to maintain
//		// "handles" on the Section as well as on the Student.
//		// (We'll let the TranscriptEntry constructor take care of
//		// linking this T.E. to the correct Transcript.)
//
//		TranscriptEntry te = new TranscriptEntry(s, grade, this);
//
//		// Then, we "remember" this grade because we wish for
//		// the connection between a T.E. and a Section to be
//		// bidirectional.
//
//		assignedGrades.put(s, te);

		return true;
	}
	@Transient
	public boolean isSectionOf(Course c) {
		if (c == representedCourse) return true;
		else return false;
	}
	
	
	/**
	 * 装配列表
	 * @param sList
	 * @return
	 */
	public JSONObject toJSONObjectList(List<Section> sList) {
		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(Section s:sList){
			JSONObject jo=new JSONObject();
			jo.put("id", s.getId());
			jo.put("sectionNo", s.getSectionNo());
			jo.put("representedCourse", s.getRepresentedCourse().getCourseName());
			jo.put("instructor", s.getInstructor().getRealName());
			jo.put("seatingCapacity", s.getSeatingCapacity());			
			jo.put("timeOfDay", s.getTimeOfDay());//时间
			jo.put("dayOfWeek", s.getDayOfWeek());//周几
			jo.put("room", s.getRoom());//教室			
			ja.add(jo);
		}
		rjo.put("recordsTotal", sList.size());
		rjo.put("data", ja.toString());
		return rjo;
	}

	/**
	 * 返回secionId和课程相关
	 * @param sList
	 * @return
	 */
	public JSONObject toJSONObjectCourseList(List<Section> sList) {

		JSONObject rjo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(Section s:sList){
			JSONObject jo=new JSONObject();
			jo.put("sectionId", s.getId());
			representedCourse=s.getRepresentedCourse();
			if(null!=representedCourse){
				jo.put("courseId", representedCourse.getId());
				jo.put("courseNo", representedCourse.getCourseNo());
				jo.put("courseName", representedCourse.getCourseName());
				jo.put("credits", representedCourse.getCredits());
				if(null!=representedCourse.getCourseCatalog()){
					jo.put("courseCatalogName",representedCourse.getCourseCatalog().getCatalogName());
				}else{
					jo.put("courseCatalogName","其他");
				}
			}
			ja.add(jo);
		}
		
		rjo.put("recordsTotal", sList.size());
		rjo.put("data", ja.toString());
		return rjo;
	}

}
