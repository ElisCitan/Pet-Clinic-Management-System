package com.sda.eli.petclinic.repository;

import com.sda.eli.petclinic.model.Client;
import com.sda.eli.petclinic.repository.base.BaseRepository;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long> {

    Optional<Client> findByFirstNameAndLastName(String ownerFirstName, String ownerLastName);
    Optional<Client> findByClientId (Long id);
}