package com.hellstudios.dev.core.persistence.store;

import com.hellstudios.dev.core.persistence.DAOException;
import com.hellstudios.dev.core.persistence.DAOImpl;
import com.hellstudios.dev.core.persistence.account.AccountEntity;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author strel
 */
public class StoreDAO extends DAOImpl<StoreEntity> {

    public StoreDAO() {

    }

    @Override
    public void create(StoreEntity store) throws DAOException {
        if (store == null) {
            throw new DAOException("Given store entity is null.");
        }

        getCurrentSession().save(store);
    }

    @Override
    public void update(StoreEntity store) throws DAOException {
        getCurrentSession().update(store);
    }

    @Override
    public StoreEntity findById(String id) throws DAOException {
        return getCurrentSession().get(StoreEntity.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<StoreEntity> findByOwner(AccountEntity owner) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM StoreEntity WHERE owner = :owner");
        query.setParameter("owner", owner);

        return (List<StoreEntity>) query.list();
    }

    @Override
    public void delete(StoreEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StoreEntity> findAll() {
        return (List<StoreEntity>) getCurrentSession().createQuery("from StoreEntity").list();
    }

    @Override
    public void deleteAll() {
        List<StoreEntity> entityList = findAll();
        for (StoreEntity entity : entityList) {
            delete(entity);
        }
    }
}
