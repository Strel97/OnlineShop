package com.hellstudios.dev.core.api.manufacturer;

import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.entities.Manufacturer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author strel
 */
public class ManufacturerAPIConsoleImpl implements ManufacturerAPI {


    private List<Manufacturer> manufacturers;


    public ManufacturerAPIConsoleImpl() {
        manufacturers = new ArrayList<Manufacturer>();
    }


    public int createManufacturer(Manufacturer manufacturer) throws APIException {
        if (manufacturer == null) {
            throw new APIException("Can't create manufacturer, it is null.");
        }

        int id = manufacturers.size();
        manufacturer.setId(id);

        manufacturers.add(manufacturer);
        return id;
    }

    public void updateOrCreateManufacturer(Manufacturer manufacturer) throws APIException {
        if (manufacturer == null) {
            throw new APIException("Can't update manufacturer, it is null.");
        }

        // If no such manufacturer in collection create new one
        if (getManufacturer(manufacturer.getId()) == null) {
            createManufacturer(manufacturer);
            return;
        }

        // otherwise just update
        manufacturers.set(manufacturer.getId(), manufacturer);
    }

    public Manufacturer getManufacturer(int id) {

        if (manufacturers.size() >= id || manufacturers.size() < 0) {
            return null;
        }

        return manufacturers.get(id);
    }
}
