package ru.sbertech.school;

public class Person implements IPerson {
    private String name = "Vasiliy" ;
    private int age = 20 ;
    private String phoneNumber = "55-55-55" ;

    @Cache
    public String getName(){
        return name;
    }

    @Cache
    public String getAge(){
        return age + "";
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}