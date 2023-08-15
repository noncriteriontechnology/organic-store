package com.nctech.organicstore.repository;

import java.util.List;

public interface CrudRepository<T,ID> {
    public T save(T t);
    public T update(T t);
    public T findById(ID id);
    public List<T> findAll();
    public void delete(ID id);
}
