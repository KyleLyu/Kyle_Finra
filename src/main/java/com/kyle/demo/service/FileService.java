package com.kyle.demo.service;

import com.kyle.demo.entity.MyFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by yang on 9/19/17.
 */
public interface FileService {

    public void init();
    public MyFile save(MultipartFile multipartFile, MyFile file) throws IOException;
    public MyFile get(Integer id);

    public List<MyFile> showAll();

    public void deleteAll();

}
