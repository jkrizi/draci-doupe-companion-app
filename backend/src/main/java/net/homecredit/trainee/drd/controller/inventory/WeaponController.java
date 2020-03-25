package net.homecredit.trainee.drd.controller.inventory;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;
import net.homecredit.trainee.drd.service.inventory.WeaponBlueprintService;
import net.homecredit.trainee.drd.service.inventory.WeaponFamilyService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WeaponController {

    private final ModelMapper modelMapper;
    private final WeaponFamilyService weaponFamilyService;
    private final WeaponBlueprintService weaponBlueprintService;

    public WeaponController(ModelMapper modelMapper, WeaponFamilyService weaponFamilyService, WeaponBlueprintService weaponBlueprintService) {
        this.modelMapper = modelMapper;
        this.weaponFamilyService = weaponFamilyService;
        this.weaponBlueprintService = weaponBlueprintService;
    }

    @GetMapping(value = "/getAllWeaponBlueprints.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeaponBlueprintDto> listWeaponBlueprints() {
        List<WeaponBlueprintDto> weaponBlueprintsDto = new ArrayList<>();
        weaponBlueprintService.findAll().forEach(weaponBlueprint -> {
            weaponBlueprintsDto.add(convertWeaponBlueprint(weaponBlueprint));
        });
        return weaponBlueprintsDto;
    }

    @PostMapping("/saveWeaponBlueprint.json")
    public void saveWeaponBlueprint(@RequestBody WeaponBlueprintDto newWeaponBlueprintDto) {
        WeaponBlueprint weaponBlueprint = convertWeaponBlueprintDto(newWeaponBlueprintDto);
        weaponBlueprintService.save(weaponBlueprint);
    }

    @PostMapping("/updateWeaponBlueprint.json")
    public void updateWeaponBlueprint(@RequestBody WeaponBlueprintDto existingWeaponBlueprintDto) {
        WeaponBlueprint weaponBlueprint = convertWeaponBlueprintDto(existingWeaponBlueprintDto);
        weaponBlueprintService.update(weaponBlueprint);
    }

    @DeleteMapping("/deleteWeaponBlueprint.json")
    public void deleteWeaponBlueprint(@RequestParam UUID id) {
        weaponBlueprintService.delete(id);
    }

    @PostMapping("/saveWeaponFamily.json")
    public void saveWeaponFamily(@RequestBody WeaponFamily newWeaponFamily) {
        System.out.println(newWeaponFamily);
        weaponFamilyService.save(newWeaponFamily);
    }

    @GetMapping("/getAllWeaponFamilies.json")
    public List<WeaponFamily> listWeaponFamilies() {
        return weaponFamilyService.findAll();
    }

    private WeaponBlueprint convertWeaponBlueprintDto(WeaponBlueprintDto weaponBlueprintDto) {
        return modelMapper.map(weaponBlueprintDto, WeaponBlueprint.class);
    }

    private WeaponBlueprintDto convertWeaponBlueprint(WeaponBlueprint weaponBlueprint) {
        return modelMapper.map(weaponBlueprint, WeaponBlueprintDto.class);
    }
}
