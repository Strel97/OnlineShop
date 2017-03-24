package com.hellstudios.dev.core.api.account;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.entities.Account;

/**
 * @author strel
 */
public interface AccountAPI extends API {

    void createAccount(Account account);

    Account getAccountById( int id );

    Account getAccountByName( String name );

}
