package com.dreamcashgroup.dcash.user.service;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemAlreadyExistException;
import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.model.entity.Users;

import java.util.Optional;

public interface UserService {

    /**
     * Créer un compte utilisateur
     * @param username
     * @param password
     * @return
     */
    Users create(String username, String password) throws DCashDBItemAlreadyExistException;
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
     * Retrouver un utilisateur (existe ou pas) suivant son id
     * @param id
     * @return
     */
    Optional<Users> getById(String id);

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
