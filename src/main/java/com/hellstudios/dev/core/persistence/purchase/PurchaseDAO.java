package com.hellstudios.dev.core.persistence.purchase;

import com.hellstudios.dev.core.persistence.DAOException;
import com.hellstudios.dev.core.persistence.DAOImpl;
import com.hellstudios.dev.core.persistence.account.AccountEntity;
import com.hellstudios.dev.core.persistence.product.ProductEntity;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author strel
 */
public class PurchaseDAO extends DAOImpl<PurchaseEntity> {

    public PurchaseDAO() {

    }

    @Override
    public void create(PurchaseEntity purchase) throws DAOException {
        if (purchase == null) {
            throw new DAOException("Given purchase entity is null.");
        }

        getCurrentSession().save(purchase);
    }

    @Override
    public void update(PurchaseEntity purchase) throws DAOException {
        getCurrentSession().update(purchase);
    }

    @Override
    public PurchaseEntity findById(String id) throws DAOException {
        return getCurrentSession().get(PurchaseEntity.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<PurchaseEntity> findByAccount(AccountEntity account) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM PurchaseEntity WHERE customerAccount = :account");
        query.setParameter("account", account);

        return (List<PurchaseEntity>) query.list();
    }

    @SuppressWarnings("unchecked")
    public List<PurchaseEntity> findByProduct(ProductEntity product) throws DAOException {
        Query query = getCurrentSession().createQuery("FROM PurchaseEntity WHERE product = :product");
        query.setParameter("product", product);

        return (List<PurchaseEntity>) query.list();
    }

    @Override
    public void delete(PurchaseEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PurchaseEntity> findAll() {
        return (List<PurchaseEntity>) getCurrentSession().createQuery("from PurchaseEntity").list();
    }

    @Override
    public void deleteAll() {
        List<PurchaseEntity> entityList = findAll();
        for (PurchaseEntity entity : entityList) {
            delete(entity);
        }
    }
}
