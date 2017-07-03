package com.ssh.hui.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.CourseCatalog;
import com.ssh.hui.service.CourseCatalogService;

import net.sf.json.JSONObject;

@Service("courseCatalogService")
public class CourseCatalogServiceImpl extends BaseServiceImpl<CourseCatalog> implements CourseCatalogService{

	@Override
	public JSONObject queryList() {
		CourseCatalog c=new CourseCatalog();
		List<CourseCatalog>cList=courseCatalogDao.queryAll();		
		return c.toJSONObjectList(cList);
	}

}
