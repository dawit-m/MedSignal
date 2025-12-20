package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // Pharmacy adds medicine
    @PostMapping("/add")
    public Medicine add(
            @RequestBody Medicine medicine) {
        return medicineService.save(medicine);
    }

    // Client searches medicine
    @GetMapping("/search")
    public List<Medicine> search(@RequestParam String name) {
        return medicineService.searchByName(name);
    }
}
