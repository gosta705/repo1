package ru.sberbank.school;


public class Person {
    private final boolean man;
    private final String name;
    private Person spouce;

    public Person(boolean man, String name){
        this.man = man;
        this.name = name;
        spouce = null;
    }

    public boolean marry(Person person){
        if(this.spouce == person || this.man == person.get_gender()) return false;
        else if(this.man != person.get_gender() && !this.is_marry() && !person.is_marry()) {
            this.spouce = person;
            person.set_spouce(this);
        }
        else {
            this.divorse();
            person.divorse();
            this.marry(person);
        }
        return true;
    }

    public boolean divorse(){
        if(this.is_marry()){
            Person former_spouce = this.get_spouce();
            this.spouce = null;
            former_spouce.divorse();
            return true;
        }
        return false;
    }

    public boolean get_gender(){
        return this.man;
    }

    public boolean is_marry(){
        if(spouce == null) return false;
        else return true;
    }
    public Person get_spouce(){
        return this.spouce;
    }

    public void set_spouce(Person person){
        this.spouce = person;
    }

    public static final void main(String []args){
        Person alisa = new Person(false, "Alisa");
        Person mike = new Person(true, "Mike");
        Person janny = new Person(false, "Janny");
        Person bob = new Person(true, "Bob");

        System.out.println(alisa.marry(janny));
        System.out.println(mike.marry(alisa));
        System.out.println(bob.marry(janny));

        System.out.println(mike.marry(janny));
        System.out.println(alisa.is_marry());
        System.out.println(bob.is_marry());

    }
}
