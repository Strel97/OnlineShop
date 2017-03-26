package com.hellstudios.dev.core.persistence.dao;

import com.hellstudios.dev.core.persistence.entities.AccountEntity;

import java.util.List;

/**
 * @author strel
 */
public class AccountDAO extends DAOImpl<AccountEntity> {

    public AccountDAO() {

    }

    @Override
    public void create(AccountEntity account) throws DAOException {
        if (account == null) {
            throw new DAOException("Given account entity is null.");
        }

        getCurrentSession().save(account);
    }

    @Override
    public void update(AccountEntity account) throws DAOException {
        getCurrentSession().update(account);
    }

    @Override
    public AccountEntity findById(String id) throws DAOException {
        return getCurrentSession().get(AccountEntity.class, id);
    }

    @Override
    public void delete(AccountEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AccountEntity> findAll() {
        return (List<AccountEntity>) getCurrentSession().createQuery("from Accounts").list();
    }

    @Override
    public void deleteAll() {
        List<AccountEntity> entityList = findAll();
        for (AccountEntity entity : entityList) {
            delete(entity);
        }
    }
}
