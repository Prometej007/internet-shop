//package com.web.authservice.config;
//
//import com.web.authservice.service.CustomOAuth2AccessDeniedHandler;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//
//import static com.web.authservice.config.OAuth2AuthorizationConfig.RESOURCE_ID;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//        http.
//                anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .and().exceptionHandling().accessDeniedHandler(new CustomOAuth2AccessDeniedHandler());
//	}
//
//}