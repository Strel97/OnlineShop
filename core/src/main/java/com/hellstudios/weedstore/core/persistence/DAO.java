package com.hellstudios.weedstore.core.persistence;

import java.util.List;

/**
 * @author strel
 */
public interface DAO<T> {

    void create(T entity) throws DAOException;

    void update(T entity) throws DAOException;

    T findById(String id) throws DAOException;

    void delete(T entity) throws DAOException;

    List<T> findAll();

    void deleteAll();
}
