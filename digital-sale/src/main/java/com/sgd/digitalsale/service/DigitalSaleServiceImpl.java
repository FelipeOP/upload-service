package com.sgd.digitalsale.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sgd.ridc.service.RidcService;

import lombok.AllArgsConstructor;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;

@Service
@AllArgsConstructor
public class DigitalSaleServiceImpl implements DigitalSaleService {

    private final RidcService ridcService11g;
    private final RidcService ridcService12c;
    

    @Override
    public List<DataBinder> uploadDocument() throws IdcClientException {
        return Arrays.asList(ridcService11g.pingServer(), ridcService12c.pingServer());
    }

    // @Override
    // public String uploadDocument() {
    // return ridcService11g.pingServer();
    // }

}
