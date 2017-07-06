package com.study.one.array;

import java.util.Arrays;

/**
 * Created by YLS on 2017/5/24.
 */
public class _1sort {

    public static void main(String[] args) {
        int[] arr = {3,68,54,5,9,64,32,68};
        Arrays.sort(arr);
        System.out.println("升序");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("\n降序");
        for (int i = arr.length - 1; i >= 0 ; i--) {
            System.out.print(arr[i]);
        }
    }
}
