package com.kyle.demo.dao;

import com.kyle.demo.entity.MyFile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class FileDaoImpl implements FileDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public MyFile save(MyFile file) {
        entityManager.persist(file);
        return file;

    }

    @Override
    public MyFile getById(Integer id) {
        return entityManager.find(MyFile.class, id);
    }

    @Override
    public List<MyFile> allFile() {
        Query query = entityManager.createQuery("SELECT files FROM MyFile files");
        return query.getResultList();
    }


}