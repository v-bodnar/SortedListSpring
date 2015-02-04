package com.springapp.dao;


import com.springapp.entities.Identified;

import java.io.Serializable;
import java.util.List;
/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 *
 * Unified interface for persistent object management
 * @param <T> persistence type
 * @param <PK> key type
 */
public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {

    /** Creates new record for object inside the persistence storage*/
    public void create(T object) throws PersistException;

    /** Updates object state inside the persistence storage */
    public void update(T object) throws PersistException;

    /** Removes object from persistent storage */
    public void remove(T object) throws PersistException;

    /** Removes all objects from persistent storage */
    public void removeAll() throws PersistException;

    /** Returns object corresponding to Primary key or null */
    public T find(PK key) throws PersistException;

    /** Returns a List of objects corresponding to persistence storage */
    public List<T> findAll() throws PersistException;

}