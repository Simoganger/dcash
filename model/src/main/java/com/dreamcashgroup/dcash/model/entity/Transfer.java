package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumTransactionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transfer extends Transactions {

    private double amount;

    @Column(length = 20)
    private String accountNumber;

    @ManyToOne(targetEntity = CheckingAccount.class)
    private CheckingAccount account;

    @OneToOne(targetEntity = Account.class)
    private Account targetAccount;

    @Column(columnDefinition = "TEXT")
    private String transferCode;

    @Override
    public EnumTransactionType getType() {
        return EnumTransactionType.TRANSFER;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CheckingAccount getAccount() {
        return account;
    }

    public void setAccount(CheckingAccount account) {
        this.account = account;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }
}
