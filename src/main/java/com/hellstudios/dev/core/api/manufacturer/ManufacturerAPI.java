package com.hellstudios.dev.core.api.manufacturer;

import com.hellstudios.dev.core.api.API;
import com.hellstudios.dev.core.api.APIException;

/**
 * @author strel
 */
public interface ManufacturerAPI extends API {

    void createManufacturer(ManufacturerBean manufacturer) throws APIException;

    ManufacturerBean getManufacturer(String id) throws APIException;

    void updateManufacturer(ManufacturerBean manufacturer) throws APIException;
}
