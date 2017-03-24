package com.hellstudios.dev.core.api.store;

import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.entities.Product;
import com.hellstudios.dev.core.entities.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * @author strel
 */
public class StoreAPIConsoleImpl implements StoreAPI {


    private List<Store> stores;


    public StoreAPIConsoleImpl() {
        stores = new ArrayList<Store>();
    }


    public int createStore(Store store) throws APIException {
        if (store == null) {
            throw new APIException("Can't create store, it is null.");
        }

        int id = stores.size();
        store.setId(id);

        stores.add(store);
        return id;
    }

    public void updateOrCreateStore(Store store) throws APIException {
        if (store == null) {
            throw new APIException("Can't update store, it is null.");
        }

        // If no such store in collection create new one
        if (getStore(store.getId()) == null) {
            createStore(store);
            return;
        }

        // otherwise just update
        stores.set(store.getId(), store);
    }

    public Store getStore(int id) {

        if (stores.size() >= id || stores.size() < 0) {
            return null;
        }

        return stores.get(id);
    }
}
