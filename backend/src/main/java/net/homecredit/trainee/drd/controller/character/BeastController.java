package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.service.character.BeastBlueprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BeastController {

    private final BeastBlueprintService beastBlueprintService;

    public BeastController(BeastBlueprintService beastBlueprintService) {
        this.beastBlueprintService = beastBlueprintService;
    }

    @GetMapping("/getAllBeastBlueprints.json")
    public List<BeastBlueprintDto> listBeastBlueprints() {
        return beastBlueprintService.findAll();
    }

    @PostMapping("/saveBeastBlueprint.json")
    public void saveBeastBlueprint(@RequestBody BeastBlueprintDto newBeastBlueprint) {
        beastBlueprintService.save(newBeastBlueprint);
    }

    @PostMapping("/updateBeastBlueprint.json")
    public void updateBeastBlueprint(@RequestBody BeastBlueprintDto existingBeastBlueprint) {
        beastBlueprintService.update(existingBeastBlueprint);
    }

    @DeleteMapping("/deleteBeastBlueprint.json")
    public void deleteBeastBlueprint(@RequestParam UUID id) {
        beastBlueprintService.delete(id);
    }
}
