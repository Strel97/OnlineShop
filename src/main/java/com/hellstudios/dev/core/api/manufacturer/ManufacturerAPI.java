package com.hellstudios.dev.core.api.manufacturer;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.persistence.manufacturer.ManufacturerEntity;

/**
 * @author strel
 */
public interface ManufacturerAPI extends API {

    int createManufacturer(ManufacturerEntity manufacturer) throws APIException;

    ManufacturerEntity getManufacturer(int id) throws APIException;

    void updateOrCreateManufacturer(ManufacturerEntity manufacturer) throws APIException;
}
