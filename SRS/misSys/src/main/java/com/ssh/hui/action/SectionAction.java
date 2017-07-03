package com.ssh.hui.action;

import com.ssh.hui.domain.model.Course;
import com.ssh.hui.domain.model.Professor;
import com.ssh.hui.domain.model.ScheduleOfClasses;
import com.ssh.hui.domain.model.Section;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月3日 下午9:00:30 吴清辉新建
 * @version 1.0 
 **/
public class SectionAction extends BaseAction<Section>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	private int id;
	private int professorId;
	private int courseId;
	private int sectionNo;
	private char dayOfWeek;//什么时候上课
	private String timeOfDay;//上课时间
	private String room;//教室
	private int seatingCapacity;//容量
	private Course representedCourse;//课程
	private ScheduleOfClasses offeredIn;//课程表
	private Professor instructor;//上课教师
	
	/**
	 * 
	 * @return 列表
	 */
	public String queryList(){
		jsonObject=sectionService.queryList();
		return "jsonObject";
	}
	

	/**
	 * 保存
	 * @return
	 */
	public String saveOrUpdateSection(){
		try {
			representedCourse=courseService.get(courseId);
			instructor=professorService.get(professorId);
			Section s=new Section(sectionNo,dayOfWeek,timeOfDay,representedCourse,room,seatingCapacity);
			s.setInstructor(instructor);
			if(id>0){
				s.setId(id);
			}
			sectionService.update(s);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();
		}
		return "jsonObject";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String deleteSection(){
		try {
			sectionService.delete(id);
			jsonObject.put("status", "ok");
		} catch (Exception e) {
			jsonObject.put("status", "error");
			e.printStackTrace();
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
	public int getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}
	public char getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(char dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public Course getRepresentedCourse() {
		return representedCourse;
	}
	public void setRepresentedCourse(Course representedCourse) {
		this.representedCourse = representedCourse;
	}
	public ScheduleOfClasses getOfferedIn() {
		return offeredIn;
	}
	public void setOfferedIn(ScheduleOfClasses offeredIn) {
		this.offeredIn = offeredIn;
	}
	public Professor getInstructor() {
		return instructor;
	}
	public void setInstructor(Professor instructor) {
		this.instructor = instructor;
	}


	public int getProfessorId() {
		return professorId;
	}


	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
	
	
}