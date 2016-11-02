package ru.sberbank.school.Utils;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import java.io.*;

public class SerializationUtils {

    public static void serialize(Serializable o, String file) throws SerializationException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(o);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static <T> T deserialize(String file) throws SerializationException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Значение восстановлено из файла");
            return (T) inputStream.readObject();
        } catch (IOException |  ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
