package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.service.inventory.BeastBlueprintService;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/beastBlueprints.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BeastBlueprint> listBeastBlueprints() {
        return beastBlueprintService.findAll();
    }

//    @PostMapping("/saveBeastBlueprint.json")
//    public void saveBeastBlueprint(@RequestBody BeastBlueprintsDto beastBlueprintsDto) {
//        BeastBlueprint blueprint = beastBlueprintDtoConverter.convert(beastBlueprintsDto);
//        beastBlueprintService.save(blueprint);
//    }

//    @PostMapping("/updateBeastBlueprint.json")
//    public void updateBeastBlueprint(@RequestBody BeastBlueprintsDto existingBeastBlueprintDto) {
//        BeastBlueprint beastBlueprint = beastBlueprintDtoConverter.convert(existingBeastBlueprintDto);
//        beastBlueprintService.update(beastBlueprint);
//    }

    @DeleteMapping("/deleteBeastBlueprint.json")
    public void deleteBeastBlueprint(@RequestParam UUID id) {
        beastBlueprintService.delete(id);
    }
}
