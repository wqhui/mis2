package com.ssh.hui.action;

import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.Transcript;
import com.ssh.hui.domain.model.TranscriptEntry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月1日 下午10:31:29 吴清辉新建
 * @version 1.0 
 **/
/**
 * @author hui
 *
 */
public class TranscriptEntryAction extends BaseAction<TranscriptEntry>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private int studentId;
	private int sectionId;
	private String grade;//成绩
	private Section section;
	private Transcript transcript;
	private Student student;
	
	/**
	 * 设置成绩
	 * @return
	 */
	public String setGradeByStu(){
		try {
			student=studentService.get(studentId);
			section=sectionService.get(sectionId);
			if(null!=student && null!=section){
				transcriptEntryService.setGradeByStu(student,section,grade);
				jsonObject.put("status", "ok");	
			}else{
				jsonObject.put("status", "error");		
			}
	
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Transcript getTranscript() {
		return transcript;
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getSectionId() {
		return sectionId;
	}


	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	
	
	

}
