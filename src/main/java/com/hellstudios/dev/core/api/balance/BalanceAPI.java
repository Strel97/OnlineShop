package com.hellstudios.dev.core.api.balance;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.entities.Account;

/**
 * @author strel
 */
public interface BalanceAPI extends API {

    boolean checkBalance(Account account);

    boolean withdraw(Account account, int money);

    void replenish(Account account, int money);
}
