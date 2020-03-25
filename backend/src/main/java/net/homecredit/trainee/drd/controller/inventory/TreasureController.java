package net.homecredit.trainee.drd.controller.inventory;

import net.homecredit.trainee.drd.entity.inventory.treasure.GemstoneBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.Gemstone;
import net.homecredit.trainee.drd.service.inventory.TreasureBlueprintService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TreasureController {

    private final TreasureBlueprintService treasureBlueprintService;

    public TreasureController(TreasureBlueprintService treasureBlueprintService) {
        this.treasureBlueprintService = treasureBlueprintService;
    }

    @GetMapping("/getAllTreasureBlueprints.json")
    public List<TreasureBlueprintDto> listTreasureBlueprints() {
        return treasureBlueprintService.findAll();
    }

    @PostMapping("/saveTreasureBlueprint.json")
    public void saveTreasureBlueprint(@RequestBody TreasureBlueprintDto newTreasureBlueprint) {
        treasureBlueprintService.save(newTreasureBlueprint);
    }

    @PostMapping("/updateTreasureBlueprint.json")
    public void updateTreasureBlueprint(@RequestBody TreasureBlueprintDto existingTreasureBlueprint) {
        treasureBlueprintService.update(existingTreasureBlueprint);
    }

    @DeleteMapping("/deleteTreasureBlueprint.json")
    public void deleteTreasureBlueprint(@RequestParam UUID id) {
        treasureBlueprintService.delete(id);
    }

    @PostMapping("/saveGemstoneBlueprint.json")
    public void saveGemstoneBlueprint(@RequestBody GemstoneBlueprint newGemstoneBlueprint) {
        treasureBlueprintService.saveGemstoneBlueprint(newGemstoneBlueprint);
    }

    @GetMapping("/getAllGemstoneBlueprints.json")
    public List<GemstoneBlueprint> listGemstoneBlueprints() {
        return treasureBlueprintService.findAllGemstoneBlueprints();
    }
}
