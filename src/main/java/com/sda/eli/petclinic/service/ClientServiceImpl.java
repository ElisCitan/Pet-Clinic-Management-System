package com.sda.eli.petclinic.service;

import com.sda.eli.petclinic.model.Client;
import com.sda.eli.petclinic.model.Pet;
import com.sda.eli.petclinic.repository.ClientRepository;
import com.sda.eli.petclinic.repository.ClientRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();

    }

    @Override
    public List<Pet> findPetsForClientId(Long clientId) {

        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            return client.get().getPets();
        }
    }
}
