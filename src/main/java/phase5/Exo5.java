package phase5;

import model.Employee;
import phase4.DaoFactory;
import phase4.EmploeeDAOImpl;

/**
 * Created by Administrateur on 04/03/2015.
 */
public class Exo5 {
    public static void main(String[] args) {
        Employee e = new Employee("hartati",275,"adqsdxqresse","intelcia",0);
        DaoFactory.getInstance().getDao(EmploeeDAOImpl.class).create(e);
    }
}
