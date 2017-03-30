package com.hellstudios.weedstore.core.persistence.auth;

import com.hellstudios.weedstore.core.persistence.DAOException;
import com.hellstudios.weedstore.core.persistence.DAOImpl;

import java.util.List;

/**
 * @author strel
 */
public class AuthDAO extends DAOImpl<AuthEntity> {

    public AuthDAO() {

    }

    @Override
    public void create(AuthEntity authEntity) throws DAOException {
        if (authEntity == null) {
            throw new DAOException("Given auth entity is null.");
        }

        getCurrentSession().save(authEntity);
    }

    @Override
    public void update(AuthEntity account) throws DAOException {
        getCurrentSession().update(account);
    }

    @Override
    public AuthEntity findById(String id) throws DAOException {
        return getCurrentSession().get(AuthEntity.class, id);
    }

    public AuthEntity findByEmail(String email) throws DAOException {
        return findById(email);
    }

    public void deleteByEmail(String email) throws DAOException {
        getCurrentSession().delete( findByEmail(email) );
    }


    @Override
    public void delete(AuthEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AuthEntity> findAll() {
        return (List<AuthEntity>) getCurrentSession().createQuery("from AuthEntity").list();
    }

    @Override
    public void deleteAll() {
        List<AuthEntity> entityList = findAll();
        for (AuthEntity entity : entityList) {
            delete(entity);
        }
    }
}
