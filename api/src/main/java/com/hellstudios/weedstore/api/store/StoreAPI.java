package com.hellstudios.weedstore.api.store;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIException;

/**
 * @author strel
 */
public interface StoreAPI extends API {

    void createStore(StoreBean store) throws APIException;

    StoreBean getStore(String id) throws APIException;

    void updateStore(StoreBean store) throws APIException;
}
