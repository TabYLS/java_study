package com.study.one.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YLS on 2017/5/24.
 */
public class _2insert {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please define the array's length");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("please input the arrays");
        for (int i = 0; i < len; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }
        Arrays.sort(arr);//排序
        System.out.println("After the sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }

        System.out.println("please insert one num");
        arr = Arrays.copyOf(arr,arr.length + 1);

    }
}
