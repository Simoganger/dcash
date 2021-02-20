package com.dreamcashgroup.dcash.user.service;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.model.entity.Users;

public interface UserService {
    /**
     * Enregistrer un utilisateur
     * @param user
     * @return
     */
    Users save(Users user);

    /**
     * Retrouver un utilisateur à partir de son identifiant
     * @param id
     * @return
     * @throws DCashDBItemNotFoundException
     */
    Users findById(String id) throws DCashDBItemNotFoundException;

    /**
     * Mettre à jour un utilisateur
     * @param id
     * @param user
     * @return
     * @throws DCashDBItemNotFoundException
     */
    Users update(String id, Users user) throws DCashDBItemNotFoundException;

    /**
     * Supprimer un utilisateur
     * @param id
     * @throws DCashDBItemNotFoundException
     */
    void delete(String id) throws DCashDBItemNotFoundException;
}
