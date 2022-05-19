package com.sda.eli.petclinic.repository.base;
import com.sda.eli.petclinic.service.dto.VeterinarianDto;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {
    Optional<T> findById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(ID id);

    List<T> findAll();

}
