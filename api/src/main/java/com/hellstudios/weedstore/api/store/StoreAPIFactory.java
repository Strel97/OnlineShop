package com.hellstudios.weedstore.api.store;

import com.hellstudios.weedstore.api.APIFactory;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPI;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPIImpl;

/**
 * @author strel
 */
public class StoreAPIFactory implements APIFactory<StoreAPI> {

    @Override
    public StoreAPI createAPI() {
        return new StoreAPIImpl();
    }
}
