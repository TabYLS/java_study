package com.study.polymorphism.classWork;

import com.study.polymorphism.classWork.impl.Rectangle;
import com.study.polymorphism.classWork.impl.Round;

/**
 * Created by YLS on 2017/6/2.
 */
public class Main {

    public static void main(String[] args) {
        Palliar[] palliars =  {new Palliar(),new Palliar()};

        Geometry round = new Round(2);
        Geometry rectangle = new Rectangle(5,4);

        palliars[0].set(round.getArea(),6);
        palliars[1].set(rectangle.getArea(),5);

        for (Palliar palliar : palliars){
            System.out.println(palliar.getVolume());
        }


    }
}
