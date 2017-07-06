package com.study.java.test;

/**
 * Created by YLS on 2017/5/31.
 */
public class Person {

    private String name;
    private Integer age;
    private Group group;

    public Person(int a){

    }

    public Person(){
        this(1);

    }

    public Person(String test){
        this();
    }

    public String basic = "我是父类的内容。。。。。";
    public void basic(){
        System.out.println("我是父类的基本方法。。。。。");
    }
    public void test(){
        System.out.println("父类被");
    }


    /*setter/gettter方法*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}