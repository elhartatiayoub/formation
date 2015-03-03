package phase4;

import phase1.Person;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class PersonDAOImpl extends GenericDAOImpl<Person> implements PersonDAO {

    @Override
    public Person getPersonByName(String name) {
        Query query = this.entityManager
                .createQuery("select u FROM Person u where u.name= :name");
        query.setParameter("name", name);
        List<Person> persons = query.getResultList();
        if (persons != null && persons.size() == 1) {
            return persons.get(0);
        }
        return null;
    }


}
