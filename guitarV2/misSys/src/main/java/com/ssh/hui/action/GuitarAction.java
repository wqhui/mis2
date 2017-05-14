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
     * 保存guitar
     * @param Guitar param
     * @return 
     */
    public String save() {
        System.out.println("保存");
        guitarService.save(new Guitar("11277", 3999.95,
                new GuitarSpec(Builder.JIANGSU, "CJ", Type.ACOUSTIC,Wood.CAMPHOR, Wood.CAMPHOR)) 
        );
        guitarService.save(new Guitar("V95693", 1499.95, 
          new GuitarSpec(Builder.BEIJING, "Stratocastor", Type.ELECTRIC, Wood.CAMPHOR, Wood.CAMPHOR)));
         guitarService.save(new Guitar("V9512", 1549.95, 
          new GuitarSpec(Builder.GUANGZHOU, "Stratocastor", Type.ELECTRIC,Wood.KOREANPINE, Wood.KOREANPINE)));
         guitarService.save(new Guitar("122784", 5495.95, 
          new GuitarSpec(Builder.BEIJING, "D-18", Type.ACOUSTIC,Wood.BRICH, Wood.KOREANPINE)));
         guitarService.save(new Guitar("76531", 6295.95, 
          new GuitarSpec(Builder.JIANGSU, "OM-28", Type.ACOUSTIC,Wood.KOREANPINE, Wood.BRICH)));
         guitarService.save(new Guitar("70108276", 2295.95, 
          new GuitarSpec(Builder.BEIJING, "Les Paul", Type.ELECTRIC,Wood.KOREANPINE, Wood.KOREANPINE)));
         guitarService.save(new Guitar("82765501", 1890.95, 
          new GuitarSpec(Builder.GUANGZHOU, "SG '61 Reissue", Type.ELECTRIC,  Wood.BRICH, Wood.KOREANPINE)));
         guitarService.save(new Guitar("77023", 6275.95, 
          new GuitarSpec(Builder.JIANGSU, "D-28", Type.ACOUSTIC,Wood.CAMPHOR, Wood.BRICH)));
         guitarService.save(new Guitar("1092", 12995.95, 
          new GuitarSpec(Builder.BEIJING, "SJ", Type.ACOUSTIC,Wood.CAMPHOR, Wood.BRICH)));
         guitarService.save(new Guitar("566-62", 8999.95, 
          new GuitarSpec(Builder.OTHER, "Cathedral", Type.ACOUSTIC, Wood.BRICH, Wood.CAMPHOR)));
         guitarService.save(new Guitar("6 29584", 2100.95, 
          new GuitarSpec(Builder.BEIJING, "Dave Navarro Signature", Type.ELECTRIC,  Wood.KOREANPINE, Wood.CAMPHOR)));       
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
