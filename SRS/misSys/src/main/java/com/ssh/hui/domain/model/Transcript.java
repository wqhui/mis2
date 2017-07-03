package com.ssh.hui.domain.model;
// Transcript.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="transcript")
public class Transcript {
	//------------
	// Attributes.
	//------------
	private int id;
	private Set<TranscriptEntry> transcriptEntries=new HashSet<TranscriptEntry>();//成绩列表
	private Student studentOwner;//学生

	//----------------
	// Constructor(s).
	//----------------
	
	public Transcript() {}
	
	public Transcript(Student s) {
		setStudentOwner(s);

		// Note that we're instantiating empty support Collection(s).

		//transcriptEntries = new ArrayList<TranscriptEntry>();
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
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name = "student_id",referencedColumnName="id")
	public Student getStudentOwner() {
		return studentOwner;
	}

	public void setStudentOwner(Student studentOwner) {
		this.studentOwner = studentOwner;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE,mappedBy="transcript")
	public Set<TranscriptEntry> getTranscriptEntries() {
		return transcriptEntries;
	}

	public void setTranscriptEntries(Set<TranscriptEntry> transcriptEntries) {
		this.transcriptEntries = transcriptEntries;
	}


	

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------
	
	/**
	 * 验证是否通过课程
	 * */
	public boolean verifyCompletion(Course c) {
		boolean outcome = false;

		// Step through all TranscriptEntries, looking for one
		// which reflects a Section of the Course of interest.

		for (TranscriptEntry te : transcriptEntries) {
//			Section s = te.getSection();
//
//			if (s.isSectionOf(c)) {
//			    // Ensure that the grade was high enough.
//
//			    if (TranscriptEntry.passingGrade(te.getGrade())) {
//				outcome = true;
//
//				// We've found one, so we can afford to
//				// terminate the loop now.
//
//				break;
//			    }
//			}
		}

		return outcome;
	}

	/**
	 * 添加成绩记录
	 * @param TranscriptEntry te 
	 * */
	public void addTranscriptEntry(TranscriptEntry te) {
		transcriptEntries.add(te);
	}

	/**
	 * 打印成绩记录
	 * 
	 * */
	public void display() {
		System.out.println("Transcript for:  " +
				   getStudentOwner().toString());

		if (transcriptEntries.size() == 0) {
			System.out.println("\t(no entries)");
		}
		else for (TranscriptEntry te : transcriptEntries) {
//			Section sec = te.getSection();
//
//			Course c = sec.getRepresentedCourse();
//
//			ScheduleOfClasses soc = sec.getOfferedIn();
//
//			System.out.println("\tSemester:        " +
//					   soc.getSemester());
//			System.out.println("\tCourse No.:      " +
//					   c.getCourseNo());
//			System.out.println("\tCredits:         " +
//					   c.getCredits());
//			System.out.println("\tGrade Received:  " +
//					   te.getGrade());
//			System.out.println("\t-----");
		}
	}
}
