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

    // Register a new pharmacy business
    public Pharmacy register(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    // Login logic Validates username and password against the database
    public Pharmacy login(String username, String password) {
        // .orElse(null) converts the Optional<Pharmacy> into a regular Pharmacy object
        // If the username is not found, 'pharmacy' becomes null.
        Pharmacy pharmacy = pharmacyRepository.findByUsername(username).orElse(null);

        if (pharmacy != null && pharmacy.getPassword().equals(password)) {
            return pharmacy;
        }
        return null;
    }

    // Helper method to find a pharmacy by ID
    public Optional<Pharmacy> findById(Long id) {
        return pharmacyRepository.findById(id);
    }
}