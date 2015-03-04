package phase4;

import model.Employee;

/**
 * Created by Administrateur on 04/03/2015.
 */
public interface EmployeeDAO extends GenericDAO<Employee> {
    public Employee promoteEmployee(String name,int promotion);
    public int countEmployees();
    public  Employee getEmployeeByName(String name);
    //other methods
}
