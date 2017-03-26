package com.hellstudios.dev.core.api.account;

import com.hellstudios.dev.core.api.APIException;
import com.hellstudios.dev.core.persistence.dao.AccountDAO;
import com.hellstudios.dev.core.persistence.dao.DAOException;
import com.hellstudios.dev.core.persistence.entities.AccountEntity;
import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * @author strel
 */
public class AccountAPIImpl implements AccountAPI {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(AccountAPIImpl.class.getName());

    /**
     * {@link AccountDAO} instance.
     */
    private AccountDAO accountDAO;


    public AccountAPIImpl() {
        accountDAO = new AccountDAO();
    }


    @Override
    public void createAccount(AccountBean account) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }

        try {
            // Generating UUID for id
            account.setId(UUID.randomUUID().toString());

            accountDAO.openCurrentSessionWithTransaction();
            accountDAO.create(account.toEntity());
            accountDAO.closeCurrentSessionWithTransaction();

            log.debug(String.format("Created account %s.", account));
        }
        catch (DAOException ex) {
            String msg = "Can't save account in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public AccountBean getAccountById(String id) throws APIException {
        try {
            accountDAO.openCurrentSessionWithTransaction();
            AccountEntity entity = accountDAO.findById( id );
            accountDAO.closeCurrentSessionWithTransaction();

            return new AccountBean(entity);
        }
        catch (DAOException ex) {
            String msg = "Can't get account by id from DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public AccountBean getAccountByEmail(String email) throws APIException {
        try {
            accountDAO.openCurrentSessionWithTransaction();
            AccountEntity entity = accountDAO.findByProperty( "owner_id", email );
            accountDAO.closeCurrentSessionWithTransaction();

            return new AccountBean(entity);
        }
        catch (DAOException ex) {
            String msg = "Can't get account by email from DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }
}
