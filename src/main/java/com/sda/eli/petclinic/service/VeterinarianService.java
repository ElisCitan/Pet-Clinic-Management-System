package com.sda.eli.petclinic.service;

import com.sda.eli.petclinic.service.dto.VeterinarianDto;
import com.sda.eli.petclinic.service.exception.InvalidParameterException;

import java.util.List;

public interface VeterinarianService {
    void create(String firstName,
                String lastName,
                String address,
                String speciality) throws InvalidParameterException, InvalidParameterException;
    //DTO-> data transfer object
    List<VeterinarianDto> findAll();

   void deleteById(Long id);
   void update (Long id,
                String firstName,
                String lastName,
                String address,
                String speciality) throws InvalidParameterException, InvalidParameterException;
}