package com.dreamcashgroup.dcash.common.common;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private Long expiryDuration;
    private boolean secondLoginRequired;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthResponse(boolean secondLoginRequired) {
        this.secondLoginRequired = secondLoginRequired;
    }

    public AuthResponse(String accessToken, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.authorities = authorities;
    }

    public AuthResponse(String accessToken, String refreshToken, Long expiryDuration, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiryDuration = expiryDuration;
        this.authorities = authorities;
    }

    public AuthResponse(String accessToken, String refreshToken, Long expiryDuration, Collection<? extends GrantedAuthority> authorities, boolean secondLoginRequired) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiryDuration = expiryDuration;
        this.authorities = authorities;
        this.secondLoginRequired = secondLoginRequired;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Long getExpiryDuration() {
        return expiryDuration;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
