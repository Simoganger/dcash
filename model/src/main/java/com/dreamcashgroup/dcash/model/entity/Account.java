package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumAccountType;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Account extends Model{

    protected String title;

    @Column(length = 20)
    protected String number;

    protected double balance;

    @Enumerated(EnumType.STRING)
    protected EnumAccountType type;

    @ManyToOne(targetEntity = Customer.class)
    protected Customer owner;

    protected boolean active = true;
    protected boolean blocked = false;

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

    public EnumAccountType getType() {
        return type;
    }

    public void setType(EnumAccountType type) {
        this.type = type;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}
