package com.hellstudios.dev.core.api.store;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.entities.Product;
import com.hellstudios.dev.core.entities.Store;

/**
 * @author strel
 */
public interface StoreAPI extends API {

    int createStore(Store store);

    Store getStore(int id);

    void addProduct(int storeId, Product product);

}
