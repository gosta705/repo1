package ru.sberbank.javaschool;

import com.sun.javafx.scene.web.Debugger;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.beans.Expression;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Security;
import java.util.Base64;


public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;
    Cipher dcipher;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {

        super(parent);
        this.key = key;
        this.dir = dir;
        dir.isFile();

    }


    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return decrypt(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public Class <?> encrypt(String name) {
        Integer key = Integer.parseInt(this.key);
        try {
            byte[] byteArray = Files.readAllBytes(Paths.get(dir + ""));
            for (int i = 0; i < byteArray.length; i++) byteArray[i] /= (key ++);

            return defineClass(name, byteArray, 0, byteArray.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Class<?> decrypt(String name) throws Exception {
        Integer key = Integer.parseInt(this.key);
        try {
            byte[] byteArray = Files.readAllBytes(Paths.get(dir + ""));
            for (int i = 0; i < byteArray.length; i++) byteArray[i] *= (key ++);

            return defineClass(name, byteArray, 0, byteArray.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
