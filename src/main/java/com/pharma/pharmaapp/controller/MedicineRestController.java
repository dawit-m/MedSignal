package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineRestController {

    private final MedicineService medicineService;

    public MedicineRestController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/search")
    public List<Medicine> getMedicines(@RequestParam String name) {
        return medicineService.searchByName(name);
    }

    @GetMapping("/popular")
    public List<Medicine> getPopular() {
        return medicineService.getTopMedicines();
    }
}