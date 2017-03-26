package com.hellstudios.dev.core.persistence.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * @author strel
 */
@Entity
@Table(name = "purchases", schema = "online-store", catalog = "")
public class PurchaseEntity {

    private int id;
    private Timestamp date;
    private ProductEntity product;
    private AccountEntity customerAccount;


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
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseEntity that = (PurchaseEntity) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public AccountEntity getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(AccountEntity customerAccount) {
        this.customerAccount = customerAccount;
    }
}
