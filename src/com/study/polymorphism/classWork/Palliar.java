package com.study.polymorphism.classWork;

/**
 * Created by YLS on 2017/6/2.
 */
public class Palliar {

    private double area;
    private double hight;

    public Palliar(){

    }

    public double getVolume(){
        return this.area * this.hight;
    }

    public void set(double area, double hight){
        this.area = area;
        this.hight = hight;
    }
}
