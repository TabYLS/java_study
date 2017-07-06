package com.study.java.test;

/**
 * Created by YLS on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {
        Group group = new Group();
        group.setNum(1);
        group.setName("第一组");

        Person person = new Person();

        person.setAge(22);
        person.setName("张三");
        person.setGroup(group);

        group.setName("第二组");
        group.setNum(2);
        System.out.println(person.getName()+"  :"+person.getGroup().getName());
        System.out.println("===========================================");


        Person p1 = new Person();
        p1.setName("小白。。。。");
        System.out.println("p1:"+p1.getName());
        Person p2 = p1;
        p2.setName("小黑。。。。");
        System.out.println("p1: " + p1.getName() + "p2: " +p2.getName());
        TestSuperPerson person2 = new TestSuperPerson(){
        	public void test(){
        		System.out.println("sdflsjd");
        	}
        };
        
    }
}
