package com.study.polymorphism.animal.impl;

import com.study.polymorphism.animal.Pet;

/**
 * Created by YLS on 2017/5/31.
 */
public class Cat extends Pet {

    public Cat(){
        this.setNumber("001");
        this.setHealthy(50);
        this.setName("猫");
        this.setIntimacy(40);
    }

    @Override
    public void eat() {
        this.addHealthy(4);
    }

    @Override
    public void play() {

    }
}
