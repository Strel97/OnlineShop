package com.hellstudios.dev.core.persistence.balance;

import com.hellstudios.dev.core.persistence.account.AccountEntity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * @author strel
 */
@Entity
@Table(name = "balances", schema = "online-store", catalog = "")
public class BalanceEntity {

    private String id;
    private int money;
    private boolean blocked;
    private AccountEntity owner;


    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "money", nullable = false)
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Basic
    @Column(name = "blocked")
    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    public AccountEntity getOwner() {
        return owner;
    }

    public void setOwner(AccountEntity owner) {
        this.owner = owner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceEntity that = (BalanceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (money != that.money) return false;
        if (blocked != that.blocked) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.hashCode() : 0;
        result = 31 * result + money;
        result = 31 * result + (blocked ? 1 : 0);
        return result;
    }
}
