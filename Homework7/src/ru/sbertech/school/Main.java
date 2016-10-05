package ru.sbertech.school;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String [] args) {
        Person person = new Person();

        IPerson personproxy = (IPerson) Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(),
                new NeverSleepingEye(person));


        System.out.println(personproxy.getName());
        System.out.println(personproxy.getAge());
        System.out.println(personproxy.getAge());
        System.out.println(personproxy.getPhoneNumber());

    }
}
