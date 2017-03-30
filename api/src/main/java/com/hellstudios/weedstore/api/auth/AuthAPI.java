package com.hellstudios.weedstore.api.auth;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountBean;

/**
 * @author strel
 */
public interface AuthAPI extends API {

    String authenticate(AccountBean account) throws APIException;

    void logout(AccountBean account) throws APIException;

    boolean isAuthenticated(AccountBean account) throws APIException;
}
