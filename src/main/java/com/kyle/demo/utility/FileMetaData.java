package com.kyle.demo.utility;

import java.io.File;
import java.util.Date;

import com.kyle.demo.entity.MyFile;
import org.springframework.web.multipart.MultipartFile;

public class FileMetaData {

    static final String FILE_LOC = "uploadedFiles/";

    //to convert from MultipartFile to MyFile
    public static MyFile getMetaData(MultipartFile multipartFile) {
        MyFile file = new MyFile();

        file.setName(multipartFile.getOriginalFilename());
        file.setPath(new File(FILE_LOC).getAbsolutePath() + "/" + multipartFile.getOriginalFilename());
        file.setTimestamp(new Date());

        return file;

    }
}