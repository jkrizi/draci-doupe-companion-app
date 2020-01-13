package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.service.character.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculusController {

    private RaceService raceService;

    public CalculusController(RaceService raceService) {
        this.raceService = raceService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/calcAbilityBonus.json", params = "abilityValue")
    public @ResponseBody
    int calcAbilityBonus(@RequestParam int abilityValue) {
        return raceService.calculateBonus(abilityValue);
    }
}
