package com.hellstudios.weedstore.api.manufacturer;

import com.hellstudios.weedstore.api.APIFactory;

/**
 * @author strel
 */
public class ManufacturerAPIFactory implements APIFactory<ManufacturerAPI> {

    @Override
    public ManufacturerAPI createAPI() {
        return new ManufacturerAPIImpl();
    }
}
