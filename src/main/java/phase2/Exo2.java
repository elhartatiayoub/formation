package phase2;

import model.Person;

import java.io.*;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class Exo2 {
    public static byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        os.writeObject(o);
        os.flush();
        os.close();
        return baos.toByteArray();
    }

    public static Object deserialize(byte[] bytes) throws IOException,
            ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        bais.close();
        return o;
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person("iob",23,"Hello world", null); // The original object
        byte[] personBytes = Exo2.serialize(person); // Serialize
        person = (Person) Exo2.deserialize(personBytes); // Deserialize
        System.out.println(person); // Good as new !
    }
}
