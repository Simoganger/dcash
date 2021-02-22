package com.dreamcashgroup.dcash.account.dto;

import javax.validation.constraints.NotBlank;

public class AccountDto {
    @NotBlank
    private String title;

    private String number;

    @NotBlank
    private String type;

    @NotBlank
    private String ownerId;
    private String savingPeriodCronExpression;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getSavingPeriodCronExpression() {
        return savingPeriodCronExpression;
    }

    public void setSavingPeriodCronExpression(String savingPeriodCronExpression) {
        this.savingPeriodCronExpression = savingPeriodCronExpression;
    }
}
