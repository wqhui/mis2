package com.ssh.hui.service;

import com.ssh.hui.domain.model.CourseCatalog;

import net.sf.json.JSONObject;

public interface CourseCatalogService extends BaseService<CourseCatalog>{

	JSONObject queryList();

}
