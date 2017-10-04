package com.kyle.demo.dao;

import com.kyle.demo.entity.MyFile;

import java.util.List;

/**
 * Created by yang on 9/19/17.
 */
public interface FileDao {

    public MyFile save(MyFile file);

    public MyFile getById(Integer id);

    public List<MyFile> allFile();



}
