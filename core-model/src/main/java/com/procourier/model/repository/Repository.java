package com.procourier.model.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {    //am fi putut sa il lasa package private
    Optional<T> findByID(Long ID);
    List<T> getAll();
    Long put(T item);
    List<Long> putAll(List<T> items);
}
