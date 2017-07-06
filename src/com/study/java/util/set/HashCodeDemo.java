package com.study.java.util.set;
/**
* @author 叶林生 
* @date：2017年6月25日 下午4:24:30
* @version 1.0
* 
*/
public class HashCodeDemo {
	
	private String name;
	private int num;
	
	public HashCodeDemo(){}

	public HashCodeDemo(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}

	/**
	 * @Override
		public int hashCode() {
			return 99;//为了高效，尽量不要使哈希值相同，不然又需要调用equals方法判断，效率低
		}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HashCodeDemo))
			return false;
		HashCodeDemo h = (HashCodeDemo) obj;
		System.out.println(this.name + "..................equals" + h.name);
		return this.name.equals(h.name) && this.num == h.num;
	}

	@Override
	public String toString() {
		return "HashCodeDemo [name=" + name + ", num=" + num + "]";
	}

}
