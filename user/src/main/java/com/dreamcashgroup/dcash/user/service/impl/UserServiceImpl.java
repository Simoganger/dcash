package com.dreamcashgroup.dcash.user.service.impl;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.common.exception.EnumErrorCode;
import com.dreamcashgroup.dcash.model.entity.Customer;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.repository.UserRepository;
import com.dreamcashgroup.dcash.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Enregistrer un utilisateur
     *
     * @param user
     * @return
     */
    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    /**
     * Retrouver un utilisateur à partir de son identifiant
     *
     * @param id
     * @return
     * @throws DCashDBItemNotFoundException
     */
    @Override
    public Users findById(String id) throws DCashDBItemNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(()-> new DCashDBItemNotFoundException(EnumErrorCode.ERROR_DB_ITEM_NOTFOUND, Users.class.getSimpleName(), "id", id));

    }

    /**
     * Mettre à jour un utilisateur
     *
     * @param id
     * @param user
     * @return
     * @throws DCashDBItemNotFoundException
     */
    @Override
    public Users update(String id, Users user) throws DCashDBItemNotFoundException {
        // TODO
        return null;
    }

    /**
     * Supprimer un utilisateur
     *
     * @param id
     * @throws DCashDBItemNotFoundException
     */
    @Override
    public void delete(String id) throws DCashDBItemNotFoundException {
        // TODO
    }
}
