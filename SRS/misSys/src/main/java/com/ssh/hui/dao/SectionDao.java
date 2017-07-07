package com.ssh.hui.dao;

import java.util.List;

import com.ssh.hui.domain.model.Professor;
import com.ssh.hui.domain.model.Section;

/** 
 * @author hui 
 * @date 创建时间：2017年6月26日 下午9:47:17 吴清辉新建
 * @version 1.0 
 **/
public interface SectionDao extends BaseDao<Section>{

	List<Section> queryListByProfessor(Professor instructor);

}
