package com.ssh.hui.action;

import java.util.HashSet;
import java.util.Set;

import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.Transcript;
import com.ssh.hui.domain.model.TranscriptEntry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月5日 下午9:36:02 吴清辉新建
 * @version 1.0 
 **/
public class TranscriptAction extends BaseAction<Transcript>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private Set<TranscriptEntry> transcriptEntries=new HashSet<TranscriptEntry>();//成绩列表
	private Student studentOwner;//学生
	
	/**
	 * 根据学生查询成绩单
	 */
	public String getByStu(){
		if(id>0){
			studentOwner=studentService.get(id);//这里是student id;
			if(null!=studentOwner){
				jsonObject=transcriptService.getByStu(studentOwner);
			}
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
	public Set<TranscriptEntry> getTranscriptEntries() {
		return transcriptEntries;
	}
	public void setTranscriptEntries(Set<TranscriptEntry> transcriptEntries) {
		this.transcriptEntries = transcriptEntries;
	}
	public Student getStudentOwner() {
		return studentOwner;
	}
	public void setStudentOwner(Student studentOwner) {
		this.studentOwner = studentOwner;
	}
	
	
	
	
}
