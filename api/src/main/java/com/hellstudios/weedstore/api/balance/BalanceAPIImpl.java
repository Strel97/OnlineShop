package com.hellstudios.weedstore.api.balance;

import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountBean;
import com.hellstudios.weedstore.core.persistence.DAOException;
import com.hellstudios.weedstore.core.persistence.balance.BalanceDAO;
import com.hellstudios.weedstore.core.persistence.balance.BalanceEntity;
import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * @author strel
 */
public class BalanceAPIImpl implements BalanceAPI {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(BalanceAPIImpl.class.getName());

    /**
     * {@link BalanceDAO} instance.
     */
    private BalanceDAO balanceDAO;


    public BalanceAPIImpl() {
        balanceDAO = new BalanceDAO();
    }


    @Override
    public void createBalance(AccountBean account) throws APIException {
        if (account == null) {
            throw new APIException("Can't create balance for null user.");
        }

        try {
            BalanceBean balanceBean = new BalanceBean(0, false, account);
            balanceBean.setId(UUID.randomUUID().toString());

            balanceDAO.openCurrentSessionWithTransaction();
            balanceDAO.create(balanceBean.toEntity());
            balanceDAO.closeCurrentSessionWithTransaction();

            log.debug(String.format("Created empty balance account for user %s.", account));
        }
        catch (DAOException ex) {
            String msg = "Can't save balance in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public void createBalance(BalanceBean bean) throws APIException {
        if (bean == null) {
            throw new APIException("Given balance bean object is null.");
        }

        try {
            bean.setId(UUID.randomUUID().toString());

            balanceDAO.openCurrentSessionWithTransaction();
            balanceDAO.create(bean.toEntity());
            balanceDAO.closeCurrentSessionWithTransaction();

            log.debug(String.format("Created balance account %s for user %s.", bean, bean.getOwner()));
        }
        catch (DAOException ex) {
            String msg = "Can't save balance in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public boolean checkBalance(AccountBean account, int money) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }
        if (money < 0) {
            throw new APIException("Can't check balance for negative money amount.");
        }

        BalanceBean balance = getBalance(account);
        return checkBalance(balance, money);
    }

    @Override
    public void withdraw(AccountBean account, int money) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }
        if (money < 0) {
            throw new APIException("Can't withdraw negative amount from account.");
        }

        try {
            BalanceBean balance = getBalance(account);
            if (checkBalance(balance, money)) {
                balance.setMoney(balance.getMoney() - money);

                balanceDAO.openCurrentSessionWithTransaction();
                balanceDAO.update(balance.toEntity());
                balanceDAO.closeCurrentSessionWithTransaction();

                log.debug(String.format("Withdrawing %d cash from user account %s.", money, account));
            }
        }
        catch (DAOException ex) {
            String msg = String.format("Can't withdraw money from balance for account %s", account);
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public void replenish(AccountBean account, int money) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }
        if (money < 0) {
            throw new APIException("Can't replenish negative amount for account.");
        }

        try {
            BalanceBean balance = getBalance(account);
            if (checkBalance(balance)) {
                balance.setMoney(balance.getMoney() + money);

                balanceDAO.openCurrentSessionWithTransaction();
                balanceDAO.update(balance.toEntity());
                balanceDAO.closeCurrentSessionWithTransaction();

                log.debug(String.format("Replenishing %d cash for user account %s.", money, account));
            }
        }
        catch (DAOException ex) {
            String msg = String.format("Can't replenish money to balance for account %s", account);
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    private boolean checkBalance(BalanceBean balance, int money) {
        return balance != null && !balance.isBlocked() && balance.getMoney() >= money;
    }

    private boolean checkBalance(BalanceBean balance) {
        return balance != null && !balance.isBlocked();
    }

    private BalanceBean getBalance(AccountBean account) throws APIException {
        if (account == null) {
            throw new APIException("Given account bean is null.");
        }

        try {
            balanceDAO.openCurrentSessionWithTransaction();
            BalanceEntity entity = balanceDAO.findByOwner( account.toEntity() );
            balanceDAO.closeCurrentSessionWithTransaction();

            return new BalanceBean(entity);
        }
        catch (DAOException ex) {
            String msg = String.format("Can't get balance for account %s", account);
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }
}
