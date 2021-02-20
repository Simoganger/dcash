package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumTransactionType;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Transactions extends Model{

    @Enumerated(EnumType.STRING)
    protected EnumTransactionType type;

    protected boolean bonusCounted;

    public abstract EnumTransactionType getType();

    public void setType(EnumTransactionType type) {
        this.type = type;
    }

    public boolean isBonusCounted() {
        return bonusCounted;
    }

    public void setBonusCounted(boolean bonusCounted) {
        this.bonusCounted = bonusCounted;
    }
}
