package com.dreamcashgroup.dcash.gateway.security;

import com.dreamcashgroup.dcash.common.exception.DCashCommonException;
import com.dreamcashgroup.dcash.common.exception.EnumErrorCode;
import com.dreamcashgroup.dcash.common.security.jwt.JwtTokenProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GatewayTokenFilter extends OncePerRequestFilter {

    Logger logger = LogManager.getLogger(getClass());

    private JwtTokenProvider jwtTokenProvider;

    public GatewayTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = getJwt(request);
        if (token != null) {
            try {
                logger.debug("validating {} with token filter", token);

                jwtTokenProvider.validateJwtToken(token);
            } catch (DCashCommonException e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getErrorCode().getCode());
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, EnumErrorCode.ERROR_JWT_TOKEN_NOTFOUND.getCode());
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }
        return null;
    }
}