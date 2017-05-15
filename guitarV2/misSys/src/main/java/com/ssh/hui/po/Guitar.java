package com.ssh.hui.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ssh.hui.po.spec.GuitarSpec;

@Entity
@Table(name="guitar")
public class Guitar {
    
    private Integer id;
    private String serialNumber;//序列号
    private double price;//价格
    private GuitarSpec spec;//封装变化
    public Guitar() {
        //...空构造
    }
    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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

    @OneToOne
    public GuitarSpec getSpec() {
        return spec;
    }
    public void setSpec(GuitarSpec spec) {
        this.spec = spec;
    }

}
