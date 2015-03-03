package phase2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class Exo1 {
    public static void main(String[] args) throws IOException {
        // I/O ecrant

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un nombre :");
        int str = sc.nextInt();
        System.out.println("Vous avez saisi le nombre : " + str);

        //I/O fichier

        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("input");
            out = new FileWriter("output");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        //I/O en reseau avec les sockets


    }
}
