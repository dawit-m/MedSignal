package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicine")
public class MedicineActionController {

    private final MedicineService medicineService;

    public MedicineActionController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/update-quantity/{id}/{action}")
    public String updateQuantity(@PathVariable Long id, @PathVariable String action) {
        // We use the service to find the medicine
        Medicine med = medicineService.findById(id);

        if (med != null) {
            if ("increase".equals(action)) {
                med.setQuantity(med.getQuantity() + 1);
            } else if ("decrease".equals(action) && med.getQuantity() > 0) {
                med.setQuantity(med.getQuantity() - 1);
            }
            medicineService.save(med); // Save the change
        }

        // This sends the user back to the dashboard so they see the new number
        return "redirect:/pharmacy/dashboard";
    }
}