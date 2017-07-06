package com.study.sort.test;

import com.study.sort.bub.ArrayBub;

/**
 * Created by YLS on 2017/5/25.
 */
public class TestBub {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);

        arr.insert(32);
        arr.insert(54);
        arr.insert(65);
        arr.insert(21);
        arr.insert(22);
        arr.insert(23);
        arr.insert(34);
        arr.insert(68);
        arr.insert(43);
        arr.insert(38);

        arr.display();

        arr.bubbleSort();
        arr.display();
    }
}
