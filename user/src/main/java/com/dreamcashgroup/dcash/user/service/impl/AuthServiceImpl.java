package com.dreamcashgroup.dcash.user.service.impl;

import com.dreamcashgroup.dcash.common.exception.ResourceNotFoundException;
import com.dreamcashgroup.dcash.common.security.jwt.JwtTokenProvider;
import com.dreamcashgroup.dcash.model.entity.Token;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.repository.TokenRepository;
import com.dreamcashgroup.dcash.user.repository.UserRepository;
import com.dreamcashgroup.dcash.user.service.AuthService;
import com.dreamcashgroup.dcash.user.service.TokenService;
import com.dreamcashgroup.dcash.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    /**
     * Authentifier un utilisateur
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Optional<Authentication> authenticateUser(String username, String password) {
        return Optional.ofNullable(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                password)));
    }

    /**
     * Générer un code jwt d'authentification
     *
     * @param authentication
     * @return
     */
    @Override
    public String generateJwtToken(Authentication authentication) {
        return jwtTokenProvider.generateJwtToken(authentication);
    }

    /**
     * Vérifier le code de double authentification
     * @param code
     * @return
     */
    @Override
    public Optional<Users> processCodeVerification(String code) {
        Optional<Token> codeVerificationTokenOpt = tokenService.getByCode(code);
        codeVerificationTokenOpt.orElseThrow(() ->
                new ResourceNotFoundException("Token", "Code verification", code));

        Optional<Users> loggedInUserOpt = codeVerificationTokenOpt.map(Token::getUser);

        codeVerificationTokenOpt.ifPresent(tokenService::verifyCodeExpiration);
        codeVerificationTokenOpt.ifPresent(Token::setVerified);
        codeVerificationTokenOpt.ifPresent(tokenService::save);

        return loggedInUserOpt;
    }

    /**
     * Vérifier si une seconde authentification est nécessaire
     *
     * @param userId
     * @return
     */
    @Override
    public boolean verifySecondLoginRequirement(String userId) {
        Optional<Users> userOptional = userService.getById(userId);
       /* if(userOptional.isPresent() && userOptional.get().isAdmin()){
            return false;
        }else{
            return true;
        }*/
       return false;
    }
}
