package com.hellstudios.dev.core.persistence.dao;

import com.hellstudios.dev.core.persistence.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author strel
 */
public abstract class DAOImpl<Type> implements DAO<Type> {

    protected Session currentSession;
    protected Transaction currentTransaction;


    public Session openCurrentSession() {
        currentSession = HibernateSessionFactory.getSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = HibernateSessionFactory.getSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
}
