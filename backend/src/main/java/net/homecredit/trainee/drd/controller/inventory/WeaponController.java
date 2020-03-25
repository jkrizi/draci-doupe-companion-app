package net.homecredit.trainee.drd.controller.inventory;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;
import net.homecredit.trainee.drd.service.inventory.WeaponBlueprintService;
import net.homecredit.trainee.drd.service.inventory.WeaponFamilyService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WeaponController {

    private final WeaponFamilyService weaponFamilyService;
    private final WeaponBlueprintService weaponBlueprintService;

    public WeaponController(WeaponFamilyService weaponFamilyService, WeaponBlueprintService weaponBlueprintService) {
        this.weaponFamilyService = weaponFamilyService;
        this.weaponBlueprintService = weaponBlueprintService;
    }

    @GetMapping(value = "/getAllWeaponBlueprints.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeaponBlueprintDto> listWeaponBlueprints() {
        return weaponBlueprintService.findAll();
    }

    @PostMapping("/saveWeaponBlueprint.json")
    public void saveWeaponBlueprint(@RequestBody WeaponBlueprintDto weaponBlueprintDto) {
        weaponBlueprintService.save(weaponBlueprintDto);
    }

    @PostMapping("/updateWeaponBlueprint.json")
    public void updateWeaponBlueprint(@RequestBody WeaponBlueprintDto weaponBlueprintDto) {
        weaponBlueprintService.update(weaponBlueprintDto);
    }

    @DeleteMapping("/deleteWeaponBlueprint.json")
    public void deleteWeaponBlueprint(@RequestParam UUID id) {
        weaponBlueprintService.delete(id);
    }

    @PostMapping("/saveWeaponFamily.json")
    public void saveWeaponFamily(@RequestBody WeaponFamily newWeaponFamily) {
        weaponFamilyService.save(newWeaponFamily);
    }

    @GetMapping("/getAllWeaponFamilies.json")
    public List<WeaponFamily> listWeaponFamilies() {
        return weaponFamilyService.findAll();
    }
}
