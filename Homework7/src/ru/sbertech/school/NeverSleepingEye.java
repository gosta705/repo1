package ru.sbertech.school;

import java.lang.reflect.Method;
import java.util.TreeMap;

public class NeverSleepingEye implements java.lang.reflect.InvocationHandler {
    private Object obj;
    private TreeMap<String, Object> cahce = new TreeMap<String, Object>();

    public NeverSleepingEye(Object o) {
        obj = o;
    }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args)
            throws  Throwable {

        Method[] methods = proxy.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; ++i) {

            if (methods[i].getName().equals(method.getName())) {
                String methodShortName = methods[i].getName();

                if (cahce.containsKey(methodShortName)) {
                    System.out.println("Значение метода " + methodShortName + " из кеша");
                    return cahce.get(methodShortName);

                } else if (method.isAnnotationPresent(Cache.class)) {
                    cahce.put(methodShortName, method.invoke(obj, args));
                    System.out.println("Значение метода " + methodShortName + " занесено в кэш");
                    return cahce.get(methodShortName);

                } else {
                    obj = obj.getClass().newInstance();
                    return method.invoke(obj);

                }
            }
        }
        return method.invoke(obj);
    }
}


