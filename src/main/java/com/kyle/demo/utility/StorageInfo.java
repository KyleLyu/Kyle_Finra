package com.kyle.demo.utility;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageInfo {
    public static final String path = "uploadedFiles";


}