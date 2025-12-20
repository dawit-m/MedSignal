package com.pharma.pharmaapp.service;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.entity.Pharmacy;
import com.pharma.pharmaapp.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    // 1. Get ALL medicines
    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    // 2. Updated Save Method (Keep ONLY this one)
    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    // 3. Delete a medicine by ID
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    // 4. Find medicines for a SPECIFIC pharmacy
    public List<Medicine> findByPharmacy(Pharmacy pharmacy) {
        return medicineRepository.findByPharmacy(pharmacy);
    }

    // 5. Search and increase popularity
    public List<Medicine> searchByName(String name) {
        List<Medicine> results = medicineRepository.findByNameContainingIgnoreCase(name);
        for (Medicine med : results) {
            med.setSearchCount(med.getSearchCount() + 1);
            medicineRepository.save(med);
        }
        return results;
    }

    // 6. Get Top 3 Most Searched
    public List<Medicine> getTopMedicines() {
        return medicineRepository.findTop3ByOrderBySearchCountDesc();
    }
}