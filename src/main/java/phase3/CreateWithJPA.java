package phase3;

import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class CreateWithJPA {

    public static void main( String[ ] args ) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("em");

        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        Person p1 = new Person("iob",23,"adresse", null);
        Person p2 = new Person("iob2",22,"adresse", null);
        Person p3 = new Person("iob3",27,"adresse", null);

        entitymanager.persist( p1 );
        entitymanager.persist( p2 );
        entitymanager.persist( p2 );
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
    }
}