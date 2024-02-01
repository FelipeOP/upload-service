package com.sgd.ridc.service;

import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;

public interface RidcService {

    public DataBinder pingServer() throws IdcClientException;

    public DataBinder getSchemaViewValue(String schemaViewName);


}
