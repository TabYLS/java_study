package com.study.polymorphism.classWork.impl;

import com.study.polymorphism.classWork.Geometry;

/**
 * Created by YLS on 2017/6/2.
 */
public class Rectangle implements Geometry{

    private double l;
    private double w;

    public Rectangle(double l, double w){
        this.l = l;
        this.w = w;
    }

    @Override
    public double getArea() {
        return this.l * this.w;
    }
}
