package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumTokenStatus;
import com.dreamcashgroup.dcash.model.enums.EnumTokenType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Token extends Model{

    @Column(length = 10)
    private String code;

    @Enumerated(EnumType.STRING)
    private EnumTokenType type;

    @Enumerated(EnumType.STRING)
    private EnumTokenStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expireAt;

    @OneToOne(targetEntity = Users.class)
    private Users user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EnumTokenType getType() {
        return type;
    }

    public void setType(EnumTokenType type) {
        this.type = type;
    }

    public EnumTokenStatus getStatus() {
        return status;
    }

    public void setStatus(EnumTokenStatus status) {
        this.status = status;
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
