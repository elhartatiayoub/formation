package phase5;

import model.Employee;
import model.Projet;
import phase4.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by iob on 04/03/2015.
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
//        Person fromDB = DaoFactory.getInstance().getDao(PersonDAOImpl.class).read(1);
//        System.out.println(fromDB);

        Employee employee = new Employee("iob",23,"azazazaaz","intelcia",0);
        Employee employee2 = new Employee("iob2",22,"azazazaaz","intelcia",1);

        Projet projet = new Projet("Proj1",new Date());
        Projet projet2 = new Projet("Proj2",new Date());

        List<Projet> listProj = new ArrayList<Projet>();
        List<Employee> listEmp = new ArrayList<Employee>();

        listEmp.add(employee);
        listEmp.add(employee2);

        listProj.add(projet);
        listProj.add(projet2);

        projet.setEquip(listEmp);
        employee.setProjets(listProj);

        DaoFactory.getInstance().getDao(EmploeeDAOImpl.class).create(employee);

        DaoFactory.getInstance().getDao(ProjetDAOImpl.class).update(projet);


    }
}
