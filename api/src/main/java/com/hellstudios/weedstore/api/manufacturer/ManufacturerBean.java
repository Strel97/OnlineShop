package com.hellstudios.weedstore.api.manufacturer;

import com.hellstudios.weedstore.api.account.AccountBean;
import com.hellstudios.weedstore.core.persistence.manufacturer.ManufacturerEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author strel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ManufacturerBean {

    private String id;
    private String name;
    private String description;
    private String originCountry;
    private String image;
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
        this.image = manufacturerEntity.getImage();
        this.owner = new AccountBean(manufacturerEntity.getOwner());
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ManufacturerEntity toEntity() {
        if (owner == null) {
            throw new IllegalArgumentException("Can't create entity, manufacturer account is null!");
        }

        ManufacturerEntity entity = new ManufacturerEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setDescription(description);
        entity.setOriginCountry(originCountry);
        entity.setImage(image);
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
                ", image='" + image + '\'' +
                ", owner=" + owner.getId() +
                " ]";
    }
}
