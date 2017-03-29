package com.hellstudios.weedstore.api.store;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIException;

import java.util.List;

/**
 * @author strel
 */
public interface StoreAPI extends API {

    void createStore(StoreBean store) throws APIException;

    StoreBean getStoreById(String id) throws APIException;

    List<StoreBean> getAllStores() throws APIException;

    void updateStore(StoreBean store) throws APIException;
}
