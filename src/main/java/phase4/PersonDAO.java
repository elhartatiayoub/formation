package phase4;

import model.Person;

/**
 * Created by Administrateur on 03/03/2015.
 */
public interface PersonDAO extends GenericDAO<Person> {
    public Person getPersonByName(String name);
}
