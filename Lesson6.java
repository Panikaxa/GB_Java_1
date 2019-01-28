package ru.geekbrains.lesson6;

public class Lesson6 {
    public static void main(String[] args) {
        System.out.println("Обычная кошка");
        Cat cat1 = new Cat();
        cat1.run(250);
        cat1.jump(2.5f);
        cat1.swim(2);

        System.out.println("Дикая кошка");
        Cat cat2 = new WildCat();
        cat2.run(250);
        cat2.jump(2.5f);
        cat2.swim(2);

        System.out.println("Обычная собака");
        Dog dog1 = new Dog();
        dog1.run(450);
        dog1.swim(9);
        dog1.jump(0.5f);

        System.out.println("Такса");
        Dog dog2 = new BadgerDog();
        dog2.run(450);
        dog2.swim(9);
        dog2.jump(0.5f);


    }
}
