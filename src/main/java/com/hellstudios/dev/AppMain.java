package com.hellstudios.dev;

import com.hellstudios.dev.core.persistence.entities.AccountEntity;
import com.hellstudios.dev.core.persistence.entities.BalanceEntity;
import com.hellstudios.dev.core.persistence.HibernateSessionFactory;
import org.hibernate.Session;

/**
 * @author strel
 */
public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();

        BalanceEntity balance = new BalanceEntity();
        balance.setMoney(1000);
        balance.setBlocked(false);
        session.save(balance);
        session.getTransaction().commit();

        session.beginTransaction();
        AccountEntity account = new AccountEntity();
        account.setName("strel");
        account.setPassword("28021997");
        account.setEmail("strel97@gmail.com");
        account.setBalance(balance);
        session.save(account);

        session.getTransaction().commit();
        session.close();

        System.out.println("Done");
        HibernateSessionFactory.shutdown();
    }
}
