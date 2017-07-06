package com.study.polymorphism.classWork.impl;

import com.study.polymorphism.classWork.Geometry;

/**
 * Created by YLS on 2017/6/2.
 */
public class Round implements Geometry {

    private final double PI = 3.14;
    private double r;

    public Round(double r){
        this.r = r;
    }

    @Override
    public double getArea() {
        return r * r * PI;
    }
}
