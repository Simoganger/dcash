package com.dreamcashgroup.dcash.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CheckingAccount extends Account{

    private double loanCap;

    @OneToOne(targetEntity = MobileAccount.class)
    private MobileAccount mobileAccount;

    public double getLoanCap() {
        return loanCap;
    }

    public void setLoanCap(double loanCap) {
        this.loanCap = loanCap;
    }

    public MobileAccount getMobileAccount() {
        return mobileAccount;
    }

    public void setMobileAccount(MobileAccount mobileAccount) {
        this.mobileAccount = mobileAccount;
    }
}
