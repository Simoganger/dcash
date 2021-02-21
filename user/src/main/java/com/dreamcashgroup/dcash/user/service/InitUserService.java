package com.dreamcashgroup.dcash.user.service;

import com.dreamcashgroup.dcash.model.entity.Users;

public interface InitUserService {

    /**
     * Initialiser le compte administrateur du système au démarrage du service utilisateur
     * @return
     */
    Users initAdminAccount();
}
