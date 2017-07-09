一、数据库切换
------- 
> 数据库切换许修改如下第一个图（web.xml），若要新添数据连接，需求改如下两处并添加数据库配置文件
![修改1](https://github.com/DeathKL/mis2/blob/master/guitarV3/Img/11.png)
![修改2](https://github.com/DeathKL/mis2/blob/master/guitarV3/Img/12.png)

二、项目结构
------- 
![项目结构](https://github.com/DeathKL/mis2/blob/master/SRS/Img/%E9%A1%B9%E7%9B%AE%E7%BB%93%E6%9E%84.png)

三、数据库
------- 
![数据库](https://github.com/DeathKL/mis2/blob/master/SRS/Img/database.png)

四、类图
------- 
![类图](https://github.com/DeathKL/mis2/blob/master/SRS/Img/%E7%B1%BB%E5%9B%BE.png)


五、时序图
------- 
- 选课时序图

  ![选课时序图](https://github.com/DeathKL/mis2/blob/master/SRS/Img/%E9%80%89%E8%AF%BE%E6%97%B6%E5%BA%8F%E5%9B%BE.png)
  
- 查询成绩时序图

  ![查询成绩时序图](https://github.com/DeathKL/mis2/blob/master/SRS/Img/%E6%9F%A5%E8%AF%A2%E6%88%90%E7%BB%A9%E6%97%B6%E5%BA%8F%E5%9B%BE.png)

六、选课逻辑
------- 
  
```
	public JSONObject chooseCourse(Student s, int sectionId) {	
		JSONObject jo=new JSONObject();			
		jo.put("status", "ok");
		Section st=sectionDao.get(sectionId);//获得该section
		int capacitySize=st.getSeatingCapacity();
		PlanOfStudy pos=planOfStudyDao.getByStu(s);
		if(pos.isPlanCourse(st.getRepresentedCourse())){
			if(capacitySize>0){//是否有余量
				st.setSeatingCapacity(capacitySize-1);//余量-1
				Course crs= st.getRepresentedCourse();
				if(courseSpecificationImpl.hasPrerequisites(crs)){//判断是否有先修课
					if(courseSpecificationImpl.isPassPrerequisites(crs.getPrerequisites(),s)){
						Student ns=studentDao.get(s.getId());
						sectionDao.update(st);
						ns.addSection(st);
						transcriptEntryDao.save(new TranscriptEntry(ns,null,st));						
						studentDao.update(ns);					
					}else{
						jo.put("status", "noPass");
					}
					
				}else{
					Student ns=studentDao.get(s.getId());
					sectionDao.update(st);
					ns.addSection(st);
					transcriptEntryDao.save(new TranscriptEntry(ns,null,st));						
					studentDao.update(ns);				
				};
			}else{
				jo.put("status", "noCapacity");
				
			}
		}else{
			jo.put("status", "noPlan");
		}
		
		

		return jo;
	}
```

七、运行界面
------- 
- 后台登录（默认用户名：sa 密码：1）

![后台登录](https://github.com/DeathKL/mis2/blob/master/SRS/Img/pro_login.png)

- 教师管理

![后台登录](https://github.com/DeathKL/mis2/blob/master/SRS/Img/professor.png)

- 课程管理

![课程管理](https://github.com/DeathKL/mis2/blob/master/SRS/Img/course.png)

- 学习计划管理

![学习计划管理](https://github.com/DeathKL/mis2/blob/master/SRS/Img/plan.png)

- section管理

![section管理](https://github.com/DeathKL/mis2/blob/master/SRS/Img/section.png)

- 成绩管理

![成绩管理](https://github.com/DeathKL/mis2/blob/master/SRS/Img/setGrade.png)



- 学生登录

![学生登录](https://github.com/DeathKL/mis2/blob/master/SRS/Img/stu_login.png)

- 前台选课

![学生选课](https://github.com/DeathKL/mis2/blob/master/SRS/Img/stu_section.png)

- 学生成绩

![学生成绩](https://github.com/DeathKL/mis2/blob/master/SRS/Img/transcript.png)
