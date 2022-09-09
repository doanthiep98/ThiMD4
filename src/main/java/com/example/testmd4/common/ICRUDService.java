package com.example.testmd4.common;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<E> {
    E save (E e);

    void delete(Long id);

    List<E> findAll();

    Optional<E> findById(Long id);
}
