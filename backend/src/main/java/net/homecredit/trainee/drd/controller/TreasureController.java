package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.controller.dto.GemstoneDto;
import net.homecredit.trainee.drd.controller.dto.TreasureBlueprintDto;
import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.Gemstone;
import net.homecredit.trainee.drd.service.blueprint.TreasureBlueprintService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TreasureController {

    private final TreasureBlueprintService treasureBlueprintService;
    private final ModelMapper modelMapper;

    public TreasureController(TreasureBlueprintService treasureBlueprintService, ModelMapper modelMapper) {
        this.treasureBlueprintService = treasureBlueprintService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAllTreasureBlueprints.json")
    public List<TreasureBlueprintDto> listTreasureBlueprints() {
        List<TreasureBlueprintDto> treasureBlueprintsDto = new ArrayList<>();
        treasureBlueprintService.findAll().forEach(treasureBlueprint -> treasureBlueprintsDto.add(convertTreasureBlueprint(treasureBlueprint)));
        return treasureBlueprintsDto;
    }

    @PostMapping("/saveTreasureBlueprint.json")
    public void saveTreasureBlueprint(@RequestBody TreasureBlueprintDto newTreasureBlueprint) {
        treasureBlueprintService.save(convertTreasureBlueprintDto(newTreasureBlueprint));
    }

    @DeleteMapping("/deleteTreasureBlueprint.json")
    public void deleteTreasureBlueprint(@RequestParam UUID id) {
        treasureBlueprintService.delete(id);
    }

    @PostMapping("/updateTreasureBlueprint.json")
    public void updateTreasureBlueprint(@RequestBody TreasureBlueprintDto existingTreasureBlueprint) {
        treasureBlueprintService.update(convertTreasureBlueprintDto(existingTreasureBlueprint));
    }

    private TreasureBlueprint convertTreasureBlueprintDto(TreasureBlueprintDto treasureBlueprintDto) {
        TreasureBlueprint treasureBlueprint = modelMapper.map(treasureBlueprintDto, TreasureBlueprint.class);

        treasureBlueprint.getGemstones().clear();
        treasureBlueprintDto.getGemstones().forEach(gemstoneDto ->
                treasureBlueprint.getGemstones().add(convertGemstoneDto(treasureBlueprint, gemstoneDto))
        );
        return treasureBlueprint;
    }

    private TreasureBlueprintDto convertTreasureBlueprint(TreasureBlueprint treasureBlueprint) {
        TreasureBlueprintDto treasureBlueprintDto = modelMapper.map(treasureBlueprint, TreasureBlueprintDto.class);

        treasureBlueprintDto.getGemstones().clear();
        treasureBlueprint.getGemstones().forEach(gemstone ->
                treasureBlueprintDto.getGemstones().add(convertGemstone(gemstone))
        );
        return treasureBlueprintDto;
    }

    private Gemstone convertGemstoneDto(TreasureBlueprint treasureBlueprint, GemstoneDto gemstoneDto) {
        Gemstone gemstone = new Gemstone();
        gemstone.setTreasureBlueprint(treasureBlueprint);
        gemstone.setGemstoneBlueprint(treasureBlueprintService.findGemstoneBlueprint(gemstoneDto.getBlueprintId()));
        gemstone.setCount(gemstoneDto.getStoneCount());
        gemstone.setWeight(gemstoneDto.getStoneWeight());
        gemstone.setPolished(gemstoneDto.isStonePolished());
        gemstone.setId(gemstoneDto.getId());
        gemstone.setPrice(
                treasureBlueprintService.calculateGemstonePrice(
                        gemstoneDto.getStoneWeight(),
                        gemstoneDto.isStonePolished(),
                        gemstone.getGemstoneBlueprint().getUnitPrice()
                )
        );
        return gemstone;
    }

    private GemstoneDto convertGemstone(Gemstone gemstone) {
        GemstoneBlueprint gemstoneBlueprint = gemstone.getGemstoneBlueprint();
        GemstoneDto gemstoneDto = new GemstoneDto();
        gemstoneDto.setStone(gemstoneBlueprint.getName());
        gemstoneDto.setStoneColor(gemstoneBlueprint.getColor());
        gemstoneDto.setStoneWeight(gemstone.getWeight());
        gemstoneDto.setStoneCount(gemstone.getCount());
        gemstoneDto.setStonePolished(gemstone.getPolished());
        gemstoneDto.setBlueprintId(gemstoneBlueprint.getId());
        gemstoneDto.setId(gemstone.getId());
        return gemstoneDto;
    }
}
