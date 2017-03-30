package com.hellstudios.weedstore.api.auth;

import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountBean;
import com.hellstudios.weedstore.core.persistence.DAOException;
import com.hellstudios.weedstore.core.persistence.auth.AuthDAO;
import com.hellstudios.weedstore.core.persistence.auth.AuthEntity;
import com.hellstudios.weedstore.core.util.Token;
import com.hellstudios.weedstore.core.util.TokenUtil;
import org.apache.log4j.Logger;

import java.util.Calendar;

/**
 * @author strel
 */
public class AuthAPIImpl implements AuthAPI {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(AuthAPIImpl.class.getName());

    /**
     * {@link AuthDAO} instance.
     */
    private AuthDAO authDAO;


    @Override
    public void init() {
        authDAO = new AuthDAO();
    }

    @Override
    public void deInit() {

    }

    @Override
    public String authenticate(AccountBean account) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }

        try {
            // Trying to find out, whether user has token already
            authDAO.openCurrentSessionWithTransaction();
            AuthEntity authEntity = authDAO.findByEmail(account.getEmail());

            // Generating auth token
            Token token = TokenUtil.generateToken();

            AuthEntity entity = new AuthEntity();
            entity.setEmail(account.getEmail());
            entity.setToken(token.getToken());
            entity.setExpirationDate(token.getExpires());

            // If not, create one
            if (authEntity == null) {
                authDAO.create(entity);
            }

            authDAO.closeCurrentSessionWithTransaction();
            log.debug(String.format("Auth token %s for account %s.", token, account));

            return token.getToken();
        } catch (DAOException ex) {
            String msg = "Can't retrieve auth token for user";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public void logout(AccountBean account) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }

        try {
            authDAO.openCurrentSessionWithTransaction();
            authDAO.deleteByEmail(account.getEmail());
            authDAO.closeCurrentSessionWithTransaction();
        } catch (DAOException ex) {
            String msg = "Can't delete auth token for user";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public boolean isAuthenticated(AccountBean account) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }

        try {
            authDAO.openCurrentSessionWithTransaction();
            AuthEntity entity = authDAO.findByEmail(account.getEmail());
            authDAO.closeCurrentSessionWithTransaction();

            // If token exists and date was not expired then ok
            return entity.getExpirationDate().after(Calendar.getInstance());
        } catch (DAOException ex) {
            String msg = "Can't verify auth token for user";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }
}
