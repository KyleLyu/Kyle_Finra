package com.kyle.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

@Entity
@Table(name = "file")
public class MyFile implements Serializable{
    private static final long serialUID = 1L;

    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "f_name")
    private String name;

    @Column(name = "f_path")
    private String path;

    @Column(name = "timestamp")
    private Date timestamp;

    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public String getPath() {
        return path;
    }



    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "fileId: " + id + "\nfileName: " + name + "\n filePath: " + path + "\nfileTimeStamp: " + timestamp;

    }
}