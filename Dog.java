package ru.geekbrains.lesson6;

class Dog extends Animal {
    public Dog() {
        this.setJump = 0.5f;
        this.setSwim = 10;
        this.setRun = 500;
    }
}

class BadgerDog extends Dog {
    public BadgerDog() {
        this.setSwim = 5;
        this.setRun = 400;
    }
}
