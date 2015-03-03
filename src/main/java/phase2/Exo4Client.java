package phase2;

import phase1.Person;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class Exo4Client {
    public static void main(String[] args) {
        InetAddress address = null;
        Socket connection = null;
        try {
            address = InetAddress.getByName("localhost");
            connection = new Socket(address, 9898);
            ObjectOutputStream bos = new ObjectOutputStream(connection.getOutputStream());
            Person person = new Person("iob",23,"Hello world");
            bos.writeObject(person);
            System.out.printf("object sent with success");
            bos.flush();
            bos.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
