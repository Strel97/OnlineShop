package com.hellstudios.weedstore.rest.registration;


import com.hellstudios.weedstore.Application;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.api.account.AccountBean;
import com.hellstudios.weedstore.rest.JSONResponse;
import com.hellstudios.weedstore.rest.ReplyObject;
import com.hellstudios.weedstore.util.FieldValidation;
import org.apache.log4j.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Endpoint for rest registration api interface.
 * @author strel
 */
@Path("registration")
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationResource {
    /**
     * {@link Logger}.
     */
    private static final Logger log = Logger.getLogger(RegistrationResource.class);

    private AccountAPI accountAPI;


    public RegistrationResource() {
        try {
            accountAPI = Application.getInstance().getAPI(AccountAPI.class);
        }
        catch (APIException ex) {
            log.error("Can't get Account API.");
        }
    }

    @POST
    @Path("register")
    public ReplyObject register(final RegistrationResourceForm registrationResourceForm) {
        JSONResponse response = validateRegistrationData(registrationResourceForm);
        if (response.hasErrors()) {
            return ReplyObject.error(response.toString());
        }

        String email = registrationResourceForm.getEmail();
        String password = registrationResourceForm.getPassword();
        String name = registrationResourceForm.getName();

        try {
            AccountBean account = new AccountBean(name, password, email);
            accountAPI.createAccount(account);

            return ReplyObject.success("registered", account);
        } catch (APIException ex) {
            log.error("Can't create account", ex);
            return ReplyObject.error(ex.getMessage());
        }
    }

    private JSONResponse validateRegistrationData(final RegistrationResourceForm registrationForm) {
        JSONResponse response = new JSONResponse();

        FieldValidation.validateEmail(registrationForm.getEmail(), response);
        FieldValidation.validatePassword(registrationForm.getPassword(), response);
        FieldValidation.validateName(registrationForm.getName(), response);

        return response;
    }
}
