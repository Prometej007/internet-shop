//package com.web.productservice.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.common.exceptions.InsufficientScopeException;
//import org.springframework.security.oauth2.provider.expression.OAuth2SecurityExpressionMethods;
//
//public class OAuth2ExpressionsBean extends OAuth2SecurityExpressionMethods {
//
//    public OAuth2ExpressionsBean(Authentication authentication) {
//        super(authentication);
//    }
//
//    @Override
//    public boolean throwOnError(boolean decision) {
//        return super.throwOnError(decision);
//    }
//
//    @Override
//    public boolean clientHasRole(String role) {
//        return super.clientHasRole(role);
//    }
//
//    @Override
//    public boolean clientHasAnyRole(String... roles) {
//        return super.clientHasAnyRole(roles);
//    }
//
//    @Override
//    public boolean hasScope(String scope) {
//        System.out.println(scope);
//        return super.hasScope(scope);
//    }
//
//    @Override
//    public boolean hasAnyScope(String... scopes) {
//        return super.hasAnyScope(scopes);
//    }
//
//    @Override
//    public boolean hasScopeMatching(String scopeRegex) {
//        return super.hasScopeMatching(scopeRegex);
//    }
//
//    @Override
//    public boolean hasAnyScopeMatching(String... scopesRegex) {
//        return super.hasAnyScopeMatching(scopesRegex);
//    }
//
//    @Override
//    public boolean denyOAuthClient() {
//        return super.denyOAuthClient();
//    }
//
//    @Override
//    public boolean isOAuth() {
//        return super.isOAuth();
//    }
//
//    @Override
//    public boolean isUser() {
//        return super.isUser();
//    }
//
//    @Override
//    public boolean isClient() {
//        return super.isClient();
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
//
//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//    }
//}