package ru.sbertech.school;

import java.lang.reflect.Proxy;



public class Main {
    public static void main(String [] args) {
        PersonImpl personImpl = new PersonImpl();
        try {
            Person personproxy = (Person) Proxy.newProxyInstance(PersonImpl.class.getClassLoader(),
                    PersonImpl.class.getInterfaces(),
                    new NeverSleepingEye(personImpl, "ru.sbertech.school."));


            System.out.println(personproxy.getName());
            System.out.println(personproxy.getAge());
            System.out.println(personproxy.getAge());
            System.out.println(personproxy.getPhoneNumber(1));
            System.out.println(personproxy.getPhoneNumber(2));
            System.out.println(personproxy.getPhoneNumber(1));

        } catch (Throwable t) {
           t.printStackTrace();
        }


    }
}
