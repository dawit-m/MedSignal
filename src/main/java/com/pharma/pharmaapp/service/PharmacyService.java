package com.pharma.pharmaapp.service;

import com.pharma.pharmaapp.entity.Pharmacy;
import com.pharma.pharmaapp.repository.PharmacyRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public Pharmacy register(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy login(String username, String password) {

        Pharmacy pharmacy = pharmacyRepository.findByUsername(username).orElse(null);

        if (pharmacy != null && pharmacy.getPassword().equals(password)) {
            return pharmacy;
        }
        return null;
    }

    public Optional<Pharmacy> findById(Long id) {
        return pharmacyRepository.findById(id);
    }
}