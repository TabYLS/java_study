package com.study.java.util.set;

/**
* @author 叶林生 
* @date：2017年6月26日 上午8:25:33
* @version 1.0
* 
* 需求：将原本按照年龄排序改成按照姓名排序
*/
public class TreeSetDemo3 implements Comparable<Object> {
	private String name;
	private int num;
	
	public TreeSetDemo3(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int compareTo(Object o) {//此对象与指定对象进行比较
		if(!(o instanceof TreeSetDemo3))
			throw new RuntimeException("不是TreeSetMemo2对象。。。。。。。。");
		TreeSetDemo3 t = (TreeSetDemo3) o;
		if (this.num > t.num) 
			return 1;
		if (this.num == t.num) {//主要条件相同比较次要条件
			return this.name.compareTo(t.name);//String类已经实现了Comparable接口，具备比较性
		}
		return -1;
	}

	@Override
	public String toString() {
		return "TreeSetDemo3 [name=" + name + ", num=" + num + "]";
	}

}
