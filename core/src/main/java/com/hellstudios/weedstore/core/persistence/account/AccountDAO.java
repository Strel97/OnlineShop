package com.hellstudios.weedstore.core.persistence.account;

import com.hellstudios.weedstore.core.persistence.DAOException;
import com.hellstudios.weedstore.core.persistence.DAOImpl;
import org.hibernate.query.Query;

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

    public AccountEntity findByEmail(String email) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM AccountEntity WHERE email = :email");
        query.setParameter("email", email);

        return (AccountEntity) query.getSingleResult();
    }

    @Override
    public void delete(AccountEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AccountEntity> findAll() {
        return (List<AccountEntity>) getCurrentSession().createQuery("from AccountEntity").list();
    }

    @Override
    public void deleteAll() {
        List<AccountEntity> entityList = findAll();
        for (AccountEntity entity : entityList) {
            delete(entity);
        }
    }
}
