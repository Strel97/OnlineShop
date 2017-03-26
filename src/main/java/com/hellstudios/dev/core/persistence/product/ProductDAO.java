package com.hellstudios.dev.core.persistence.product;

import com.hellstudios.dev.core.persistence.DAOException;
import com.hellstudios.dev.core.persistence.DAOImpl;
import com.hellstudios.dev.core.persistence.manufacturer.ManufacturerEntity;
import com.hellstudios.dev.core.persistence.store.StoreEntity;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author strel
 */
public class ProductDAO extends DAOImpl<ProductEntity> {

    public ProductDAO() {

    }

    @Override
    public void create(ProductEntity product) throws DAOException {
        if (product == null) {
            throw new DAOException("Given product entity is null.");
        }

        getCurrentSession().save(product);
    }

    @Override
    public void update(ProductEntity product) throws DAOException {
        getCurrentSession().update(product);
    }

    @Override
    public ProductEntity findById(String id) throws DAOException {
        return getCurrentSession().get(ProductEntity.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ProductEntity> findByManufacturer(ManufacturerEntity manufacturer) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM ProductEntity WHERE manufacturer = :manufacturer");
        query.setParameter("manufacturer", manufacturer);

        return (List<ProductEntity>) query.list();
    }

    @SuppressWarnings("unchecked")
    public List<ProductEntity> findByStore(StoreEntity store) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM ProductEntity WHERE store = :store");
        query.setParameter("store", store);

        return (List<ProductEntity>) query.list();
    }

    @Override
    public void delete(ProductEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) getCurrentSession().createQuery("from ProductEntity").list();
    }

    @Override
    public void deleteAll() {
        List<ProductEntity> entityList = findAll();
        for (ProductEntity entity : entityList) {
            delete(entity);
        }
    }
}
