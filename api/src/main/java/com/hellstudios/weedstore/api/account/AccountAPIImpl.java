package com.hellstudios.weedstore.api.account;

import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.core.persistence.DAOException;
import com.hellstudios.weedstore.core.persistence.account.AccountDAO;
import com.hellstudios.weedstore.core.persistence.account.AccountEntity;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
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


    @Override
    public void init() {
        accountDAO = new AccountDAO();
    }

    @Override
    public void deInit() {

    }

    @Override
    public boolean login(String email, String password) throws APIException {
        if ("".equals(email) || "".equals(password)) {
            throw new APIException("Parameters are empty.");
        }

        AccountBean account = getAccountByEmail(email);

        return account != null && account.getPassword().equals(password);
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
        } catch (DAOException ex) {
            String msg = "Can't save account in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public AccountBean getAccountById(String id) throws APIException {
        try {
            accountDAO.openCurrentSessionWithTransaction();
            AccountEntity entity = accountDAO.findById(id);
            accountDAO.closeCurrentSessionWithTransaction();

            return new AccountBean(entity);
        } catch (DAOException ex) {
            String msg = "Can't get account by id from DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public AccountBean getAccountByEmail(String email) throws APIException {
        try {
            accountDAO.openCurrentSessionWithTransaction();
            AccountEntity entity = accountDAO.findByEmail(email);
            accountDAO.closeCurrentSessionWithTransaction();

            return entity != null ? new AccountBean(entity) : null;
        } catch (DAOException ex) {
            String msg = "Can't get account by email from DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    public List<AccountBean> getAllAccounts() throws APIException {
        List<AccountBean> accountBeans = new ArrayList<AccountBean>();

        accountDAO.openCurrentSessionWithTransaction();
        List<AccountEntity> entities = accountDAO.findAll();
        accountDAO.closeCurrentSessionWithTransaction();

        for (AccountEntity entity : entities) {
            accountBeans.add(new AccountBean(entity));
        }

        return accountBeans;
    }
}
