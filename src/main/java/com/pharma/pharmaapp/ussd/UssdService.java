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

    public String process(String sessionId, String text) {

        // 1. MAIN MENU
        // When the user first dials the code, text is empty
        if (text == null || text.isEmpty()) {
            return "CON Welcome to RxLocate Ethiopia\n1. Search Medicine Info\n2. About Service";
        }

        // 2. OPTION 1: INITIAL SEARCH PROMPT
        if (text.equals("1")) {
            return "CON Enter medicine name:";
        }

        // 3. SEARCH LOGIC (Triggers when user sends 1*MedicineName)
        if (text.startsWith("1*")) {
            String medicineName = text.substring(2);
            List<Medicine> results = medicineService.searchByName(medicineName);

            // Handle case where medicine is not found
            if (results == null || results.isEmpty()) {
                return "END Sorry, " + medicineName + " is not available in our database.";
            }

            // Get the first matching medicine object
            Medicine med = results.get(0);

            // Extract Pharmacy details via the Relationship (OOP)
            String pharmacyName = med.getPharmacy().getPharmacyName();
            String pharmacyPhone = med.getPharmacy().getPhoneNumber();

            // Return professional formatted string to the user's phone
            return "END " + med.getName() + " (" + med.getDosage() + ")\n" +
                    "Price: " + med.getPrice() + " ETB\n" +
                    "Origin: " + med.getBrandCountry() + "\n" +
                    "Pharmacy: " + pharmacyName + "\n" +
                    "Call: " + pharmacyPhone;
        }

        // 4. OPTION 2: ABOUT THE SYSTEM
        if (text.equals("2")) {
            return "END RxLocate Ethiopia: Connecting patients to pharmacies offline. Developed for Biomedical Engineering Final Project.";
        }

        // Default response for invalid inputs
        return "END Invalid input. Please try again by dialing the code.";
    }
}