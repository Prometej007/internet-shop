package com.web.authservice.service;

import com.web.authservice.controller.ExceptionsController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2ExceptionRenderer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomOAuth2AccessDeniedHandler extends OAuth2AccessDeniedHandler {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CustomOAuth2AccessDeniedHandler.class);


    public CustomOAuth2AccessDeniedHandler() {
        super();
        logger.debug("------------create CustomOAuth2AccessDeniedHandler()------------");
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        logger.debug("----------------------handle----------------------------");
        super.handle(request, response, authException);
    }

    @Override
    public void setExceptionTranslator(WebResponseExceptionTranslator exceptionTranslator) {
        logger.debug("----------------------setExceptionTranslator----------------------------");
        super.setExceptionTranslator(exceptionTranslator);
    }

    @Override
    public void setExceptionRenderer(OAuth2ExceptionRenderer exceptionRenderer) {
        logger.debug("----------------------setExceptionRenderer----------------------------");
        super.setExceptionRenderer(exceptionRenderer);
    }

    @Override
    protected ResponseEntity<OAuth2Exception> enhanceResponse(ResponseEntity<OAuth2Exception> result, Exception authException) {
        logger.debug("----------------------enhanceResponse----------------------------");
        return super.enhanceResponse(result, authException);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
