package phase4;

import java.io.Serializable;

/**
 * Created by Administrateur on 03/03/2015.
 */
public interface GenericDAO<T> {
    T create(T t);
    T read(int id);
    T update(T t);
    void delete(T t);
}
