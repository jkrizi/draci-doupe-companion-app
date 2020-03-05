package net.homecredit.trainee.drd.controller.util;

import net.homecredit.trainee.drd.service.character.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculusController {

    private RaceService raceService;

    public CalculusController(RaceService raceService) {
        this.raceService = raceService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/calcAbilityBonus.json", params = "abilityValue")
    public int calcAbilityBonus(@RequestParam int abilityValue) {
        return raceService.calculateBonus(abilityValue);
    }
}
