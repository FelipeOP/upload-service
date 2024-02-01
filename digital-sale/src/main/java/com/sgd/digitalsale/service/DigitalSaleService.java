package com.sgd.digitalsale.service;

import java.util.List;

import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;

public interface DigitalSaleService {
    List<DataBinder> uploadDocument() throws IdcClientException;
}
