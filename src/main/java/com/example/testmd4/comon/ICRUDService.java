package com.example.testmd4.comon;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<E> {
    E save(E e);

    void delete(Long id);

    List<E> findAll();

    Optional<E> findById(Long id);

    Page<E> findAllByNameContaining(Pageable pageable, String name);

}
