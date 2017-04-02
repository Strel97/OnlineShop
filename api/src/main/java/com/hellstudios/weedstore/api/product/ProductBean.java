package com.hellstudios.weedstore.api.product;

import com.hellstudios.weedstore.api.manufacturer.ManufacturerBean;
import com.hellstudios.weedstore.api.store.StoreBean;
import com.hellstudios.weedstore.core.persistence.account.AccountEntity;
import com.hellstudios.weedstore.core.persistence.manufacturer.ManufacturerEntity;
import com.hellstudios.weedstore.core.persistence.product.ProductEntity;
import com.hellstudios.weedstore.core.persistence.store.StoreEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author strel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBean implements Serializable {

    private String id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String imgName;
    private ManufacturerBean manufacturer;
    private StoreBean store;


    public ProductBean() {
    }

    public ProductBean(ProductEntity productEntity) {
        if (productEntity == null) {
            throw new IllegalArgumentException("Given entity object is null!");
        }

        this.id = productEntity.getId();
        this.name = productEntity.getName();
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        this.quantity = productEntity.getQuantity();
        this.imgName = productEntity.getImgName();
        this.manufacturer = new ManufacturerBean(productEntity.getManufacturer());
        this.store = new StoreBean(productEntity.getStore());
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
    }

    public StoreBean getStore() {
        return store;
    }

    public void setStore(StoreBean store) {
        this.store = store;
    }

    public ProductEntity toEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setDescription(description);
        entity.setImgName(imgName);
        entity.setPrice(price);
        entity.setQuantity(quantity);
        entity.setManufacturer(manufacturer.toEntity());
        entity.setStore(store.toEntity());
        return entity;
    }

    @Override
    public String toString() {
        return "[ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", imgName='" + imgName + '\'' +
                ", manufacturer=" + manufacturer.getId() +
                ", store=" + store.getId() +
                " ]";
    }
}
