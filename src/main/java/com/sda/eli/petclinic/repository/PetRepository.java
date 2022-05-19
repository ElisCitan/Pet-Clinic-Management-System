package com.sda.eli.petclinic.repository;

import com.sda.eli.petclinic.model.Pet;
import com.sda.eli.petclinic.repository.base.BaseRepository;

import java.util.List;

public interface PetRepository extends BaseRepository<Pet, Long> {

    List<Pet> findAllVaccinated();
}