package com.hellstudios.dev.core.persistence.manufacturer;

import com.hellstudios.dev.core.persistence.DAOException;
import com.hellstudios.dev.core.persistence.DAOImpl;
import com.hellstudios.dev.core.persistence.account.AccountEntity;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author strel
 */
public class ManufacturerDAO extends DAOImpl<ManufacturerEntity> {

    public ManufacturerDAO() {

    }

    @Override
    public void create(ManufacturerEntity manufacturer) throws DAOException {
        if (manufacturer == null) {
            throw new DAOException("Given manufacturer entity is null.");
        }

        getCurrentSession().save(manufacturer);
    }

    @Override
    public void update(ManufacturerEntity manufacturer) throws DAOException {
        getCurrentSession().update(manufacturer);
    }

    @Override
    public ManufacturerEntity findById(String id) throws DAOException {
        return getCurrentSession().get(ManufacturerEntity.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ManufacturerEntity> findByOwner(AccountEntity owner) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM ManufacturerEntity WHERE owner = :owner");
        query.setParameter("owner", owner);

        return (List<ManufacturerEntity>) query.list();
    }

    @Override
    public void delete(ManufacturerEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ManufacturerEntity> findAll() {
        return (List<ManufacturerEntity>) getCurrentSession().createQuery("from ManufacturerEntity").list();
    }

    @Override
    public void deleteAll() {
        List<ManufacturerEntity> entityList = findAll();
        for (ManufacturerEntity entity : entityList) {
            delete(entity);
        }
    }
}
