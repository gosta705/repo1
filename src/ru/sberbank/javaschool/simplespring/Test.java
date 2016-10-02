package ru.sberbank.javaschool.simplespring;

public class Test {


    public static void main(String[] args) {
        Factorable f = Factory.createNew(ru.sberbank.javaschool.simplespring.Test.class);
        f.registryShutdownHook();

        //Object o = f.getBean(Object.class);

        A a = f.getBean(A.class);
        a.execute();

        D d = f.getBean(D.class);
        System.out.println(d.getSomeStr());

        f.close();
    }


}

