package com.sgd.ridc.service;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;

@AllArgsConstructor
@Slf4j
@Component
public class RidcServiceProxy implements RidcService {

    private final RidcService ridcService;
    private final RidcService ridcService11g;

    @Override
    public DataBinder pingServer() throws IdcClientException {
        log.info("Ping 11g");
        log.info("Result: {}", ridcService11g.pingServer());
        log.info("Ping 12c");
        log.info("Result: {}", ridcService.pingServer());
        return null;
    }

    @Override
    public DataBinder getSchemaViewValue(String schemaViewName) {
        return ridcService.getSchemaViewValue(schemaViewName);
    }

}
