package ru.sberbank.javaschool;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        Class <?> c = findLoadedClass(name);
        try {
            if(c == null){
                c = findClass(name);
            }
        } catch (ClassNotFoundException e){
            c = getParent().loadClass("ru.sberbank.javaschool.TestPlugin");
        }
        return c;
    }


}