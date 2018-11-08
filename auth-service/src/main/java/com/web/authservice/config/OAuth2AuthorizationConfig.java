package com.web.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    public static final String RESOURCE_ID = "restservice";
    private final String NOOP_PASSWORD_ENCODE = "{noop}";
    int accessTokenValiditySeconds = 99999999;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(this.authenticationManager)
                .tokenServices(tokenServices())
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.jdbc(dataSource);


        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("ui")
                .secret("browser")

                .and()

                .withClient("resource-server")
                .secret("CONFIG_SERVICE_PASSWORD")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .authorities("SERVER")
                .and()

                .withClient("product-service")
                .secret("CONFIG_SERVICE_PASSWORD")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .authorities("SERVER")

                .and()

                .withClient("mail-service")
                .secret("CONFIG_SERVICE_PASSWORD")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .authorities("SERVER")
                .scopes("server")

                .and()

                .withClient("order-service")
                .secret("CONFIG_SERVICE_PASSWORD")
                .authorities("SERVER")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server");
//                .and()
//                .withClient("statistics-service")
//                .secret("CONFIG_SERVICE_PASSWORD")
//                .authorizedGrantTypes("client_credentials", "refresh_token")
//                .scopes("server")
//                .and()
//                .withClient("notification-service")
//                .secret("CONFIG_SERVICE_PASSWORD")
//                .authorizedGrantTypes("client_credentials", "refresh_token")
//                .scopes("server");
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setTokenEnhancer(accessTokenConverter());
        defaultTokenServices.setAuthenticationManager(authenticationManager);
        return defaultTokenServices;
    }
}