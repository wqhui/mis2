package com.ssh.hui.po;
/**
 * 构造一个guitar类型的枚举类
 * @author hui
 * @version 1.0
 * */
public enum Type {
    ACOUSTIC("acoustic"),//木
    ELECTRIC("electric"),//电
    UNSPECIFIED("unspecified");//未指定
    private String value;

    private Type(String value) {
        this.value = value;
    }

    public String toString(){
        return value;
    }
}
