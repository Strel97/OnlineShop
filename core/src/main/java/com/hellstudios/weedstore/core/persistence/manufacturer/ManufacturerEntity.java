package com.hellstudios.weedstore.core.persistence.manufacturer;

import com.hellstudios.weedstore.core.persistence.account.AccountEntity;
import com.hellstudios.weedstore.core.persistence.product.ProductEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author strel
 */
@Entity
@Table(name = "manufacturers", schema = "online-store", catalog = "")
public class ManufacturerEntity {

    private String id;
    private String name;
    private String description;
    private String originCountry;
    private String image;
    private AccountEntity owner;
    private Set<ProductEntity> products = new HashSet<ProductEntity>();


    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    @Type(type = "text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "origin_country", length = 45)
    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManufacturerEntity that = (ManufacturerEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (originCountry != null ? !originCountry.equals(that.originCountry) : that.originCountry != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (originCountry != null ? originCountry.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public AccountEntity getOwner() {
        return owner;
    }

    public void setOwner(AccountEntity owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ProductEntity> getProducts() {
        return this.products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}
