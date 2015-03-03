package phase4;

import phase1.Person;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class Test {
    public static void main(String[] args) {
        PersonDAO dao = new PersonDAOImpl();
        Person p = new Person("iob3sd",275,"adqsdxqresse");
        dao.create(p);

    }

}
