package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.controller.dto.*;
import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.*;
import net.homecredit.trainee.drd.entity.character.profession.warrior.SwordMove;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.character.profession.SwordMoveService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PersistenceController {

    private BeastBlueprintService beastBlueprintService;
    private BeastBlueprintDtoConverter beastBlueprintDtoConverter;
    private SwordMoveService swordMoveService;
    private WeaponBlueprintService weaponBlueprintService;
    private WeaponBlueprintDtoConverter weaponBlueprintDtoConverter;
    private ArmorBlueprintService armorBlueprintService;
    private ArmorBlueprintDtoConverter armorBlueprintDtoConverter;
    private GoodsBlueprintService goodsBlueprintService;
    private GoodsBlueprintDtoConverter goodsBlueprintDtoConverter;
    private TreasureBlueprintService treasureBlueprintService;
    private TreasureBlueprintDtoConverter treasureBlueprintDtoConverter;

    public PersistenceController(BeastBlueprintService beastBlueprintService, BeastBlueprintDtoConverter beastBlueprintDtoConverter, SwordMoveService swordMoveService, WeaponBlueprintService weaponBlueprintService, WeaponBlueprintDtoConverter weaponBlueprintDtoConverter, ArmorBlueprintService armorBlueprintService, ArmorBlueprintDtoConverter armorBlueprintDtoConverter, GoodsBlueprintService goodsBlueprintService, GoodsBlueprintDtoConverter goodsBlueprintDtoConverter, TreasureBlueprintService treasureBlueprintService, TreasureBlueprintDtoConverter treasureBlueprintDtoConverter) {
        this.beastBlueprintService = beastBlueprintService;
        this.beastBlueprintDtoConverter = beastBlueprintDtoConverter;
        this.weaponBlueprintDtoConverter = weaponBlueprintDtoConverter;
        this.armorBlueprintDtoConverter = armorBlueprintDtoConverter;
        this.goodsBlueprintDtoConverter = goodsBlueprintDtoConverter;
        this.treasureBlueprintDtoConverter = treasureBlueprintDtoConverter;
        this.swordMoveService = swordMoveService;
        this.weaponBlueprintService = weaponBlueprintService;
        this.armorBlueprintService = armorBlueprintService;
        this.goodsBlueprintService = goodsBlueprintService;
        this.treasureBlueprintService = treasureBlueprintService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/beastBlueprints.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<BeastBlueprint> listBeastBlueprints() {
        return beastBlueprintService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveBeastBlueprint.json")
    public void saveBeastBlueprint(@RequestBody BeastBlueprintsDto beastBlueprintsDto) {
        BeastBlueprint blueprint = beastBlueprintDtoConverter.convert(beastBlueprintsDto);
        beastBlueprintService.save(blueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateBeastBlueprint.json")
    public void updateBeastBlueprint(@RequestBody BeastBlueprintsDto existingBeastBlueprintDto) {
        BeastBlueprint beastBlueprint = beastBlueprintDtoConverter.convert(existingBeastBlueprintDto);
        beastBlueprintService.update(beastBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteBeastBlueprint.json")
    public void deleteBeastBlueprint(@RequestParam UUID id) {
        beastBlueprintService.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getAllSwordMoves.json", produces = MediaType.APPLICATION_JSON_VALUE)
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
    @GetMapping(value = "/getAllWeaponBlueprints.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<WeaponBlueprintDto> listWeaponBlueprints() {
        return weaponBlueprintDtoConverter.convert(weaponBlueprintService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveWeaponBlueprint.json")
    public void saveWeaponBlueprint(@RequestBody WeaponBlueprintDto newWeaponBlueprintDto) {
        WeaponBlueprint weaponBlueprint = weaponBlueprintDtoConverter.convert(newWeaponBlueprintDto);
        weaponBlueprintService.save(weaponBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateWeaponBlueprint.json")
    public void updateWeaponBlueprint(@RequestBody WeaponBlueprintDto existingWeaponBlueprintDto) {
        WeaponBlueprint weaponBlueprint = weaponBlueprintDtoConverter.convert(existingWeaponBlueprintDto);
        weaponBlueprintService.update(weaponBlueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteWeaponBlueprint.json")
    public void deleteWeaponBlueprint(@RequestParam UUID id) {
        weaponBlueprintService.delete(id);
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
    @GetMapping("/getAllTreasureBlueprints.json")
    public @ResponseBody
    List<TreasureBlueprintDto> listTreasureBlueprints() {
        return treasureBlueprintDtoConverter.convert(treasureBlueprintService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveTreasureBlueprint.json")
    public void saveTreasureBlueprint(@RequestBody TreasureBlueprintDto newTreasureBlueprintDto) {
        System.out.println(newTreasureBlueprintDto);
        TreasureBlueprint blueprint = treasureBlueprintDtoConverter.convert(newTreasureBlueprintDto);
        treasureBlueprintService.save(blueprint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteTreasureBlueprint.json")
    public void deleteTreasureBlueprint(@RequestParam UUID id) {
        treasureBlueprintService.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/updateTreasureBlueprint.json")
    public void updateTreasureBlueprint(@RequestBody TreasureBlueprintDto existingTreasureBlueprintDto) {
        TreasureBlueprint treasureBlueprint = treasureBlueprintDtoConverter.convert(existingTreasureBlueprintDto);
        treasureBlueprintService.update(treasureBlueprint);
    }
}
