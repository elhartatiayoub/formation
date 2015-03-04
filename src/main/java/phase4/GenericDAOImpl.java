package phase4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrateur on 03/03/2015.
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {
    protected Class<T> entityClass;

    protected EntityManager entityManager;

    public GenericDAOImpl() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("em");

        entityManager = emfactory.createEntityManager( );
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(t);
        this.entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public T read(int id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {

        this.entityManager.getTransaction().begin();
        T obj = this.entityManager.merge(t);
        this.entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(T t) {
        this.entityManager.getTransaction().begin();
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
        this.entityManager.getTransaction().commit();
    }
}
