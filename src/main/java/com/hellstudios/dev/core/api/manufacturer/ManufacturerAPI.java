package com.hellstudios.dev.core.api.manufacturer;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.entities.Manufacturer;

/**
 * @author strel
 */
public interface ManufacturerAPI extends API {

    int createManufacturer(Manufacturer manufacturer) throws APIException;

    Manufacturer getManufacturer(int id) throws APIException;

    void updateOrCreateManufacturer(Manufacturer manufacturer) throws APIException;
}
