package com.dreamcashgroup.dcash.user.controller;

import com.dreamcashgroup.dcash.common.common.AuthResponse;
import com.dreamcashgroup.dcash.common.common.RestResponse;
import com.dreamcashgroup.dcash.common.common.ResponseStatus;
import com.dreamcashgroup.dcash.common.security.CustomUserDetails;
import com.dreamcashgroup.dcash.model.entity.Token;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.dto.FirstLoginDto;
import com.dreamcashgroup.dcash.user.dto.SecondLoginDto;
import com.dreamcashgroup.dcash.user.service.AuthService;
import com.dreamcashgroup.dcash.user.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    /**
     * Connexion d'un utilisateur
     * @param firstLoginDto
     * @return
     */
    @PostMapping("/login")
    public RestResponse login (@RequestBody FirstLoginDto firstLoginDto) {
        try{
            Optional<Authentication> authenticationOpt = authService.authenticateUser(firstLoginDto.getUsername(), firstLoginDto.getPassword());
            authenticationOpt.orElseThrow(() -> new RuntimeException("Couldn't login user [" + firstLoginDto + "]"));

            Authentication authentication = authenticationOpt.get();
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);

            boolean secondLoginRequired = authService.verifySecondLoginRequirement(customUserDetails.getId());
            if(secondLoginRequired){
                Token code = tokenService.generateLoginCode(customUserDetails.getId());
                // TODO: envoyer le code généré par mail/sms
                return new RestResponse(new AuthResponse(true), "Deuxième connexion requise", ResponseStatus.SUCCESS, 200);
            }else{
                String accessToken = authService.generateJwtToken(authentication);
                return new RestResponse(new AuthResponse(accessToken, customUserDetails.getAuthorities()), "Connexion effectuée avec succès !", ResponseStatus.SUCCESS, 200);
            }
        }catch(Exception e){
            return new RestResponse(null,"Connexion échouée.", ResponseStatus.FAILED, 404);
        }
    }

    /**
     * Vérification du code lié à la deuxième authentification
     * @param secondLoginDto
     * @return
     */
    @PostMapping("/verify/code")
    public RestResponse login (@RequestBody SecondLoginDto secondLoginDto) {
        try{
            Optional<Authentication> authenticationOpt = authService.authenticateUser(secondLoginDto.getUsername(), secondLoginDto.getPassword());
            authenticationOpt.orElseThrow(() -> new RuntimeException("Couldn't login user [" + secondLoginDto + "]"));

            Authentication authentication = authenticationOpt.get();
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);

            authService.processCodeVerification(secondLoginDto.getCode());
            String accessToken = authService.generateJwtToken(authentication);
            return new RestResponse(new AuthResponse(accessToken, customUserDetails.getAuthorities()), "Connexion effectuée avec succès !", ResponseStatus.SUCCESS, 200);
        }catch(Exception e){
            return new RestResponse(null,"Connexion échouée.", ResponseStatus.FAILED, 404);
        }
    }

}
