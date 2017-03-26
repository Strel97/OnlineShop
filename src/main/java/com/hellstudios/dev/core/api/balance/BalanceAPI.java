package com.hellstudios.dev.core.api.balance;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.account.AccountBean;

/**
 * @author strel
 */
public interface BalanceAPI extends API {

    int createBalanceAccount(BalanceBean bean);

    boolean checkBalance(AccountBean account);

    void withdraw(AccountBean account, int money);

    void replenish(AccountBean account, int money);
}
