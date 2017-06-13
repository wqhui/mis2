package com.ssh.hui.dao;

import java.util.List;

import com.ssh.hui.po.Guitar;

import net.sf.json.JSONArray;

public interface GuitarDao extends BaseDao<Guitar>{

	List<Guitar> queryGuitarListByGuitar(Guitar gtar);


}
