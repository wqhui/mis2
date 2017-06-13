package com.ssh.hui.action;

import java.util.List;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.hui.po.Builder;
import com.ssh.hui.po.Guitar;
import com.ssh.hui.po.Type;
import com.ssh.hui.po.Wood;
import com.ssh.hui.po.spec.GuitarSpec;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GuitarAction extends BaseAction<Guitar>{

    private static final long serialVersionUID = 1L;
    private JSONObject jsonObject=new JSONObject();
    private JSONArray jsonArray=new JSONArray();
    private String serialNumber;//序列号
    private double price;//价格
    private String builder;//厂家
    private String guitarModel;
    private String type;
    private String backWood;//后盖
    private String topWood;//...
    private int id;
    
    /**
     * 根据条件查询GuitarList
     * @param Guitar param
     * @return GuitarList
     */
    public String queryGuitarList() {
        GuitarSpec gtarSpec=new GuitarSpec(); 
        gtarSpec.setBackWood(Wood.valueOf(backWood));
        gtarSpec.setTopWood(Wood.valueOf(topWood));
        gtarSpec.setBuilder(Builder.valueOf(builder));
        gtarSpec.setModel(guitarModel);
        gtarSpec.setType(Type.valueOf(type));
        Guitar gtar=new Guitar(null,price,gtarSpec);
        List<Guitar> guitarList=guitarService.queryGuitarListByGuitar(gtar);
        ActionContext.getContext().put("guitarList", guitarList);
        return "resultJsp";        
    }
    
    /**
     * 查询所有GuitarList
     * @param Guitar param
     * @return GuitarList
     */
    public String queryAllGuitarList() {
    	List<Guitar> guitarList=guitarService.queryAll();
    	JSONArray jary=new JSONArray();
    	for(Guitar g:guitarList){
    		JSONObject jo= new JSONObject();
    		jo.put("id", g.getId());
    		jo.put("price", g.getPrice());
    		jo.put("serialNumber", g.getSerialNumber());
    		jo.put("backWood", g.getSpec().getBackWood());
    		jo.put("builder", g.getSpec().getBuilder());
    		jo.put("model", g.getSpec().getModel());
    		jo.put("topWood", g.getSpec().getTopWood());    		
    		jo.put("type", g.getSpec().getType());
    		jary.add(jo);
    	}
    	jsonArray=jary;
        return "jsonArray";        
    }
    
    /**
     * 保存guitar
     * @param Guitar param
     * @return 
     */
    public String save() {
        GuitarSpec gtarSpec=new GuitarSpec(); 
        gtarSpec.setBackWood(Wood.valueOf(backWood));
        gtarSpec.setTopWood(Wood.valueOf(topWood));
        gtarSpec.setBuilder(Builder.valueOf(builder));
        gtarSpec.setModel(guitarModel);
        gtarSpec.setType(Type.valueOf(type));
        String UID=UUID.randomUUID().toString();
        Guitar g=new Guitar(UID, price,gtarSpec);  
        guitarService.save(g);
           
        return "jsonArray";
    }
    
    /**
     * 查询所有GuitarList
     * @param Guitar param
     * @return GuitarList
     */
    public String deleteGuitar() {
    	Guitar g=new Guitar();
    	JSONObject jo=new JSONObject();
    	if(id!=0){
        	g.setId(id);
        	guitarService.delete(g);
        	jo.put("status", "ok");
    	}else{
    		jo.put("status", "error");
    	}
    	jsonObject=jo;
        return "jsonObject";        
    }
    
    public JSONObject getJsonObject() {
        return jsonObject;
    }
    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getBuilder() {
        return builder;
    }
    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }
    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }
    public String getGuitarModel() {
        return guitarModel;
    }
    public void setGuitarModel(String guitarModel) {
        this.guitarModel = guitarModel;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBackWood() {
        return backWood;
    }
    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }
    public String getTopWood() {
        return topWood;
    }
    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    

}
