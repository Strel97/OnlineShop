package com.hellstudios.dev.core.api.account;

import com.hellstudios.dev.core.persistence.account.AccountEntity;

import java.io.Serializable;

/**
 * @author strel
 */
public class AccountBean implements Serializable {

    private String id;
    private String name;
    private String password;
    private String email;


    public AccountBean() {
    }

    public AccountBean(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public AccountBean(AccountEntity accountEntity) {
        if (accountEntity == null) {
            throw new IllegalArgumentException("Given entity object is null!");
        }

        this.id = accountEntity.getId();
        this.name = accountEntity.getName();
        this.password = accountEntity.getPassword();
        this.email = accountEntity.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public AccountEntity toEntity() {
        AccountEntity entity = new AccountEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setEmail(email);
        entity.setPassword(password);
        return entity;
    }

    @Override
    public String toString() {
        return "[ " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                " ]";
    }
}
