package com.hellstudios.dev;

import com.hellstudios.dev.core.api.account.AccountAPI;
import com.hellstudios.dev.core.api.account.AccountAPIImpl;
import com.hellstudios.dev.core.api.account.AccountBean;
import com.hellstudios.dev.core.api.balance.BalanceAPI;
import com.hellstudios.dev.core.api.balance.BalanceAPIImpl;
import com.hellstudios.dev.core.persistence.HibernateSessionFactory;

/**
 * @author strel
 */
public class AppMain {

    public static void main(String[] args) throws Exception {
        System.out.println("Testing APIs");

        AccountAPI accountAPI = new AccountAPIImpl();
        BalanceAPI balanceAPI = new BalanceAPIImpl();


        try {
            AccountBean account = new AccountBean();
            account.setName("strel");
            account.setEmail("strel@gmail.com");
            account.setPassword("28021997");

            accountAPI.createAccount(account);


            balanceAPI.createBalance(account);
            balanceAPI.replenish(account, 1000);

            System.out.println(balanceAPI.checkBalance(account, 50));
        }
        finally {
            HibernateSessionFactory.shutdown();
        }
    }
}
