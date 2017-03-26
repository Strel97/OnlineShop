package com.hellstudios.dev.core.persistence.entities;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * @author strel
 */
@Entity
@Table(name = "balances", schema = "online-store", catalog = "")
public class BalanceEntity {

    private int id;
    private int money;
    private boolean blocked;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceEntity that = (BalanceEntity) o;

        if (id != that.id) return false;
        if (money != that.money) return false;
        if (blocked != that.blocked) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + money;
        result = 31 * result + (blocked ? 1 : 0);
        return result;
    }
}
