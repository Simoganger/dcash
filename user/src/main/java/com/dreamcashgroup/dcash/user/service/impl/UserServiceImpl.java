package com.dreamcashgroup.dcash.user.service.impl;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemAlreadyExistException;
import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.common.exception.EnumErrorCode;
import com.dreamcashgroup.dcash.model.entity.Customer;
import com.dreamcashgroup.dcash.model.entity.Roles;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.repository.RoleRepository;
import com.dreamcashgroup.dcash.user.repository.UserRepository;
import com.dreamcashgroup.dcash.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * Créer un compte utilisateur
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Users create(String username, String password) throws DCashDBItemAlreadyExistException {
        Optional<Users> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            throw new DCashDBItemAlreadyExistException(EnumErrorCode.ERROR_DB_ITEM_ALREADY_EXIST, Users.class.getSimpleName(), "username", username);
        }else{
            Users user = new Users();
            user.setUsername(username);
            user.setPassword(encoder.encode(password));
            user.setActive(true);

            // Lui ajouter le rôle d'utilisateur
            Optional<Roles> userRole = roleRepository.findById("USER");
            userRole.ifPresent(role -> user.addRole(role));
            return userRepository.save(user);
        }
    }

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

    /**
     * Retrouver un utilisateur (existe ou pas) suivant son id
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Users> getById(String id) {
        return userRepository.findById(id);
    }
}
