package com.study.polymorphism;

import com.study.polymorphism.animal.Pet;
import com.study.polymorphism.animal.impl.Cat;
import com.study.polymorphism.animal.impl.Dog;
import com.study.polymorphism.animal.impl.Penguin;
import com.study.polymorphism.people.impl.Master;
import org.junit.Test;

/**
 * Created by YLS on 2017/5/31.
 */
public class Main {

    @Test
    public void testFead(){
        Master master = new Master();
        Pet cat = new Cat();
        master.fead(cat);
        master.fead(cat);
        master.fead(cat);
    }

    @Test
    public void testPlay(){
        Master master = new Master();
        Pet pet = master.claim("002");
        master.play();
        master.play();
        master.play();
        master.play();
    }

}
