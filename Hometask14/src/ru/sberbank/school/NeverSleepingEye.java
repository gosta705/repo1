package ru.sberbank.school;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;
import ru.sberbank.school.Utils.SerializationUtils;
import ru.sberbank.school.Utils.Utils;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class NeverSleepingEye<T> implements java.lang.reflect.InvocationHandler {
    private final Object classObj;
    private final Map<Object, Object> cacheMap = new ConcurrentHashMap<>();
    private final String filePath;
    private static boolean restoreFileFromCache = false;

    public NeverSleepingEye(Object classObj, String filePath) throws  Throwable{
        this.classObj = classObj;
        this.filePath = filePath;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws  Throwable {

        Cache cache = method.getAnnotation(Cache.class);
        if (!method.isAnnotationPresent(Cache.class)) {
            return invoke(classObj, method, args);
        }
        else if (cache.cacheType().equals(CacheType.FILE)) {
            return getResultFromFile(method, args);
        }
        else if (cache.cacheType().equals(CacheType.MEMORY)) {
            return getResultFromMemory(method, args);
        }
        else if (cache.cacheType().equals(CacheType.MEMORY_AND_FILE)) {
            if (!restoreFileFromCache ){
                restoreFileFromCache(method, args);
                restoreFileFromCache = true;
            }
            return getResultFromMemoryAndCache(method, args);
        }
        return null;


    }


    private Object getResultFromMemory(Method method, Object[] args) throws Throwable {
        Cache cache = method.getAnnotation(Cache.class);
        Object result;
        Object key = Utils.key(method, Utils.getArgumentsByIdentityInMethod(args, Arrays.asList(cache.identityBy())));
        if (!cacheMap.containsKey(key)) {
            result = invoke(method, args);
            cacheMap.put(key, result);
            System.out.println("Значение метода " + method.getName() + " занесено в кэш");
        } else {
            result = cacheMap.get(key);
            System.out.println("Значение метода " + method.getName() + " из кэша");
        }

        return result;
    }

    private Object getResultFromFile(Method method, Object[] args) throws Throwable {
        Cache cache = method.getAnnotation(Cache.class);
        Object result = Utils.cutList(method, invoke(method, args));
        String fileName = (cache.fileNamePrefix() + method.getName() + Utils.key(method, args));

        SerializationUtils.serialize((Serializable) result, fileName);
        if (cache.zip()) {
            zipFile(fileName);
            System.out.println("Значение метода " + method.getName() + " сохранено с расширением .zip");
        } else {
            saveFile(fileName, result);
            System.out.println("Значение метода " + method.getName() + " сохранено в файл");
        }
        return result;
    }

    public void restoreFileFromCache(Method method, Object [] args) throws Throwable {
        Cache cache = method.getAnnotation(Cache.class);
        Method[] methods = method.getClass().getDeclaredMethods();
        for(int i = 0; i<methods.length; ++i) {
            String fileName = (cache.fileNamePrefix() + method.getName() + Utils.key(method, args));
           SerializationUtils.deserialize(cache.directory() + fileName);
        }

    }


    private Object getResultFromMemoryAndCache(Method method, Object[] args) throws Throwable {
        Cache cache = method.getAnnotation(Cache.class);
        Object result;
        Object key = Utils.key(method, Utils.getArgumentsByIdentityInMethod(args, Arrays.asList(cache.identityBy())));
        String fileName = (cache.fileNamePrefix() + method.getName() + Utils.key(method, args));

        if (!cacheMap.containsKey(key)) {
            result = invoke(method, args);
            saveFile(fileName, result);
            cacheMap.put(key, result);
            System.out.println("Значение метода " + method.getName() + " занесено в кэш / файл");
        } else {
            result = cacheMap.get(key);
            System.out.println("Значение метода " + method.getName() + " из кэша");
        }
        return result;
    }


    private Object invoke(Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(classObj, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(String fileName, Object result) throws IOException {
        File file = new File(filePath + fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(result);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void zipFile(String name) throws SerializationException {
        String zipFileName = name.substring(0, name.lastIndexOf(".")) + ".zip";
        try (FileOutputStream fileOutputStream = new FileOutputStream(zipFileName);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(new File(name))) {
            String fileName = name.substring(name.lastIndexOf(System.getProperty("file.separator")) + 1);
            ZipEntry entry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(entry);
            int temp;
            while ((temp = fileInputStream.read()) > -1) {
                zipOutputStream.write(temp);
            }
            fileInputStream.close();
            zipOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


