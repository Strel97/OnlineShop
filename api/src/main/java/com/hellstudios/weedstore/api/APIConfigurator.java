package com.hellstudios.weedstore.api;

import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.api.account.AccountAPIFactory;
import com.hellstudios.weedstore.api.balance.BalanceAPI;
import com.hellstudios.weedstore.api.balance.BalanceAPIFactory;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPI;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPIFactory;
import com.hellstudios.weedstore.api.store.StoreAPI;
import com.hellstudios.weedstore.api.store.StoreAPIFactory;

/**
 * @author strel
 */
public final class APIConfigurator {

    /**
     * Default constructor.
     */
    private APIConfigurator() {
        throw new IllegalAccessError();
    }

    /**
     * Configure APIs.
     */
    public static void configure() {
        APIManager.addAPIFactory(AccountAPI.class, new AccountAPIFactory());
        APIManager.addAPIFactory(BalanceAPI.class, new BalanceAPIFactory());
        APIManager.addAPIFactory(ManufacturerAPI.class, new ManufacturerAPIFactory());
        APIManager.addAPIFactory(StoreAPI.class, new StoreAPIFactory());
    }
}
