package com.sda.eli.petclinic.service;

import com.sda.eli.petclinic.model.Pet;

import java.util.List;

public interface ClientService {
    List<Pet> findPetsForClientId(Long clientId);
}
