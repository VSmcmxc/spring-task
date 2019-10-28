package com.epam.legacy.repository;

import java.util.List;

public interface GenericRepository<T, PK> {

    T create(T object);

    T getById(PK id);

    public T update(T object);

    public PK deleteById(PK id);

    public List<T> getAll();
}
