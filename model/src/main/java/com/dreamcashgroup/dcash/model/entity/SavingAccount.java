package com.dreamcashgroup.dcash.model.entity;

import javax.persistence.Entity;

@Entity
public class SavingAccount extends Account{

    private String savingPeriodCronExpression;

    public String getSavingPeriodCronExpression() {
        return savingPeriodCronExpression;
    }

    public void setSavingPeriodCronExpression(String savingPeriodCronExpression) {
        this.savingPeriodCronExpression = savingPeriodCronExpression;
    }
}
