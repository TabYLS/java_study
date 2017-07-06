package com.study.polymorphism.animal.impl;

import com.study.polymorphism.animal.Pet;

/**
 * Created by YLS on 2017/6/1.
 */
public class Penguin extends Pet {

    public Penguin(){
        this.setNumber("002");
        this.setName("企鹅");
        this.setHealthy(20);
        this.setIntimacy(20);
    }
    @Override
    public void eat() {

    }

    @Override
    public void play() {
        this.addHealthy(-10);
        this.addIntimacy(5);
    }
}
