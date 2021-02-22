package com.dreamcashgroup.dcash.user.service.impl;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.common.exception.InvalidTokenRequestException;
import com.dreamcashgroup.dcash.model.entity.Token;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.model.enums.EnumTokenStatus;
import com.dreamcashgroup.dcash.model.enums.EnumTokenType;
import com.dreamcashgroup.dcash.user.repository.TokenRepository;
import com.dreamcashgroup.dcash.user.service.TokenService;
import com.dreamcashgroup.dcash.user.service.UserService;
import com.dreamcashgroup.dcash.user.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${app.token.login-code-duration}")
    private String loginCodeDuration;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenRepository tokenRepository;

    /**
     * Retrouver un token suivant son identifiant
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Token> getById(String id) {
        return tokenRepository.findById(id);
    }

    /**
     * Retrouver un token à partir de son code
     *
     * @param code
     * @return
     */
    @Override
    public Optional<Token> getByCode(String code) {
        return tokenRepository.findByCode(code);
    }

    /**
     * Enregistrer un token
     *
     * @param token
     * @return
     */
    @Override
    public Token save(Token token) {
        return tokenRepository.save(token);
    }

    /**
     * Générer le code d'authentification double facteur
     *
     * @return
     */
    @Override
    public Token generateLoginCode(String userId) throws DCashDBItemNotFoundException {
        Users user = userService.findById(userId);
        Token verificationCodeToken = createTokenByType(user, EnumTokenType.LOGIN_TOKEN, Utils.generateRandomDigitsCode(5), Long.valueOf(loginCodeDuration));
        return save(verificationCodeToken);
    }

    /**
     * Vérifier si un code est expiré ou pas
     *
     * @param token
     */
    @Override
    public void verifyCodeExpiration(Token token) {
        if (token.getExpireAt().compareTo(Instant.now()) < 0) {
            throw new InvalidTokenRequestException("Code verification token", token.getCode(),
                    "Expired token. Please issue a new request");
        }
    }

    /**
     * Créer un token par type
     *
     * @param user
     * @param tokenType
     * @param code
     * @param expiryDuration
     * @return
     */
    @Override
    public Token createTokenByType(Users user, EnumTokenType tokenType, String code, Long expiryDuration) {
        Token token = new Token();
        token.setCode(code);
        token.setUser(user);
        token.setStatus(EnumTokenStatus.PENDING);
        token.setType(tokenType);
        token.setExpireAt(Instant.now().plusMillis(expiryDuration));
        return tokenRepository.save(token);
    }
}
