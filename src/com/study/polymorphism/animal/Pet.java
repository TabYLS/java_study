package com.study.polymorphism.animal;

/**
 * Created by YLS on 2017/5/31.
 */
public abstract class Pet {

    private String number = "";
    private String name = "";
    private Integer  healthy = 0;
    private Integer intimacy = 0;

    public abstract void eat();

    public abstract void play();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthy() {
        return healthy;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHealthy(Integer healthy) {
        this.healthy = healthy;
    }

    public Integer getIntimacy() {
        return intimacy;
    }

    public void setIntimacy(Integer intimacy) {
        this.intimacy = intimacy;
    }

    public void addHealthy(int addHealthy) {
        if (addHealthy > 0){
            if (this.healthy != null && this.healthy >= 58){
                System.out.println("我要撑死啦。。。。。不吃了");
            } else {
                this.healthy += addHealthy;
                System.out.println("我是"+ this.getName() +"，健康值加"+ addHealthy +"。目前我的健康值为： " + this.getHealthy());
            }
        } else if (this.healthy < 10){
            System.out.println("我是"+ this.getName() +"健康值少于10生病了，蓝瘦香菇。。。。。");
        } else
            this.healthy += addHealthy;
    }

    public void addIntimacy(int addIntimacy){
        System.out.println("我是"+ this.getName() +"主人陪我游泳。。。。。。。。。我和主人的亲密度加" + addIntimacy);
        this.intimacy += addIntimacy;
    }
}
