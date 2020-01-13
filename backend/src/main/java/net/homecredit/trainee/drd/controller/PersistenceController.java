package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.profession.Spell;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.service.blueprint.BeastBlueprintService;
import net.homecredit.trainee.drd.service.character.RaceService;
import net.homecredit.trainee.drd.service.character.profession.SpellService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PersistenceController {

    private RaceService raceService;
    private BeastBlueprintService beastBlueprintService;
    private SpellService spellService;

    public PersistenceController(RaceService raceService, BeastBlueprintService beastBlueprintService, SpellService spellService) {
        this.raceService = raceService;
        this.beastBlueprintService = beastBlueprintService;
        this.spellService = spellService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/races.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Race> listRaces() {
        return raceService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/beastBlueprints.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<BeastBlueprint> listBeastBlueprints() {
        return beastBlueprintService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getAllSpells.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Spell> listSpells() {
        return spellService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveSpell.json")
    public void saveSpell(@RequestBody Spell spell) {
        Spell newSpell =  new Spell(spell);
        spellService.save(newSpell);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateSpell.json")
    public void updateSpell(@RequestBody Spell spell) {
        spellService.update(spell);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteSpell.json")
    public void deleteSpell(@RequestParam UUID id) {
        spellService.delete(id);
    }
}
