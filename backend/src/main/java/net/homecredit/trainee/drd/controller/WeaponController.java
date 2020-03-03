package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;
import net.homecredit.trainee.drd.service.item.WeaponFamilyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WeaponController {

    private final WeaponFamilyService weaponFamilyService;

    public WeaponController(WeaponFamilyService weaponFamilyService) {
        this.weaponFamilyService = weaponFamilyService;
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
}
