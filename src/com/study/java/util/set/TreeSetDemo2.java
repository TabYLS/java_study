package com.study.java.util.set;
/**
* @author 叶林生 
* @date：2017年6月25日 下午9:03:33
* @version 1.0
* 
*/
public class TreeSetDemo2 implements Comparable<Object> {
	
	private String name;
	private int num;
	
	public TreeSetDemo2(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	@Override
	public int compareTo(Object o) {//此对象与指定对象进行比较
		if(!(o instanceof TreeSetDemo2))
			throw new RuntimeException("不是TreeSetMemo2对象。。。。。。。。");
		TreeSetDemo2 t = (TreeSetDemo2) o;
		if (this.num > t.num) 
			return 1;
		if (this.num == t.num) {//主要条件相同比较次要条件
			return this.name.compareTo(t.name);//String类已经实现了Comparable接口，具备比较性
		}
		return -1;
	}

	@Override
	public String toString() {
		return "TreeSetDemo2 [name=" + name + ", num=" + num + "]";
	}
	
}
