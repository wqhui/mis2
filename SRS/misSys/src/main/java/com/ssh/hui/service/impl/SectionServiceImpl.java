package com.ssh.hui.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssh.hui.domain.model.Section;
import com.ssh.hui.service.SectionService;

import net.sf.json.JSONObject;
@Service("sectionService")
public class SectionServiceImpl extends BaseServiceImpl<Section> implements SectionService{

	@Override
	public JSONObject queryList() {
		Section s=new Section();
		List<Section>sList=sectionDao.queryAll();
		return s.toJSONObjectList(sList);
	}

}
