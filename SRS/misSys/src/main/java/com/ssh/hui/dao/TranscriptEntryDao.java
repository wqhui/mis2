package com.ssh.hui.dao;

import java.util.List;

import com.ssh.hui.domain.model.Section;
import com.ssh.hui.domain.model.Student;
import com.ssh.hui.domain.model.TranscriptEntry;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:48:30 吴清辉新建
 * @version 1.0 
 **/
public interface TranscriptEntryDao extends BaseDao<TranscriptEntry>{


	List<TranscriptEntry> queryByStu(Student s);

	/**
	 * 查询学生成绩
	 * @param sd
	 * @param s
	 * @return
	 */
	TranscriptEntry getByStuAndSection(Student sd, Section s);

}
