package com.springapp.dao;

import com.springapp.dao.file.ListItemDao;
import com.springapp.entities.ListItem;

import java.util.HashMap;

/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 */
public class FileDaoFactory {

    /** Collection of Dao objects*/
    private final HashMap<Class, GenericDao> daoObjects;

    public FileDaoFactory(){
        /** Populates DAO Objects List*/
        daoObjects = new HashMap<Class, GenericDao>();
        daoObjects.put(ListItem.class, new ListItemDao());
    }

    /** Returns DAO object for entity persistence state management  */
    public GenericDao getDao(Class entityClass) throws PersistException {
        return daoObjects.get(entityClass);
    }
}
