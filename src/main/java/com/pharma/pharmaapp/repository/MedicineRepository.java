package com.pharma.pharmaapp.repository;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    // For the Public Search
    List<Medicine> findByNameContainingIgnoreCase(String name);

    // For the Dashboard
    List<Medicine> findByPharmacy(Pharmacy pharmacy);

    // For the Popularity List
    List<Medicine> findTop3ByOrderBySearchCountDesc();
}