package com.hellstudios.dev.core.api.balance;

import com.hellstudios.dev.core.persistence.entities.BalanceEntity;

/**
 * @author strel
 */
public class BalanceBean {

    private int id;
    private int money;
    private boolean blocked;


    public BalanceBean() {
    }

    public BalanceBean(BalanceEntity balanceEntity) {
        if (balanceEntity == null) {
            throw new IllegalArgumentException("Given entity object is null!");
        }

        this.id = balanceEntity.getId();
        this.money = balanceEntity.getMoney();
        this.blocked = balanceEntity.getBlocked();
    }

    public BalanceBean(int id, int money, boolean blocked) {
        this.id = id;
        this.money = money;
        this.blocked = blocked;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
