package com.hellstudios.weedstore.api.balance;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountBean;

/**
 * @author strel
 */
public interface BalanceAPI extends API {

    void createBalance(AccountBean account) throws APIException;

    void createBalance(BalanceBean bean) throws APIException;

    boolean checkBalance(AccountBean account, int money) throws APIException;

    void withdraw(AccountBean account, int money) throws APIException;

    void replenish(AccountBean account, int money) throws APIException;
}
