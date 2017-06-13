package com.ssh.hui.po;
/**
 * 构造一个guitar厂商的枚举类
 * @author hui
 * @version 1.0
 * */
public enum Builder {
    JIANGSU("jiangsu"),
    BEIJING("beijing"),
    GUANGZHOU("guangzhou"),
    OTHER("other");
    private String  value;
    private Builder(String value) {
        this.value = value;
    }

    public String toString(){
        return value;
    }
}
