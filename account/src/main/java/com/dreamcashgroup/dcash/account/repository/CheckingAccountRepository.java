package com.dreamcashgroup.dcash.account.repository;

import com.dreamcashgroup.dcash.model.entity.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, String> {
}
