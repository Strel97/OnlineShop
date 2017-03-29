package com.hellstudios.weedstore.api.balance;

import com.hellstudios.weedstore.api.account.AccountBean;
import com.hellstudios.weedstore.core.persistence.balance.BalanceEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author strel
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BalanceBean {

    private String id;
    private int money;
    private boolean blocked;
    private AccountBean owner;


    public BalanceBean() {
    }

    public BalanceBean(BalanceEntity balanceEntity) {
        if (balanceEntity == null) {
            throw new IllegalArgumentException("Given entity object is null!");
        }

        this.id = balanceEntity.getId();
        this.money = balanceEntity.getMoney();
        this.blocked = balanceEntity.getBlocked();
        this.owner = new AccountBean(balanceEntity.getOwner());
    }

    public BalanceBean(int money, boolean blocked, AccountBean owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Balance owner can't be null!");
        }

        this.money = money;
        this.blocked = blocked;
        this.owner = owner;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public AccountBean getOwner() {
        return owner;
    }

    public void setOwner(AccountBean owner) {
        this.owner = owner;
    }


    public BalanceEntity toEntity() {
        if (owner == null) {
            throw new IllegalArgumentException("Can't create entity, balance owner is null!");
        }

        BalanceEntity entity = new BalanceEntity();
        entity.setId(id);
        entity.setMoney(money);
        entity.setBlocked(blocked);
        entity.setOwner(owner.toEntity());
        return entity;
    }

    @Override
    public String toString() {
        return "[ " +
                "id=" + id +
                ", money=" + money +
                ", blocked=" + blocked +
                " ]";
    }
}
