package com.dreamcashgroup.dcash.account.service.impl;

import com.dreamcashgroup.dcash.account.dto.CheckingAccountDto;
import com.dreamcashgroup.dcash.account.dto.SavingAccountDto;
import com.dreamcashgroup.dcash.account.repository.CheckingAccountRepository;
import com.dreamcashgroup.dcash.account.repository.SavingAccountRepository;
import com.dreamcashgroup.dcash.account.service.AccountService;
import com.dreamcashgroup.dcash.model.entity.CheckingAccount;
import com.dreamcashgroup.dcash.model.entity.SavingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private SavingAccountRepository savingAccountRepository;

    /**
     * Créer un compte chèque
     *
     * @param checkingAccountDto
     * @return
     */
    @Override
    public CheckingAccount createCheckingAccount(CheckingAccountDto checkingAccountDto) {
        return null;
    }

    /**
     * Créer un compte d'épargne
     *
     * @param savingAccountDto
     * @return
     */
    @Override
    public SavingAccount createSavingAccount(SavingAccountDto savingAccountDto) {
        return null;
    }

    /**
     * Enregistrer un compte chèque
     *
     * @param checkingAccount
     * @return
     */
    @Override
    public CheckingAccount saveCheckingAccount(CheckingAccount checkingAccount) {
        return checkingAccountRepository.save(checkingAccount);
    }

    /**
     * Enregistrer un compte d'épargne
     *
     * @param savingAccount
     * @return
     */
    @Override
    public SavingAccount saveSavingAccount(SavingAccount savingAccount) {
        return savingAccountRepository.save(savingAccount);
    }
}
