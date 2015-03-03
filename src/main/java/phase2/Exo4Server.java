package phase2;

import phase1.Person;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class Exo4Server {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9898);
        try {
            while (true) {
                Socket s = listener.accept();
                ObjectInputStream is = new ObjectInputStream(s.getInputStream());

                Person p = (Person) is.readObject();
                System.out.println(p);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("class not fouuund!!");
            e.printStackTrace();
        } finally {
            listener.close();
        }
    }
}
