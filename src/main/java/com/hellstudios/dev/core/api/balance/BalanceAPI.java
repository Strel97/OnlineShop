package com.hellstudios.dev.core.api.balance;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.api.account.AccountBean;

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
