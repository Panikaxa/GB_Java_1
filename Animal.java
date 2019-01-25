package ru.geekbrains.lesson6;

public class Animal {
    protected float setRun;
    protected float setJump;
    protected float setSwim;

    public void run(float set){
        System.out.println("run: " + (set <= setRun));
    }

    public void swim(float set) {
        System.out.println("swim: " + (set <= setSwim));
    }

    public void jump(float set) {
        System.out.println("jump: " + (set <= setJump));
    }

}
