package com.ssh.hui.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guitar")
public class Guitar {
    private String serialNumber;//序列号
    private double price;//价格
    private String builder;//厂家
    private String model;
    private String type;
    private String backWood;//后盖
    private String topWood;//...
    
    @Id
    @Column(name="guitar_serial_number")
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    @Column(name="guitar_price")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Column(name="guitar_builder")
    public String getBuilder() {
        return builder;
    }
    public void setBuilder(String builder) {
        this.builder = builder;
    }
    @Column(name="guitar_model")
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Column(name="guitar_type")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Column(name="guitar_back_wood")
    public String getBackWood() {
        return backWood;
    }
    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }
    @Column(name="guitar_top_wood")
    public String getTopWood() {
        return topWood;
    }
    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

}
