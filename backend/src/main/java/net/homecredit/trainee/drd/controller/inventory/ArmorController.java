package net.homecredit.trainee.drd.controller.inventory;

import net.homecredit.trainee.drd.service.inventory.ArmorBlueprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArmorController {

    private final ArmorBlueprintService armorBlueprintService;

    public ArmorController(ArmorBlueprintService armorBlueprintService) {
        this.armorBlueprintService = armorBlueprintService;
    }

    @GetMapping("/getAllArmorBlueprints.json")
    public List<ArmorBlueprintDto> listArmorBlueprints() {
        return armorBlueprintService.findAll();
    }

    @PostMapping("/saveArmorBlueprint.json")
    public void saveArmorBlueprint(@RequestBody ArmorBlueprintDto newArmorBlueprint) {
        armorBlueprintService.save(newArmorBlueprint);
    }

    @PostMapping("/updateArmorBlueprint.json")
    public void updateArmorBlueprint(@RequestBody ArmorBlueprintDto existingArmorBlueprint) {
        armorBlueprintService.update(existingArmorBlueprint);
    }

    @DeleteMapping("/deleteArmorBlueprint.json")
    public void deleteArmorBlueprint(@RequestParam UUID id) {
        armorBlueprintService.delete(id);
    }
}
