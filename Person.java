package ru.geekbrains.lesson5;

public class Person {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    private Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    private void print() {
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
        System.out.println("E-mail: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary + "$");
        System.out.println("Возраст: " + age);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Person[] personalArray = new Person[5];
        personalArray[0] = new Person("Артёмов Казимир", "Верстальщик",
                "k.artemov@mail.ru","972-9240", 1000,25);
        personalArray[1] = new Person("Кутюкова Нона", "Архитектор",
                "n.kutykova@mail.ru","038-6169", 1200,42);
        personalArray[2] = new Person("Протасов Юрий", "Администратор",
                "y.protasov@mail.ru","075-0000", 900,35);
        personalArray[3] = new Person("Апраксина Виктория", "Менеджер",
                "v.apraksina@mail.ru","331-6288", 800,22);
        personalArray[4] = new Person("Тянников Пахом", "Дизайнер",
                "p.tyannikov@mail.ru","610-2212", 1100,44);

        System.out.println("Список сотрудников старше 40 лет");
        System.out.println("----------------------------");
        for (Person personal : personalArray) {
            if (personal.age > 40) personal.print();
        }
    }
}
