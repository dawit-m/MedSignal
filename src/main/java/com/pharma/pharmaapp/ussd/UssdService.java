package com.pharma.pharmaapp.ussd;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UssdService {

    private final MedicineService medicineService;

    public UssdService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public String process(String sessionId, String text) { // Line 17

        // 1. MAIN MENU
        if (text == null || text.isEmpty()) {
            return "CON Welcome to PharmaFinder\n1. Search Medicine\n2. Popular Medicines";
        }

        // 2. OPTION 1
        if (text.equals("1")) {
            return "CON Enter medicine name:";
        }

        // 3. SEARCH LOGIC
        if (text.startsWith("1*")) {
            String medicineName = text.substring(2);
            List<Medicine> results = medicineService.searchByName(medicineName);

            // If results is null or empty, stop here instead of crashing
            if (results == null || results.isEmpty()) {
                return "END Sorry, " + medicineName + " not found.";
            }

            Medicine med = results.get(0);
            return "END Found: " + med.getName() +
                    "\nPrice: " + med.getPrice() + " ETB" +
                    "\nQty: " + med.getQuantity();
        }

        // 4. OPTION 2: POPULAR MEDICINES
        if (text.equals("2")) {
            List<Medicine> popular = medicineService.getTopMedicines();
            if (popular.isEmpty()) {
                return "END No searches recorded yet.";
            }

            StringBuilder response = new StringBuilder("END Popular Medicines:\n");
            for (int i = 0; i < popular.size(); i++) {
                Medicine med = popular.get(i);
                response.append((i + 1)).append(". ").append(med.getName())
                        .append(" (").append(med.getSearchCount()).append(" searches)\n");
            }
            return response.toString();
        }

        return "END Invalid input";
    }
}