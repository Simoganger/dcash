package com.dreamcashgroup.dcash.user.service;

import com.dreamcashgroup.dcash.model.entity.Users;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface AuthService {

    /**
     * Authentifier un utilisateur
     * @param login
     * @param password
     * @return
     */
    Optional<Authentication> authenticateUser(String login, String password);

    /**
     * Générer un code jwt d'authentification
     * @param authentication
     * @return
     */
    String generateJwtToken(Authentication authentication);

    /**
     * Vérifier le code de double authentification
     * @param code
     * @return
     */
    Optional<Users> processCodeVerification(String code);

    /**
     * Vérifier si une seconde authentification est nécessaire
     * @param userId
     * @return
     */
    boolean verifySecondLoginRequirement(String userId);
}
