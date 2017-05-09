package com.ssh.hui.service;

import java.util.List;

import com.ssh.hui.po.Guitar;

import net.sf.json.JSONArray;

public interface GuitarService extends BaseService<Guitar>{


	List<Guitar> queryGuitarListByGuitar(String backWood, String builder, String guitarModel, double price,
			String topWood, String type);



   

}
