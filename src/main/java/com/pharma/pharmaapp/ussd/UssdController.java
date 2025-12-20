package com.pharma.pharmaapp.ussd;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ussd")
public class UssdController {

    private final UssdService ussdService;

    public UssdController(UssdService ussdService) {
        this.ussdService = ussdService;
    }

    @PostMapping
    public String handleUssd(
            @RequestParam String sessionId,
            @RequestParam String text) {

        return ussdService.process(sessionId, text);
    }
}
