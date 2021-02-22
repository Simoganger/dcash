package com.dreamcashgroup.dcash.account.service;

import com.dreamcashgroup.dcash.account.dto.CheckingAccountDto;
import com.dreamcashgroup.dcash.account.dto.SavingAccountDto;
import com.dreamcashgroup.dcash.model.entity.CheckingAccount;
import com.dreamcashgroup.dcash.model.entity.SavingAccount;

public interface AccountService {

    /**
     * Créer un compte chèque
     * @param checkingAccountDto
     * @return
     */
    CheckingAccount createCheckingAccount(CheckingAccountDto checkingAccountDto);

    /**
     * Créer un compte d'épargne
     * @param savingAccountDto
     * @return
     */
    SavingAccount createSavingAccount(SavingAccountDto savingAccountDto);

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
