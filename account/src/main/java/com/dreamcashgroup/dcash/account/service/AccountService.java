package com.dreamcashgroup.dcash.account.service;

import com.dreamcashgroup.dcash.account.dto.AccountDto;
import com.dreamcashgroup.dcash.account.dto.CheckingAccountDto;
import com.dreamcashgroup.dcash.account.dto.SavingAccountDto;
import com.dreamcashgroup.dcash.model.entity.CheckingAccount;
import com.dreamcashgroup.dcash.model.entity.SavingAccount;

public interface AccountService {

    /**
     * Créer un compte chèque
     * @param accountDto
     * @return
     */
    CheckingAccount createCheckingAccount(AccountDto accountDto);

    /**
     * Créer un compte d'épargne
     * @param accountDto
     * @return
     */
    SavingAccount createSavingAccount(AccountDto accountDto);

    /**
     * Enregistrer un compte chèque
     * @param checkingAccount
     * @return
     */
    CheckingAccount saveCheckingAccount(CheckingAccount checkingAccount);

    /**
     * Enregistrer un compte d'épargne
     * @param savingAccount
     * @return
     */
    SavingAccount saveSavingAccount(SavingAccount savingAccount);

}
