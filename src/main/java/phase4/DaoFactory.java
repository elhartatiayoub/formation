package phase4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrateur on 04/03/2015.
 */
public class DaoFactory {

    private static DaoFactory instance;

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    Map<Class<? extends GenericDAOImpl>, GenericDAOImpl> daoList = new HashMap<Class<? extends GenericDAOImpl>, GenericDAOImpl>();

    public <T extends GenericDAOImpl> T getDao(Class<T> daoClazz) {

        T dao = daoClazz.cast(daoList.get(daoClazz));
        if (dao != null) {
            return dao;
        }

        // if not existed, create another new one and return
        // cached it, after that it is accessible

        try {
            dao = daoClazz.newInstance();
            daoList.put(daoClazz, dao);
            return dao;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}