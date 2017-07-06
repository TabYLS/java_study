package com.study.java.test;

/**
 * Created by YLS on 2017/5/31.
 */
public class Group {

    private String name;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name:  "+this.name.hashCode());
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
        System.out.println("num:  "+this.num.hashCode());
    }
}
