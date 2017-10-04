package com.kyle.demo.controller;

import com.kyle.demo.entity.MyFile;
import com.kyle.demo.service.FileService;
import com.kyle.demo.utility.FileMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public MyFile file(@RequestParam("file") MultipartFile uploadFile) throws IOException {

        MyFile file = FileMetaData.getMetaData(uploadFile);

        return fileService.save(uploadFile, file);
    }

    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
    public MyFile getFileById(@PathVariable Integer id) {
        return fileService.get(id);

    }

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public List<MyFile> showAllFiles() {
        return fileService.showAll();
    }


}