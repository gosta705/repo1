package ru.sbertech.school;

public interface Person {
    @Cache
    String getName();

    @Cache
    String getAge();

    @Cache
    String getPhoneNumber(int num);
}
