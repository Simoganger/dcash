package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumMobileProvider;

import javax.persistence.*;

@Entity
public class MobileAccount extends Model{

    @Column(length = 20)
    private String phone;
    private String verificationCode;

    @Enumerated(EnumType.STRING)
    private EnumMobileProvider provider;

    @OneToOne(targetEntity = Customer.class)
    private Customer owner;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public EnumMobileProvider getProvider() {
        return provider;
    }

    public void setProvider(EnumMobileProvider provider) {
        this.provider = provider;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
