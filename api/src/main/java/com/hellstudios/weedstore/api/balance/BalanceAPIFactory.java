package com.hellstudios.weedstore.api.balance;

import com.hellstudios.weedstore.api.APIFactory;

/**
 * @author strel
 */
public class BalanceAPIFactory implements APIFactory<BalanceAPI> {

    @Override
    public BalanceAPI createAPI() {
        return new BalanceAPIImpl();
    }
}
