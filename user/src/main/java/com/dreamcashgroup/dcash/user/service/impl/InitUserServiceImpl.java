package com.dreamcashgroup.dcash.user.service.impl;

import com.dreamcashgroup.dcash.model.entity.Roles;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.repository.RoleRepository;
import com.dreamcashgroup.dcash.user.repository.UserRepository;
import com.dreamcashgroup.dcash.user.service.InitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InitUserServiceImpl implements InitUserService {

    @Value("${app.init.admin-username}")
    private String adminUsername;

    @Value("${app.init.admin-password}")
    private String adminPassword;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * Initialiser le compte administrateur du système au démarrage du service utilisateur
     *
     * @return
     */
    @Override
    public Users initAdminAccount() {
        Optional<Users> userOptional = userRepository.findByUsername(adminUsername);

        // Cas où l'administrateur est déjà initialisé
        if(userOptional.isPresent()){
            return userOptional.get();
        }else{ // Sinon on initialise un compte administrateur du système

            // Créer l'administrateur
            Users admin = new Users();
            admin.setUsername(adminUsername);
            admin.setPassword(encoder.encode(adminPassword));
            admin.setActive(true);

            // Lui ajouter le rôle d'administration
            Optional<Roles> adminRole = roleRepository.findById("ADMIN");
            adminRole.ifPresent(role -> admin.addRole(role));

            // Sauvegarder le compte administrateur
            return userRepository.save(admin);
        }
    }
}
