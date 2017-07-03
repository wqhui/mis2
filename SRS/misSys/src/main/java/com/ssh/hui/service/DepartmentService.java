package com.ssh.hui.service;

import com.ssh.hui.domain.model.Department;

import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月1日 下午10:27:28 吴清辉新建
 * @version 1.0 
 **/
public interface DepartmentService extends BaseService<Department> {

	JSONObject queryList();

}
