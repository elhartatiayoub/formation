package phase4;

import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrateur on 04/03/2015.
 */
public class EmploeeDAOImpl extends GenericDAOImpl<Employee> implements EmployeeDAO{
    @Override
    public Employee promoteEmployee(String name, int promotion) {
        EntityManager em = Persistence.createEntityManagerFactory("em").createEntityManager();
        em.getTransaction().begin();
        List<Employee> employees = em.createQuery("SELECT c FROM Employee c WHERE c.name LIKE :custName",Employee.class).setParameter("custName", name).getResultList();
        if(employees.size()!=0){
            String query = "UPDATE Employee e SET e.salary = e.salary + :promotion WHERE e.id = :id";
            Query q = em.createQuery(query);
            q.setParameter("promotion",promotion);
            q.setParameter("id",employees.get(0).getId());
            q.executeUpdate();
            em.getTransaction().commit();
            return employees.get(0);
        }else
            return null;
    }

    @Override
    public int countEmployees() {
        EntityManager em = Persistence.createEntityManagerFactory("em").createEntityManager();
        em.getTransaction().begin();
        int i = em.createQuery("SELECT COUNT(c.id) FROM Employee c").getFirstResult();
//        int i = em.createNativeQuery("BEGIN SELECT COUNT(ID) FROM EMLPOYEE END;").getFirstResult();
        em.getTransaction().commit();
        return i;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        EntityManager em = Persistence.createEntityManagerFactory("em").createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
        Root<Employee> c = q.from(Employee.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("name"), p));
        Query query = em.createQuery(q);
        List<Employee> res = query.getResultList();
        return res.get(0);
    }

    //implements other methods
}
