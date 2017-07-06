package com.study.sort.quick;
/**
 *
 * @author 叶林生
 *
 * @date 2017年6月14日 下午1:24:02
 *
 * @version 1.0
 * 
 */
public class QuickSort {
	
	//private int[] r = {0,23,25,18,10,7,68,12,90,1};
	private int[] r = {};
	
	public QuickSort(int[] r) {
		this.r = r;
	}
	
	public void quick(int low, int high) {
		int i = 0;
		if(high > low) {//只有一个或者没有的时候不需要排序
			i = part(low, high);
			quick(low, i -1);
			quick(i + 1, high);//支点不需要判断，不然会造成死循环
		}
		
	}
	
	public int part(int low, int high){
		//int i = 1;
		//int j = r.length - 1;
		int i = low;
		int j = high;
		
		r[0] = r[i];
		while(i < j) {//每一轮都要比较每一个元素
			while(i < j && r[j] > r[0])//扫描序列的右端，保证右端的都是大的
				j --;
			if (i < j) {
				r[i] = r[j];//只要右端的比支点小，就把它抛到左端
				i += 1;
			}
			while(i < j && r[i] < r[0])//扫描序列的左端，保证左端的都是大的
				i ++;
			if (i <j ) {
				r[j] = r[i];//只要是左端的比支点大，就把它抛到右端
				j -= 1;
			}
		}
		r[i] = r[0];
		return i;//之所以要返回i，是因为每次经过一轮快排之后都要分成左右两段，所以要记录每次的支点，而每次都是r[i] = r[0]最后执行，所以支点就是i
	}

}
