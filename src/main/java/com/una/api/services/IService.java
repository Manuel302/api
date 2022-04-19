package com.una.api.services;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T get(int id);
    void post(T obj);
    void put(T obj);
}
