package com.study.sort.bub;

/**
 * Created by YLS on 2017/5/25.
 */
public class ArrayBub {

    private long[] a;//数组
    private int nElelns;//数组的下标

    public ArrayBub(){}

    public ArrayBub(int max){
        a = new long[max];
        nElelns = 0;
    }

    public void insert(long value){
        a[nElelns] = value;
        nElelns ++;//当添加一个数组之后下标加一
    }

    public void display(){
        for (int i = 0; i < nElelns; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public void bubbleSort(){
        for (int i = nElelns - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1])
                    swap(j,j + 1);
            }
        }
    }

    public void swap(int pre, int next){
        long temp = a[pre];
        a[pre] = a[next];
        a[next] = temp;
    }
}
