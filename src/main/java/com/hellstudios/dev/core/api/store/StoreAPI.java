package com.hellstudios.dev.core.api.store;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.entities.Store;

/**
 * @author strel
 */
public interface StoreAPI extends API {

    int createStore(Store store) throws APIException;

    Store getStore(int id) throws APIException;

    void updateOrCreateStore(Store store) throws APIException;
}
