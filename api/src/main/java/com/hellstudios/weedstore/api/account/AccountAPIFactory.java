package com.hellstudios.weedstore.api.account;

import com.hellstudios.weedstore.api.APIFactory;

/**
 * @author strel
 */
public class AccountAPIFactory implements APIFactory<AccountAPI> {

    @Override
    public AccountAPI createAPI() {
        return new AccountAPIImpl();
    }
}
