package com.kyle.demo.utility;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageInfo {
    private String path = "uploadedFiles";

    public String getPath() {
        return path;
    }
}