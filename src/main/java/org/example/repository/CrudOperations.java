package org.example.repository;

import org.example.model.AuthorModel;

import java.util.List;

public interface CrudOperations <T>{
    List<T> findAll();
    List<T> saveAll(List<T> toSave);
    T save(T toSave);
    AuthorModel save(AuthorModel toSave);
    T delete(T toDelete);
}
