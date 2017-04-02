package com.hellstudios.weedstore.api;

import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.api.account.AccountAPIFactory;
import com.hellstudios.weedstore.api.auth.AuthAPI;
import com.hellstudios.weedstore.api.auth.AuthAPIFactory;
import com.hellstudios.weedstore.api.balance.BalanceAPI;
import com.hellstudios.weedstore.api.balance.BalanceAPIFactory;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPI;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPIFactory;
import com.hellstudios.weedstore.api.product.ProductAPI;
import com.hellstudios.weedstore.api.product.ProductAPIFactory;
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
        APIManager.addAPIFactory(AuthAPI.class, new AuthAPIFactory());
        APIManager.addAPIFactory(BalanceAPI.class, new BalanceAPIFactory());
        APIManager.addAPIFactory(ManufacturerAPI.class, new ManufacturerAPIFactory());
        APIManager.addAPIFactory(StoreAPI.class, new StoreAPIFactory());
        APIManager.addAPIFactory(ProductAPI.class, new ProductAPIFactory());
    }
}
