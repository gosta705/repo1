package ru.sberbank.javaschool;


import java.beans.Expression;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String [] args) {
        
        Plugin testPlugin;
        PluginManager pluginManager = new PluginManager("file:/C:/Users/tanya/");

        try {
            testPlugin = pluginManager.load("TestPlugin", "TestPlugin");
            testPlugin.doUsefull();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //-----------------------------------------------------------------------------------------------------------
        String key = "123456";
        try {
            File file = new File("C://Users/tanya/IdeaProjects/Hometask9/src/ru/sberbank/javaschool", "EncryptedClass.java");
            EncryptedClassLoader encClassLoader = new EncryptedClassLoader(key, file, EncryptedClass.class.getClassLoader());
            Class<?> clazz = encClassLoader.findClass("EncryptedClass");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
