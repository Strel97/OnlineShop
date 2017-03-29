package com.hellstudios.weedstore.rest.store;

import com.hellstudios.weedstore.Application;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.api.store.StoreAPI;
import com.hellstudios.weedstore.api.store.StoreBean;
import com.hellstudios.weedstore.rest.JSONResponse;
import com.hellstudios.weedstore.rest.ReplyObject;
import com.hellstudios.weedstore.util.FieldValidation;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author strel
 */
@Path("store")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(StoreResource.class);

    /**
     * {@link StoreAPI} instance.
     */
    private StoreAPI storeAPI;

    /**
     * {@link AccountAPI} instance.
     */
    private AccountAPI accountAPI;


    public StoreResource() {
        try {
            storeAPI = Application.getInstance().getAPI(StoreAPI.class);
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
            return ReplyObject.success("account", storeAPI.getStoreById(id));
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    @GET
    @Path("get/all")
    public ReplyObject getAllAccounts() {
        try {
            return ReplyObject.success("stores", storeAPI.getAllStores());
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    @POST
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReplyObject updateProfile(@PathParam("id") String id, final StoreForm storeForm) {
        JSONResponse response = validateStoreData(storeForm);
        if (response.hasErrors()) {
            return ReplyObject.error(response.toString());
        }

        try {
            StoreBean store = storeAPI.getStoreById(id);

            store.setName(storeForm.getName());
            store.setDescription(storeForm.getDescription());
            store.setOwner(accountAPI.getAccountById(storeForm.getOwnerId()));

            storeAPI.updateStore(store);

            return ReplyObject.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ReplyObject.error(e.getMessage());
        }
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReplyObject updateProfile(final StoreForm storeForm) {
        JSONResponse response = validateStoreData(storeForm);
        if (response.hasErrors()) {
            return ReplyObject.error(response.toString());
        }

        try {
            StoreBean store = new StoreBean();
            store.setName(storeForm.getName());
            store.setDescription(storeForm.getDescription());
            store.setOwner(accountAPI.getAccountById(storeForm.getOwnerId()));

            storeAPI.createStore(store);

            return ReplyObject.success();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    private JSONResponse validateStoreData(final StoreForm storeForm) {
        JSONResponse response = new JSONResponse();
        FieldValidation.validateName(storeForm.getName(), response);
        return response;
    }
}
