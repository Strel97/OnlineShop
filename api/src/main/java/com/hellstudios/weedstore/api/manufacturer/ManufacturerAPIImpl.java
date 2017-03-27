package com.hellstudios.weedstore.api.manufacturer;

import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.core.persistence.DAOException;
import com.hellstudios.weedstore.core.persistence.manufacturer.ManufacturerDAO;
import com.hellstudios.weedstore.core.persistence.manufacturer.ManufacturerEntity;
import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * @author strel
 */
public class ManufacturerAPIImpl implements ManufacturerAPI {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(ManufacturerAPIImpl.class.getName());

    /**
     * {@link ManufacturerDAO} instance.
     */
    private ManufacturerDAO manufacturerDAO;



    @Override
    public void init() {
        this.manufacturerDAO = new ManufacturerDAO();
    }

    @Override
    public void deInit() {
    }

    @Override
    public void createManufacturer(ManufacturerBean manufacturer) throws APIException {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Can't create manufacturer, bean is null.");
        }
        if (manufacturer.getOwner() == null) {
            throw new IllegalArgumentException("Can't create manufacturer, manufacturer account can't be null.");
        }

        try {
            // Generating id as UUID
            manufacturer.setId(UUID.randomUUID().toString());

            manufacturerDAO.openCurrentSessionWithTransaction();
            manufacturerDAO.create(manufacturer.toEntity());
            manufacturerDAO.closeCurrentSessionWithTransaction();

            log.debug(String.format("Created new manufacturer account %s for user %s.", manufacturer, manufacturer.getOwner()));
        }
        catch (DAOException ex) {
            String msg = "Can't create new Manufacturer in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public ManufacturerBean getManufacturer(String id) throws APIException {
        try {
            manufacturerDAO.openCurrentSessionWithTransaction();
            ManufacturerEntity entity = manufacturerDAO.findById( id );
            manufacturerDAO.closeCurrentSessionWithTransaction();

            return new ManufacturerBean(entity);
        }
        catch (DAOException ex) {
            String msg = String.format("Can't get manufacturer account with id [%s]", id);
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public void updateManufacturer(ManufacturerBean manufacturer) throws APIException {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Can't update manufacturer, bean is null.");
        }
        if (manufacturer.getOwner() == null) {
            throw new IllegalArgumentException("Can't update manufacturer with empty account.");
        }

        try {
            manufacturerDAO.openCurrentSessionWithTransaction();
            manufacturerDAO.update(manufacturer.toEntity());
            manufacturerDAO.closeCurrentSessionWithTransaction();

            log.debug(String.format("Updated manufacturer account %s for user %s.", manufacturer, manufacturer.getOwner()));
        }
        catch (DAOException ex) {
            String msg = "Can't update manufacturer in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }
}
