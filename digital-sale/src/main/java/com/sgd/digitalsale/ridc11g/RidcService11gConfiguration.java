package com.sgd.digitalsale.ridc11g;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sgd.ridc.autoconfigure.RidcProperties;
import com.sgd.ridc.service.RidcService;
import com.sgd.ridc.service.RidcServiceImpl;

import oracle.stellent.ridc.IdcClientException;

@Configuration
public class RidcService11gConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "ridc.owcc11g")
    RidcProperties ridcProperties11g() {
        return new RidcProperties();
    }

    @Bean
    RidcService ridcService11g(RidcProperties ridcProperties11g)
            throws IdcClientException {
        return new RidcServiceImpl(ridcProperties11g);
    }

}
