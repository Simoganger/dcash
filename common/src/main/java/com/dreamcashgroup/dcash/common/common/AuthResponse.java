package com.dreamcashgroup.dcash.common.common;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthResponse {
    private String accessToken;
    private String username;
    private String refreshToken;
    private Long expiryDuration;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthResponse(String accessToken, String username, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.username = username;
        this.authorities = authorities;
    }

    public AuthResponse(String accessToken, String refreshToken, Long expiryDuration, String username, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiryDuration = expiryDuration;
        this.username = username;
        this.authorities = authorities;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
