package ru.denis.rest_server.service;


import java.util.List;

public interface CrudService<T> {
    List<T> findAll();

    void save(T t);

    T findById(Long id);

    void update(T t);

    void deleteById(Long id);


}