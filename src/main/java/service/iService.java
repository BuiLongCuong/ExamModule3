package service;

import java.util.List;

public interface iService<E> {
    void add(E e);
    int findById(int id);
    void delete(int id);
    void update(int id,E e);
    List<E> findAll();
}


