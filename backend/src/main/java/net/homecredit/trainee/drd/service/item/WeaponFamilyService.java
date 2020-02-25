package net.homecredit.trainee.drd.service.item;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;
import net.homecredit.trainee.drd.repository.inventory.WeaponFamilyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WeaponFamilyService {

    private WeaponFamilyRepository weaponFamilyRepository;

    public WeaponFamilyService(WeaponFamilyRepository weaponFamilyRepository) {
        this.weaponFamilyRepository = weaponFamilyRepository;
    }


    public void saveWeaponFamily(WeaponFamily newWeaponFamily) {
        weaponFamilyRepository.save(newWeaponFamily);
    }

    public List<WeaponFamily> findAllWeaponFamilies() {
        return weaponFamilyRepository.findAll();
    }
}
