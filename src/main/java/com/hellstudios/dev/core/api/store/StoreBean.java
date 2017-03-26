package com.hellstudios.dev.core.api.store;

import com.hellstudios.dev.core.api.account.AccountBean;
import com.hellstudios.dev.core.persistence.store.StoreEntity;

/**
 * @author strel
 */
public class StoreBean {

    private String id;
    private String name;
    private String description;
    private AccountBean owner;


    public StoreBean() {
    }

    public StoreBean(StoreEntity storeEntity) {
        if (storeEntity == null) {
            throw new IllegalArgumentException("Given store entity is null!");
        }

        this.id = storeEntity.getId();
        this.name = storeEntity.getName();
        this.description = storeEntity.getDescription();
        this.owner = new AccountBean(storeEntity.getOwner());
    }

    public StoreBean(String name, String description, String originCountry, AccountBean owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Store owner can't be null!");
        }

        this.name = name;
        this.description = description;
        this.owner = owner;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountBean getOwner() {
        return owner;
    }

    public void setOwner(AccountBean owner) {
        this.owner = owner;
    }


    public StoreEntity toEntity() {
        if (owner == null) {
            throw new IllegalArgumentException("Can't create entity, store owner is null!");
        }

        StoreEntity entity = new StoreEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setDescription(description);
        entity.setOwner(owner.toEntity());
        return entity;
    }

    @Override
    public String toString() {
        return "[ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner.getId() +
                " ]";
    }
}
