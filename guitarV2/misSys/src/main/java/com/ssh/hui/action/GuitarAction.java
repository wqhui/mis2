package com.ssh.hui.action;

import java.util.List;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.hui.po.Guitar;

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
    
    /**
     * 根据条件查询GuitarList
     * @param Guitar param
     * @return GuitarList
     */
    public String queryGuitarList() {
        Guitar gtar=new Guitar();
        gtar.setBackWood(backWood);
        gtar.setBuilder(builder);
        gtar.setModel(guitarModel);
        gtar.setPrice(price);
        gtar.setTopWood(topWood);
        gtar.setType(type);
        List<Guitar> guitarList=guitarService.queryGuitarListByGuitar(gtar);
        ActionContext.getContext().put("guitarList", guitarList);
        return "resultJsp";        
    }
    
    /**
     * 保存guitar
     * @param Guitar param
     * @return 
     */
    public String save() {
        Guitar gtar=new Guitar();
        String serialNumberUUID = UUID.randomUUID().toString();
        gtar.setSerialNumber(serialNumberUUID);        
        gtar.setBackWood(backWood);
        gtar.setBuilder(builder);
        gtar.setModel(guitarModel);
        gtar.setPrice(price);
        gtar.setTopWood(topWood);
        gtar.setType(type);
        try {
            guitarService.save(gtar);
        } catch (Exception e) {
            System.out.println("chucuo");
            e.printStackTrace();
        }
        
        return "jsonArray";
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
    

}
