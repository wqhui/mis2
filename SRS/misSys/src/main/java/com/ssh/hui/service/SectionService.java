package com.ssh.hui.service;

import com.ssh.hui.domain.model.Section;

import net.sf.json.JSONObject;

public interface SectionService extends BaseService<Section>{

	JSONObject queryList();

}
