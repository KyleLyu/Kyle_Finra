package com.kyle.demo;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import com.kyle.demo.controller.FileController;
import com.kyle.demo.dao.FileDao;
import com.kyle.demo.entity.MyFile;
import com.kyle.demo.exception.ErrorInputException;
import com.kyle.demo.service.FileService;
import com.kyle.demo.service.FileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Mock
    FileDao fileDao;

    @Mock
    FileService fileService;

    @InjectMocks
    FileServiceImpl fileServiceImpl;

    @InjectMocks
    FileController fileController;

    private MyFile myFile = new MyFile();
    private Integer id = 5;
    private String name = "Game of Thrones";
    private String path = "files";
    private Date uploadTime = new Date();
    private List<MyFile> files = new ArrayList<>();

    @Before
    public void init() {
        myFile.setId(id);
        myFile.setName(name);
        myFile.setPath(path);
        myFile.setTimestamp(uploadTime);

        files.add(myFile);
    }

    //to test service get method
    @Test
    public void testEquals() {
        when(fileDao.getById(id)).thenReturn(myFile);

        assertEquals(fileServiceImpl.get(id).toString(), myFile.toString());

    }

    //to test service showAll method
    @Test
    public void testAllFiles() {
        when(fileDao.allFile()).thenReturn(files);

        assertTrue(fileServiceImpl.showAll().size() == 1 && fileServiceImpl.showAll().get(0).getName().equals(files.get(0).getName()));
    }


}