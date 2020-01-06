package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.service.blueprint.BeastBlueprintService;
import net.homecredit.trainee.drd.service.character.RaceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersistenceController {

    private RaceService raceService;
    private BeastBlueprintService beastBlueprintService;

    public PersistenceController(RaceService raceService, BeastBlueprintService beastBlueprintService) {
        this.raceService = raceService;
        this.beastBlueprintService = beastBlueprintService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/races.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Race> listRaces() {
        List<Race> races = raceService.findAll();
        for(Race r: races) {
            System.out.println(r);
        }
        return  races;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/beastBlueprints.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<BeastBlueprint> listBeastBlueprints() {
        List<BeastBlueprint> beastBlueprints = beastBlueprintService.findAll();
        for(BeastBlueprint bb: beastBlueprints) {
            System.out.println(bb);
        }
        return beastBlueprints;
    }
}
