package com.hellstudios.dev.core.api.store;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.persistence.entities.StoreEntity;

/**
 * @author strel
 */
public interface StoreAPI extends API {

    int createStore(StoreEntity store) throws APIException;

    StoreEntity getStore(int id) throws APIException;

    void updateOrCreateStore(StoreEntity store) throws APIException;
}
