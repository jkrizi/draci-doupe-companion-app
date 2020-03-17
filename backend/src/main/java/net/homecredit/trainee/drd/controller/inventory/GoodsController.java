package net.homecredit.trainee.drd.controller.inventory;

import net.homecredit.trainee.drd.service.inventory.GoodsBlueprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GoodsController {

    private final GoodsBlueprintService goodsBlueprintService;

    public GoodsController(GoodsBlueprintService goodsBlueprintService) {
        this.goodsBlueprintService = goodsBlueprintService;
    }

    @GetMapping("/getAllGoodsBlueprints.json")
    public List<GoodsBlueprintDto> listGoodsBlueprints() {
        return goodsBlueprintService.findAll();
    }

    @PostMapping("/saveGoodsBlueprint.json")
    public void saveGoodsBlueprint(@RequestBody GoodsBlueprintDto newGoodsBlueprint) {
        goodsBlueprintService.save(newGoodsBlueprint);
    }

    @PostMapping("/updateGoodsBlueprint.json")
    public void updateGoodsBlueprint(@RequestBody GoodsBlueprintDto existingGoodsBlueprint) {
        goodsBlueprintService.update(existingGoodsBlueprint);
    }

    @DeleteMapping("/deleteGoodsBlueprint.json")
    public void deleteGoodsBlueprint(@RequestParam UUID id) {
        goodsBlueprintService.delete(id);
    }
}
