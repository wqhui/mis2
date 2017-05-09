package com.ssh.hui.serviceImpl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


import com.ssh.hui.po.Guitar;
import com.ssh.hui.service.GuitarService;

import net.sf.json.JSONArray;

@Lazy(true)
@Service("guitarService")
public class GuitarServiceImpl extends BaseServiceImpl<Guitar> implements GuitarService{


	@Override
	public List<Guitar> queryGuitarListByGuitar(String backWood, String builder, String guitarModel, double price,
			String topWood, String type) {
		// TODO Auto-generated method stub
		return guitarDao.queryGuitarListByGuitar(backWood, builder, guitarModel, price,
				topWood,type);
	}




}
