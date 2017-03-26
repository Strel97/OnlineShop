package com.hellstudios.dev.core.api.account;

import com.hellstudios.dev.core.api.balance.BalanceBean;
import com.hellstudios.dev.core.persistence.entities.AccountEntity;

/**
 * @author strel
 */
public class AccountBean {

    private int id;
    private String name;
    private String password;
    private String email;
    private BalanceBean balance;


    public AccountBean() {
    }

    public AccountBean(int id, String name, String password, String email, BalanceBean balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public AccountBean(AccountEntity accountEntity) {
        if (accountEntity == null) {
            throw new IllegalArgumentException("Given entity object is null!");
        }

        this.id = accountEntity.getId();
        this.name = accountEntity.getName();
        this.password = accountEntity.getPassword();
        this.email = accountEntity.getEmail();
        this.balance = new BalanceBean(accountEntity.getBalance());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BalanceBean getBalance() {
        return balance;
    }

    public void setBalance(BalanceBean balance) {
        this.balance = balance;
    }
}
