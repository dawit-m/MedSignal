package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {

    private final MedicineService medicineService;

    public ClientController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/client")
    public String showClientPage(Model model) {
        // i am providing an empty list so the page doesn't crash before the first
        // search
        model.addAttribute("medicines", new java.util.ArrayList<>());
        return "client-search";
    }

    @GetMapping("/client/search")
    public String search(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            // This now searches the real database and updates searchCount
            List<Medicine> results = medicineService.searchByName(name);
            model.addAttribute("medicines", results);
            model.addAttribute("searchQuery", name);
        }
        return "client-search"; // this Returns client.html
    }
}