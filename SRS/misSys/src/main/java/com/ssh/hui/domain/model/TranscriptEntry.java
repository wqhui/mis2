package com.ssh.hui.domain.model;
// TranscriptEntry.java - Chapter 14, Java 5 version.

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

// Copyright 2005 by Jacquie Barker - all rights reserved.
// A MODEL class.

@Entity
@Table(name="transcript_entry")
public class TranscriptEntry {
	//------------
	// Attributes.
	//------------
	private int id;
	private String grade;//成绩
	private Section section;
	private Transcript transcript;
	private Student student;

	//----------------
	// Constructor(s).
	//----------------
	public TranscriptEntry(){};
	
	public TranscriptEntry(Student s, String grade, Section se) {
		//this.setStudent(s);
		this.setSection(se);
		this.setGrade(grade);
		this.setStudent(s);
		
		// Obtain the Student's transcript ...

		Transcript t = s.getTranscript();

		// ... and then link the Transcript and the TranscriptEntry
		// together bidirectionally.

		this.setTranscript(t);
		t.addTranscriptEntry(this);
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
	@Column(name="transcript_e_grade")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="section_id",referencedColumnName="id")
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="transcript_id",referencedColumnName="id")
	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="student_id",referencedColumnName="id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	// These next two methods are declared to be static, so that they
	// may be used as utility methods.

	


	/**
	 * 验证成绩是否合法
	 * 
	 * */
	public static boolean validateGrade(String grade) {
		boolean outcome = false;
		if(null!=grade){
			if (grade.equals("F") ||
				    grade.equals("I")) {
					outcome = true;
				}

				if (grade.startsWith("A") ||
				    grade.startsWith("B") ||
				    grade.startsWith("C") ||
				    grade.startsWith("D")) {
					if (grade.length() == 1) outcome = true;
					else if (grade.length() == 2) {
						if (grade.endsWith("+") ||
						    grade.endsWith("-")) {
							outcome = true;
						}
					}
				}
		}

		return outcome;
	}

	/**
	 * 成绩是否合格
	 * */
	public static boolean passingGrade(String grade) {
		boolean outcome = false;

		// First, make sure it is a valid grade.

		if (validateGrade(grade)) {
			// Next, make sure that the grade is a D or better.

			if (grade.startsWith("A") ||
			    grade.startsWith("B") ||
			    grade.startsWith("C") ||
			    grade.startsWith("D")) {
				outcome = true;
			}
		}

		return outcome;
	}

}
