//package com.web.authservice.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
//public class TransactionManager implements TransactionManagementConfigurer {
//
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new JpaTransactionManager();
//    }
//}