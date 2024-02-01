package com.sgd.ridc.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;

@Slf4j
@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = { RidcService.class })
class RidcServiceTests {

    @Autowired
    private RidcService ridcService;

    @Test
    void givenServerUp_WhenPingServer_ReturnsSuccess() throws IdcClientException, JsonProcessingException {
        DataBinder binder = ridcService.pingServer();
        assertThat(binder).isNull();
    }

    @Test
    void givenValidSchemaViewName_whenGetSchemaViewValue_returnBinderNotNull() {
        DataBinder binder = ridcService.getSchemaViewValue("lovTipoIdentificacion");
        log.info("result: {}", binder);
        assertThat(binder).isNotNull();
    }

}
