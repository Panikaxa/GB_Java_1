package ru.geekbrains.lesson6;

class Cat extends Animal {
    public Cat() {
        this.setJump = 2;
        this.setSwim = 0;
        this.setRun = 200;
    }
}

class WildCat extends Cat {
    public WildCat() {
        this.setJump = 3;
        this.setSwim = 20;
        this.setRun = 400;
    }
}