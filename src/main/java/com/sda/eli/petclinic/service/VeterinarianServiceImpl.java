package com.sda.eli.petclinic.service;

import com.sda.eli.petclinic.model.Veterinarian;
import com.sda.eli.petclinic.repository.VeterinarianRepository;
import com.sda.eli.petclinic.repository.VeterinarianRepositoryImpl;
import com.sda.eli.petclinic.service.dto.VeterinarianDto;
import com.sda.eli.petclinic.service.exception.InvalidParameterException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeterinarianServiceImpl implements VeterinarianService {
    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianServiceImpl() {
        this.veterinarianRepository = new VeterinarianRepositoryImpl();
    }

    @Override
    public void create(String firstName, String lastName, String address, String speciality) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidParameterException("The first name is null or empty.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new InvalidParameterException("The last name is null or empty.");
        }
        if (address == null || address.isBlank()) {
            throw new InvalidParameterException("The address is null or empty.");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new InvalidParameterException("The speciality is null or empty.");
        }

        veterinarianRepository.create(new Veterinarian(firstName, lastName, address, speciality));
    }

    @Override
    public List<VeterinarianDto> findAll() {
        List<Veterinarian> veterinarians = veterinarianRepository.findAll();
        return veterinarians
                .stream()
                .map(veterinarian ->
                        new VeterinarianDto(
                                veterinarian.getId(),
                                veterinarian.getFirstName(),
                                veterinarian.getLastName(),
                                veterinarian.getAddress(),
                                veterinarian.getSpeciality()
                        )
                )
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        veterinarianRepository.deleteById(id);
    }

    @Override
    public void update(
            Long id,
            String firstName,
            String lastName,
            String address,
            String speciality) throws InvalidParameterException, InvalidParameterException {
        Optional<Veterinarian>veterinarian = veterinarianRepository.findById(id);
        if(veterinarian.isPresent()){
            veterinarian.get().setFirstName(firstName);
            veterinarian.get().setLastName(lastName);
            veterinarian.get().setAddress(address);
            veterinarian.get().setSpeciality(speciality);
            veterinarianRepository.update(veterinarian.get());

        }

    }

}