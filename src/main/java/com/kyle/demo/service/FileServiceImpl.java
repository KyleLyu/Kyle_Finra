package com.kyle.demo.service;

import com.kyle.demo.dao.FileDao;
import com.kyle.demo.entity.MyFile;
import com.kyle.demo.exception.StorageException;
import com.kyle.demo.utility.StorageInfo;
import com.kyle.demo.utility.StoreFileContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    private final Path rootPath;

    @Autowired
    public FileServiceImpl(StorageInfo storageInfo) {
        this.rootPath = Paths.get(storageInfo.getPath());
    }



    @Autowired
    FileDao fileDao;

    @Override
    public void init() {

        try {
            Files.createDirectories(rootPath);
        } catch (IOException e) {
            throw new StorageException("Could not create root directory");
        }

    }

    @Override
    @Transactional
    public MyFile save(MultipartFile multipartFile, MyFile file) throws IOException {
        StoreFileContent.storeFileContent(multipartFile, file);
        return fileDao.save(file);
    }

    @Override
    public MyFile get(Integer id) {
        return fileDao.getById(id);
    }

    @Override
    public List<MyFile> showAll() {
        return fileDao.allFile();
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootPath.toFile());


    }
}