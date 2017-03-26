package com.hellstudios.dev.core.persistence.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * @author strel
 */
@Entity
@Table(name = "stores", schema = "online-store", catalog = "")
public class StoreEntity {

    private int id;
    private String name;
    private String description;
    private AccountEntity owner;
    private Set<ProductEntity> products = new HashSet<ProductEntity>();


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreEntity that = (StoreEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public AccountEntity getOwner() {
        return owner;
    }

    public void setOwner(AccountEntity ownerAccount) {
        this.owner = ownerAccount;
    }

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ProductEntity> getProducts() {
        return this.products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}
