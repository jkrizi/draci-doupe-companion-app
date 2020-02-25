package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.character.profession.wizard.Spell;
import net.homecredit.trainee.drd.entity.character.profession.warrior.SwordMove;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.character.RaceService;
import net.homecredit.trainee.drd.service.character.profession.SpellService;
import net.homecredit.trainee.drd.service.character.profession.SwordMoveService;
import net.homecredit.trainee.drd.service.item.WeaponFamilyService;
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
    private ArmorBlueprintService armorBlueprintService;
    private GoodsBlueprintService goodsBlueprintService;
    private TreasureBlueprintService treasureBlueprintService;
    private WeaponFamilyService weaponFamilyService;

    public PersistenceController(RaceService raceService, BeastBlueprintService beastBlueprintService, SpellService spellService, SwordMoveService swordMoveService, WeaponBlueprintService weaponBlueprintService, ArmorBlueprintService armorBlueprintService, GoodsBlueprintService goodsBlueprintService, TreasureBlueprintService treasureBlueprintService, WeaponFamilyService weaponFamilyService) {
        this.raceService = raceService;
        this.beastBlueprintService = beastBlueprintService;
        this.spellService = spellService;
        this.swordMoveService = swordMoveService;
        this.weaponBlueprintService = weaponBlueprintService;
        this.armorBlueprintService = armorBlueprintService;
        this.goodsBlueprintService = goodsBlueprintService;
        this.treasureBlueprintService = treasureBlueprintService;
        this.weaponFamilyService = weaponFamilyService;
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



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllArmorBlueprints.json")
    public @ResponseBody
    List<ArmorBlueprint> listArmorBlueprints() {
        return armorBlueprintService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveArmorBlueprint.json")
    public void saveArmorBlueprint(@RequestBody ArmorBlueprint newArmorBlueprint) {
        System.out.println(newArmorBlueprint);
        armorBlueprintService.save(newArmorBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateArmorBlueprint.json")
    public void updateArmorBlueprint(@RequestBody ArmorBlueprint existingArmorBlueprint) {
        armorBlueprintService.update(existingArmorBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteArmorBlueprint.json")
    public void deleteArmorBlueprint(@RequestParam UUID id) {
        armorBlueprintService.delete(id);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllGoodsBlueprints.json")
    public @ResponseBody
    List<GoodsBlueprint> listGoodsBlueprints() {
        return goodsBlueprintService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveGoodsBlueprint.json")
    public void saveGoodsBlueprint(@RequestBody GoodsBlueprint newGoodsBlueprint) {
        goodsBlueprintService.save(newGoodsBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateGoodsBlueprint.json")
    public void updateGoodsBlueprint(@RequestBody GoodsBlueprint existingGoodsBlueprint) {
        goodsBlueprintService.update(existingGoodsBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteGoodsBlueprint.json")
    public void deleteGoodsBlueprint(@RequestParam UUID id) {
        goodsBlueprintService.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveGemstoneBlueprint.json")
    public void saveGemstoneBlueprint(@RequestBody GemstoneBlueprint newGemstoneBlueprint) {
        treasureBlueprintService.saveGemstoneBlueprint(newGemstoneBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllGemstoneBlueprints.json")
    public @ResponseBody
    List<GemstoneBlueprint> listGemstoneBlueprints() {
        return treasureBlueprintService.findAllGemstoneBlueprints();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveWeaponFamily.json")
    public void saveWeaponFamily(@RequestBody WeaponFamily newWeaponFamily) {
        System.out.println(newWeaponFamily);
        weaponFamilyService.saveWeaponFamily(newWeaponFamily);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllWeaponFamilies.json")
    public @ResponseBody
    List<WeaponFamily> listWeaponFamilies() {
        return weaponFamilyService.findAllWeaponFamilies();
    }
}
