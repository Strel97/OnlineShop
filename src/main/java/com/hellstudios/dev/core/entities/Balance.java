package com.hellstudios.dev.core.entities;

/**
 * @author strel
 */
public class Balance {

    private Account account;
    private int     money;


    public Balance(Account account, int money) {
        this.account = account;
        this.money = money;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
