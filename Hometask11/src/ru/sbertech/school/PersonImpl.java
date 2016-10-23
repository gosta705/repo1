package ru.sbertech.school;

public class PersonImpl implements Person {
    private String name = "Vasiliy" ;
    private int age = 20 ;
    private String homeNumber = "11-11-11" ;
    private String mobileNumber = "22-22-22" ;
    private String officeNumber = "33-33-33" ;

    @Cache
    public String getName(){
        return name;
    }

    @Cache
    public String getAge(){
        return age + "";
    }

    @Cache
    public String getPhoneNumber(int num){

        switch (num){
            case 1 : return homeNumber;
            case 2 : return mobileNumber;
            case 3 : return officeNumber;
            default: return "Number does not exist";
        }
    }
}