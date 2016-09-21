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
        if(this.spouce == person && this.spouce != null || this.man == person.isMan()) return false;
        else {
            divorse();
            person.divorse();
            this.spouce = person;
            person.setSpouce(this);
            return true;
        }
    }

    public boolean divorse(){
        if(this.isMarry()){
            Person former_spouce = this.getSpouce();
            this.spouce = null;
            former_spouce.setSpouce(null);
            return true;
        }
        return false;
    }

    public boolean isMan(){
        return this.man;
    }

    public boolean isMarry(){
        if(spouce == null) return false;
        else return true;
    }

    public Person getSpouce(){
        return this.spouce;
    }

    private void setSpouce(Person person){
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
        System.out.println(alisa.isMarry());
        System.out.println(bob.isMarry());

    }
}

