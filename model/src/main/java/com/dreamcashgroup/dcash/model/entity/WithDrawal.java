package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumTransactionType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class WithDrawal extends Transactions{

    @ManyToOne(targetEntity = Account.class)
    private Account account;

    private double amount;

    @Override
    public EnumTransactionType getType() {
        return EnumTransactionType.WITHDRAWAL;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
