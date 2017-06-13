package com.ssh.hui.po.spec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ssh.hui.po.Builder;
import com.ssh.hui.po.Type;
import com.ssh.hui.po.Wood;
@Entity
@Table(name="guitar_spec")
public class GuitarSpec {
    private Builder builder; 
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    private Integer id;
    
    public GuitarSpec() {
        super();
    }
    public GuitarSpec(Builder builder, String model, Type type,
           Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }



    public boolean matches(GuitarSpec otherSpec) {
          if (builder != otherSpec.builder)
            return false;
          if ((model != null) && (!model.equals("")) &&
              (!model.toLowerCase().equals(otherSpec.model.toLowerCase())))
            return false;
          if (type != otherSpec.type)
            return false;
          if (backWood != otherSpec.backWood)
            return false;
          if (topWood != otherSpec.topWood)
            return false;
          return true;
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
    @Column(name="guitar_builder")
    public Builder getBuilder() {
        return builder;
    }
    public void setBuilder(Builder builder) {
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
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    @Column(name="guitar_back_wood")
    public Wood getBackWood() {
        return backWood;
    }
    public void setBackWood(Wood backWood) {
        this.backWood = backWood;
    }
    @Column(name="guitar_top_wood")
    public Wood getTopWood() {
        return topWood;
    }
    public void setTopWood(Wood topWood) {
        this.topWood = topWood;
    }



}
