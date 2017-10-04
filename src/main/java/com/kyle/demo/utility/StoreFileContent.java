package com.kyle.demo.utility;

import com.kyle.demo.entity.MyFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class StoreFileContent {

    public static void storeFileContent(MultipartFile multipartFile, MyFile file) throws IOException {
        multipartFile.transferTo(new File(file.getPath()));
    }
}