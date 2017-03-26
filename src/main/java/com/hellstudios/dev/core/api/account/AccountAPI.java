package com.hellstudios.dev.core.api.account;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.persistence.entities.AccountEntity;

/**
 * @author strel
 */
public interface AccountAPI extends API {

    void createAccount(AccountEntity account);

    AccountEntity getAccountById( int id );

    AccountEntity getAccountByName( String name );

}
