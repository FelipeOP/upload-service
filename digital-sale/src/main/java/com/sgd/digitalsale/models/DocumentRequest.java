package com.sgd.digitalsale.models;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class DocumentRequest {

    @JsonIgnore
    private MultipartFile file;
    private Map<String, String> metadata;

    DocumentRequest() {
        metadata = new TreeMap<>();
    }

    @JsonAnySetter
    public void setMetadata(String key, String value) {
        metadata.put(key, value);
    }
}
