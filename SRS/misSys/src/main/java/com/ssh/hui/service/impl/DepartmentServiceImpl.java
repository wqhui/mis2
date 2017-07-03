package com.ssh.hui.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Department;
import com.ssh.hui.service.DepartmentService;

import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年7月1日 下午10:28:16 吴清辉新建
 * @version 1.0 
 **/
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{

	@Override
	public JSONObject queryList() {
		Department d =new Department();
		List <Department> dList=departmentDao.queryAll();
		return d.toJSONObjectList(dList);
	}

}
