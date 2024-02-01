package com.sgd.digitalsale.ridc12c;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.sgd.ridc.autoconfigure.RidcProperties;
import com.sgd.ridc.service.RidcService;
import com.sgd.ridc.service.RidcServiceImpl;

import oracle.stellent.ridc.IdcClientException;

@Configuration
public class RidcService12cConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "ridc.owcc12c")
    RidcProperties ridcProperties12c() {
        return new RidcProperties();
    }

    @Bean
    RidcService ridcService12c(RidcProperties ridcProperties12c)
            throws IdcClientException {
        return new RidcServiceImpl(ridcProperties12c);
    }

}
