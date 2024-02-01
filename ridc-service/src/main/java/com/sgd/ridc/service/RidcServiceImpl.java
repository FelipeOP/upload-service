package com.sgd.ridc.service;

import static com.sgd.ridc.constants.ImplementedService.*;
import static com.sgd.ridc.constants.Parameters.*;

import java.io.IOError;


import com.sgd.ridc.autoconfigure.RidcProperties;

import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.protocol.ServiceResponse;

public class RidcServiceImpl implements RidcService {

    private final IdcClient<?, ?, ?> idcClient;
    private final IdcContext idcContext;

    public RidcServiceImpl(RidcProperties ridcProperties) throws IdcClientException {
        IdcClientManager manager = new IdcClientManager();
        idcClient = manager.createClient(ridcProperties.getClient().getUrl());
        idcClient.getConfig().setProperty("http.library", ridcProperties.getClient().getHttpLibrary());
        idcContext = new IdcContext(
            ridcProperties.getContext().getUser(),
            ridcProperties.getContext().getPassword()
        );
        idcContext.setParameter(USER_TIME_ZONE, ridcProperties.getContext().getTimeZone());
    }

    @Override
    public DataBinder pingServer() {
        DataBinder binder = idcClient.createBinder();
        binder.putLocal(IDC_SERVICE, PING_SERVER);
        return sendRequest(binder);
    }

    @Override
    public DataBinder getSchemaViewValue(String schemaViewName) {
        DataBinder binder = idcClient.createBinder();
        binder.putLocal(IDC_SERVICE, GET_SCHEMA_VIEW_VALUES);
        binder.putLocal(SCH_VIEW_NAME, schemaViewName);
        return sendRequest(binder);
    }

    private DataBinder sendRequest(DataBinder binder) {
        binder.putLocal(USER_TIME_ZONE, (String) idcContext.getParameter(USER_TIME_ZONE));
        DataBinder responseBinder = null;
        try {
            ServiceResponse response = idcClient.sendRequest(idcContext, binder);
            responseBinder = response.getResponseAsBinder(true);
        } catch (IdcClientException e) {
            throw new IOError(e);
        }
        return responseBinder;
    }
}
