package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.character.profession.wizard.Spell;
import net.homecredit.trainee.drd.entity.character.profession.warrior.SwordMove;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.service.blueprint.BeastBlueprintService;
import net.homecredit.trainee.drd.service.blueprint.WeaponBlueprintService;
import net.homecredit.trainee.drd.service.character.RaceService;
import net.homecredit.trainee.drd.service.character.profession.SpellService;
import net.homecredit.trainee.drd.service.character.profession.SwordMoveService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PersistenceController {

    private RaceService raceService;
    private BeastBlueprintService beastBlueprintService;
    private SpellService spellService;
    private SwordMoveService swordMoveService;
    private WeaponBlueprintService weaponBlueprintService;

    public PersistenceController(RaceService raceService, BeastBlueprintService beastBlueprintService, SpellService spellService, SwordMoveService swordMoveService, WeaponBlueprintService weaponBlueprintService) {
        this.raceService = raceService;
        this.beastBlueprintService = beastBlueprintService;
        this.spellService = spellService;
        this.swordMoveService = swordMoveService;
        this.weaponBlueprintService = weaponBlueprintService;
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
    public void saveSpell(@RequestBody Spell newSpell) {
        System.out.println(newSpell);
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



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllSwordMoves.json")
    public @ResponseBody
    List<SwordMove> listSwordMoves() {
        return swordMoveService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveSwordMove.json")
    public void saveSwordMove(@RequestBody SwordMove newSwordMove) {
        swordMoveService.save(newSwordMove);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateSwordMove.json")
    public void updateSwordMove(@RequestBody SwordMove existingSwordMove) {
        swordMoveService.update(existingSwordMove);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteSwordMove.json")
    public void deleteSwordMove(@RequestParam UUID id) {
        swordMoveService.delete(id);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllWeaponBlueprints.json")
    public @ResponseBody
    List<WeaponBlueprint> listWeaponBlueprints() {
        return weaponBlueprintService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveWeaponBlueprint.json")
    public void saveWeaponBlueprint(@RequestBody WeaponBlueprint newWeaponBlueprint) {
        System.out.println(newWeaponBlueprint);
        weaponBlueprintService.save(newWeaponBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateWeaponBlueprint.json")
    public void updateWeaponBlueprint(@RequestBody WeaponBlueprint existingWeaponBlueprint) {
        weaponBlueprintService.update(existingWeaponBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteWeaponBlueprint.json")
    public void deleteWeaponBlueprint(@RequestParam UUID id) {
        weaponBlueprintService.delete(id);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllRaces.json")
    public @ResponseBody
    List<Race> listRaces() {
        return raceService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveRace.json")
    public void saveRace(@RequestBody Race newRace) {
        System.out.println(newRace);
        raceService.save(newRace);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateRace.json")
    public void updateRace(@RequestBody Race existingRace) {
        raceService.update(existingRace);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteRace.json")
    public void deleteRace(@RequestParam UUID id) {
        raceService.delete(id);
    }
}
