package com.hellstudios.weedstore.rest.login;

import com.hellstudios.weedstore.Application;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.core.util.StringUtils;
import com.hellstudios.weedstore.rest.ReplyObject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author strel
 */
@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    /**
     * {@code Slf4j} {@link Logger}.
     */
    private static final Logger log = Logger.getLogger(AuthResource.class);

    private AccountAPI accountAPI;


    public AuthResource() {
        try {
            accountAPI = Application.getInstance().getAPI(AccountAPI.class);
        }
        catch (APIException ex) {
            log.error("Can't initialize Account API", ex);
        }
    }


    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReplyObject login(LoginForm loginForm) {
        if (StringUtils.isEmpty(loginForm.getEmail()) || StringUtils.isEmpty(loginForm.getPassword())) {
            return ReplyObject.error("Wrong parameters");
        }

        try {
            accountAPI.login(loginForm.getEmail(), loginForm.getPassword());
            return ReplyObject.success();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }
}
