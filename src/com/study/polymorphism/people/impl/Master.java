package com.study.polymorphism.people.impl;

import com.study.polymorphism.animal.Pet;
import com.study.polymorphism.animal.impl.Cat;
import com.study.polymorphism.animal.impl.Dog;
import com.study.polymorphism.animal.impl.Penguin;

/**
 * Created by YLS on 2017/5/31.
 */
public class Master {

    private Pet pet;

    public void fead(Pet pet){
        pet.eat();
    }

    /**
     * 认领宠物
     */
    public Pet claim(String number){
        switch (number){
            case "001" : this.pet = new Cat(); break;
            case "002" : this.pet = new Penguin(); break;
            case "003" : this. pet = new Dog(); break;
        }
        return this.pet;
    }

    /**
     * 陪宠物玩耍
     */
    public void play(){
        this.pet.play();
    }

   /* public Pet getPet(String number){
        Pet pet = null;
        switch (number){
            case "001" : pet = new Cat();
            case "002" : pet = new Penguin();
            case "003" : pet = new Dog();
        }
        return pet;
    }*/

}
