package com.dreamcashgroup.dcash.user.service;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.model.entity.Token;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.model.enums.EnumTokenType;

import java.util.Optional;

public interface TokenService {

    /**
     * Enregistrer un token
     * @param token
     * @return
     */
    Token save(Token token);

    /**
     * Retrouver un token suivant son identifiant
     * @param id
     * @return
     */
    Optional<Token> getById(String id);

    /**
     * Retrouver un token à partir de son code
     * @param code
     * @return
     */
    Optional<Token> getByCode(String code);

    /**
     * Générer le code d'authentification double facteur
     * @return
     */
    Token generateLoginCode(String userId) throws DCashDBItemNotFoundException;

    /**
     * Vérifier si un code est expiré ou pas
     * @param token
     */
    void verifyCodeExpiration(Token token);

    /**
     * Créer un token par type
     * @param user
     * @param tokenType
     * @param code
     * @param expiryDuration
     * @return
     */
    Token createTokenByType(Users user, EnumTokenType tokenType, String code, Long expiryDuration);


}
