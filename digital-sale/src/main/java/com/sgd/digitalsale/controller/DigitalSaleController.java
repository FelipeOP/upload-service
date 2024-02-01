package com.sgd.digitalsale.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sgd.digitalsale.models.DocumentRequest;
import com.sgd.digitalsale.service.DigitalSaleService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.model.DataBinder;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/sgd/api/ventaDigital/services")
public class DigitalSaleController {

    private final DigitalSaleService digitalSaleService;

    @PostMapping(value = "/uploadDocument")
    public ResponseEntity<List<DataBinder>> uploadDocument(
            @RequestPart("primaryFile") MultipartFile primaryFile,
            @RequestPart("metadata") DocumentRequest request) throws IdcClientException {
        request.setFile(primaryFile);
        log.info("request: {}", request);
        return ResponseEntity.ok(digitalSaleService.uploadDocument());
    }

}
