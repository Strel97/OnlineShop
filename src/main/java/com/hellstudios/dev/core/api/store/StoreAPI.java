package com.hellstudios.dev.core.api.store;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;

/**
 * @author strel
 */
public interface StoreAPI extends API {

    void createStore(StoreBean store) throws APIException;

    StoreBean getStore(String id) throws APIException;

    void updateStore(StoreBean store) throws APIException;
}
