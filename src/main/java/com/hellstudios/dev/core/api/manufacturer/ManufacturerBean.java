package com.hellstudios.dev.core.api.manufacturer;

import com.hellstudios.dev.core.api.account.AccountBean;
import com.hellstudios.dev.core.persistence.manufacturer.ManufacturerEntity;

/**
 * @author strel
 */
public class ManufacturerBean {

    private String id;
    private String name;
    private String description;
    private String originCountry;
    private AccountBean owner;


    public ManufacturerBean() {
    }

    public ManufacturerBean(ManufacturerEntity manufacturerEntity) {
        if (manufacturerEntity == null) {
            throw new IllegalArgumentException("Given manufacturer entity is null!");
        }

        this.id = manufacturerEntity.getId();
        this.name = manufacturerEntity.getName();
        this.description = manufacturerEntity.getDescription();
        this.originCountry = manufacturerEntity.getOriginCountry();
        this.owner = new AccountBean(manufacturerEntity.getOwner());
    }

    public ManufacturerBean(String name, String description, String originCountry, AccountBean owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Balance owner can't be null!");
        }

        this.name = name;
        this.description = description;
        this.originCountry = originCountry;
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

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public AccountBean getOwner() {
        return owner;
    }

    public void setOwner(AccountBean owner) {
        this.owner = owner;
    }


    public ManufacturerEntity toEntity() {
        if (owner == null) {
            throw new IllegalArgumentException("Can't create entity, manufacturer owner is null!");
        }

        ManufacturerEntity entity = new ManufacturerEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setDescription(description);
        entity.setOriginCountry(originCountry);
        entity.setOwner(owner.toEntity());
        return entity;
    }

    @Override
    public String toString() {
        return "[ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", owner=" + owner.getId() +
                " ]";
    }
}
