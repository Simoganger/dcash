package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumHistoryType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AccountHistory extends History{

    private String title;

    @Column(length = 20)
    private String number;

    private double balance;

    @Override
    protected EnumHistoryType getType() {
        return EnumHistoryType.ACCOUNT_UPDATE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
