package com.hellstudios.weedstore.rest.manufacturer;

import com.hellstudios.weedstore.Application;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPI;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerBean;
import com.hellstudios.weedstore.rest.JSONResponse;
import com.hellstudios.weedstore.rest.ReplyObject;
import com.hellstudios.weedstore.util.FieldValidation;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * @author strel
 */
@Path("manufacturer")
@Produces(MediaType.APPLICATION_JSON)
public class ManufacturerResource {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(ManufacturerResource.class);

    /**
     * {@link ManufacturerAPI} instance.
     */
    private ManufacturerAPI manufacturerAPI;

    /**
     * {@link AccountAPI} instance.
     */
    private AccountAPI accountAPI;


    public ManufacturerResource() {
        try {
            manufacturerAPI = Application.getInstance().getAPI(ManufacturerAPI.class);
            accountAPI = Application.getInstance().getAPI(AccountAPI.class);
        }
        catch (APIException ex) {
            log.error("Can't instantiate APIs", ex);
        }
    }

    @GET
    @Path("get/{id}")
    public ReplyObject getAccount(@PathParam("id") String id) {
        try {
            return ReplyObject.success("manufacturer", manufacturerAPI.getManufacturerById(id));
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    @GET
    @Path("get/all")
    public ReplyObject getAllAccounts() {
        try {
            return ReplyObject.success("manufacturers", manufacturerAPI.getAllManufacturers());
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    @POST
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReplyObject updateProfile(@PathParam("id") String id, final ManufacturerForm manufacturerForm) {
        JSONResponse response = validateStoreData(manufacturerForm);
        if (response.hasErrors()) {
            return ReplyObject.error(response.toString());
        }

        try {
            ManufacturerBean manufacturer = manufacturerAPI.getManufacturerById(id);

            manufacturer.setName(manufacturerForm.getName());
            manufacturer.setDescription(manufacturerForm.getDescription());
            manufacturer.setOriginCountry(manufacturerForm.getOriginCountry());
            manufacturer.setOwner(accountAPI.getAccountById(manufacturerForm.getOwnerId()));

            manufacturerAPI.updateManufacturer(manufacturer);

            return ReplyObject.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ReplyObject.error(e.getMessage());
        }
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReplyObject updateProfile(final ManufacturerForm manufacturerForm) {
        JSONResponse response = validateStoreData(manufacturerForm);
        if (response.hasErrors()) {
            return ReplyObject.error(response.toString());
        }

        try {
            ManufacturerBean store = new ManufacturerBean();
            store.setName(manufacturerForm.getName());
            store.setDescription(manufacturerForm.getDescription());
            store.setOriginCountry(manufacturerForm.getOriginCountry());
            store.setOwner(accountAPI.getAccountById(manufacturerForm.getOwnerId()));

            manufacturerAPI.createManufacturer(store);

            return ReplyObject.success();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    private JSONResponse validateStoreData(final ManufacturerForm manufacturerForm) {
        JSONResponse response = new JSONResponse();

        FieldValidation.validateName(manufacturerForm.getName(), response);
        FieldValidation.validateOriginCountry(manufacturerForm.getOriginCountry(), response);

        return response;
    }
}
