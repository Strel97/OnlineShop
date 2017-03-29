package com.hellstudios.weedstore.rest.account;

import com.hellstudios.weedstore.Application;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.rest.ReplyObject;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author strel
 */
@Path("account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(AccountResource.class);

    /**
     * {@link AccountAPI} instance.
     */
    private AccountAPI accountAPI;


    public AccountResource() {
        try {
            accountAPI = Application.getInstance().getAPI(AccountAPI.class);
        }
        catch (APIException ex) {
            log.error("Can't instantiate Account API", ex);
        }
    }

    @GET
    @Path("get/{id}")
    public ReplyObject getAccount(@PathParam("id") String id) {
        try {
            return ReplyObject.success("account", accountAPI.getAccountById(id));
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    @GET
    @Path("get/all")
    public ReplyObject getAllAccounts() {
        try {
            return ReplyObject.success("accounts", accountAPI.getAllAccounts());
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }
}
