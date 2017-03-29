package com.hellstudios.weedstore.api.account;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIException;

import java.util.List;

/**
 * @author strel
 */
public interface AccountAPI extends API {

    void createAccount(AccountBean account) throws APIException;

    AccountBean getAccountById(String id) throws APIException;

    AccountBean getAccountByEmail(String name) throws APIException;

    List<AccountBean> getAllAccounts() throws APIException;

    boolean login(String email, String password) throws APIException;
}
