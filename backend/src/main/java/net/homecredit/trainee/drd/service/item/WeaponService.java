package net.homecredit.trainee.service.item;

import net.homecredit.trainee.entity.blueprint.item.WeaponBlueprint;
import net.homecredit.trainee.entity.inventory.StorageUnit;
import net.homecredit.trainee.entity.inventory.weapon.Weapon;
import net.homecredit.trainee.repository.inventory.WeaponRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WeaponService {

    private WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Weapon forgeWeapon(WeaponBlueprint weaponBlueprint, StorageUnit ownerBackpack) {
        Weapon weapon = new Weapon(weaponBlueprint, ownerBackpack);
        weaponRepository.save(weapon);
        return weapon;
    }

}
