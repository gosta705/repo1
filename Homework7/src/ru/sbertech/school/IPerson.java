package ru.sbertech.school;

public interface IPerson {
    @Cache
    public String getName();

    @Cache
    public String getAge();

    public String getPhoneNumber();
}
