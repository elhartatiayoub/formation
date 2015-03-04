package phase4;

import model.Person;

/**
 * Created by iob on 03/03/2015.
 */
public class Test {
    public static void main(String[] args) {
        //PersonDAO dao = new PersonDAOImpl();
        Person p = new Person("iob123",275,"adqsdxqresse");
        DaoFactory.getInstance().getDao(PersonDAOImpl.class).create(p);

    }

}
