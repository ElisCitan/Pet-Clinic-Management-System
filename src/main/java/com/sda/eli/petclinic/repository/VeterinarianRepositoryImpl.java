package com.sda.eli.petclinic.repository;

import com.sda.eli.petclinic.model.Veterinarian;
import com.sda.eli.petclinic.repository.base.BaseRepositoryImpl;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Long> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}
