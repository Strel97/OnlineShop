package com.hellstudios.dev.core.persistence.dao;

import com.hellstudios.dev.core.persistence.entities.AccountEntity;
import com.hellstudios.dev.core.persistence.entities.BalanceEntity;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * @author strel
 */
public class BalanceDAO extends DAOImpl<BalanceEntity> {

    public BalanceDAO() {

    }

    @Override
    public void create(BalanceEntity balance) throws DAOException {
        if (balance == null) {
            throw new DAOException("Given balance entity is null.");
        }

        getCurrentSession().save(balance);
    }

    @Override
    public void update(BalanceEntity balance) throws DAOException {
        getCurrentSession().update(balance);
    }

    @Override
    public BalanceEntity findById(String id) throws DAOException {
        return getCurrentSession().get(BalanceEntity.class, id);
    }

    public BalanceEntity findByOwner(AccountEntity owner) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM BalanceEntity WHERE owner = :owner");
        query.setParameter("owner", owner);

        return (BalanceEntity) query.uniqueResult();
    }

    @Override
    public void delete(BalanceEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BalanceEntity> findAll() {
        return (List<BalanceEntity>) getCurrentSession().createQuery("from Accounts").list();
    }

    @Override
    public void deleteAll() {
        List<BalanceEntity> entityList = findAll();
        for (BalanceEntity entity : entityList) {
            delete(entity);
        }
    }
}
