package com.hellstudios.dev.core.api.account;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;

/**
 * @author strel
 */
public interface AccountAPI extends API {

    void createAccount(AccountBean account) throws APIException;

    AccountBean getAccountById( String id ) throws APIException;

    AccountBean getAccountByEmail( String name ) throws APIException;

}
