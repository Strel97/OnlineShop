package com.hellstudios.weedstore.api.manufacturer;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIException;

/**
 * @author strel
 */
public interface ManufacturerAPI extends API {

    void createManufacturer(ManufacturerBean manufacturer) throws APIException;

    ManufacturerBean getManufacturer(String id) throws APIException;

    void updateManufacturer(ManufacturerBean manufacturer) throws APIException;
}
