package phase1;

import model.Person;

import java.util.*;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class Exo5 {
    public static void main(String[] args) {
        Person p1 = new Person("iob",23,"adresse", null);
        Person p2 = new Person("iob2",22,"adresse", null);
        Person p3 = new Person("iob3",27,"adresse", null);
        List<Person> listP;
        listP = new ArrayList<Person>();
        listP.add(p1);
        listP.add(p2);
        listP.add(p3);

        Map mapP = new HashMap();
        mapP.put("AD123",p1);
        mapP.put("AB123",p2);
        mapP.put("AC123",p3);

        System.out.printf("la liste : "+listP+"\n");
        System.out.println("la map est : "+mapP);

        //exo 6 trie avec l'age

        Collections.sort(listP);
        System.out.printf("\n"+"la liste tiée : "+listP+"\n");

    }
}
