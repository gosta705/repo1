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
        //TODO: null pointer
        if(this.spouce == person || this.man == person.get_gender()) return false;

        //--->>>>
        else if(this.man != person.get_gender() && !this.is_marry() && !person.is_marry()) {
            this.spouce = person;
            person.set_spouce(this);
        }
        else {
            this.divorse();
            person.divorse();
            this.marry(person); //TODO: too difficult
        }
        //<<<<<<<<------ TODO: just
        // divorse();
        // person.divorse();
        // spouce = person;
        // person.spouce = this;
        return true;
    }

    public boolean divorse(){
        if(this.is_marry()){
            Person former_spouce = this.get_spouce();
            this.spouce = null;
            former_spouce.divorse(); //TODO: null pointer
            return true;
        }
        return false;
    }

    //TODO: please use camel style: getGender() or isMan()
    public boolean get_gender(){
        return this.man;
    }

    //TODO: please use camel style
    public boolean is_marry(){
        if(spouce == null) return false;
        else return true;
    }
    //TODO: please use camel style
    public Person get_spouce(){
        return this.spouce;
    }

    //TODO: please use camel style
    //TODO: dangerous method - have to be private
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
