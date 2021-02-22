package com.dreamcashgroup.dcash.account.repository;

import com.dreamcashgroup.dcash.model.entity.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, String> {
}
