package ru.sberbank.school;

public interface Person {
    @Cache
    String getName();

    @Cache
    String getAge();

    @Cache
    String getPhoneNumber(int num);
}
