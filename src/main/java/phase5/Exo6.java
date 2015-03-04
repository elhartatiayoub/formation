package phase5;

import model.Child;
import model.Person;
import phase4.ChildDAOImpl;
import phase4.DaoFactory;
import phase4.PersonDAOImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrateur on 04/03/2015.
 */
public class Exo6 {
    public static void main(String[] args) {
//        Person p = new Person("iob",22,"yuuyuyuyu",null);
//        List<Child> list = new ArrayList<Child>();
//        list.add(new Child("fils1",2,p));
//        list.add(new Child("fils2",1,p));
//        p.setChildren(list);
//        DaoFactory.getInstance().getDao(PersonDAOImpl.class).create(p);
//        Child c = new Child("fils3",1,p);
//        DaoFactory.getInstance().getDao(ChildDAOImpl.class).create(c);
        Person fromDB = DaoFactory.getInstance().getDao(PersonDAOImpl.class).read(1);
        System.out.println(fromDB);



    }
}
