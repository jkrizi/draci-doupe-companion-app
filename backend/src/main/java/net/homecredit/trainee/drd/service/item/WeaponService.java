package net.homecredit.trainee.drd.service.item;

import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.inventory.weapon.Weapon;
import net.homecredit.trainee.drd.repository.inventory.WeaponRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WeaponService {

    private WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Weapon forgeWeapon(WeaponBlueprint weaponBlueprint) {
        Weapon weapon = new Weapon(weaponBlueprint);
        weaponRepository.save(weapon);
        return weapon;
    }

    public void deleteAll() {
        weaponRepository.deleteAll();
    }
}
