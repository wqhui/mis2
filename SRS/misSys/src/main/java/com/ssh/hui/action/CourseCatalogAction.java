package com.ssh.hui.action;

import com.ssh.hui.domain.model.CourseCatalog;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * @author hui 
 * @date 创建时间：2017年6月30日 下午10:31:34 吴清辉新建
 * @version 1.0 
 **/
public class CourseCatalogAction extends BaseAction<CourseCatalog>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	
	
	/**
	 * 
	 * @return 列表
	 */
	public String queryList(){
		jsonObject=courseCatalogService.queryList();
		return "jsonObject";
	}



	public JSONObject getJsonObject() {
		return jsonObject;
	}



	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}



	public JSONArray getJsonArray() {
		return jsonArray;
	}



	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	
	
	
}
