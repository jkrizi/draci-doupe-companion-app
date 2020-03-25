package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;
import net.homecredit.trainee.drd.repository.inventory.WeaponFamilyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WeaponFamilyService {

    private WeaponFamilyRepository weaponFamilyRepository;

    public WeaponFamilyService(WeaponFamilyRepository weaponFamilyRepository) {
        this.weaponFamilyRepository = weaponFamilyRepository;
    }

    public void save(WeaponFamily newWeaponFamily) {
        weaponFamilyRepository.save(newWeaponFamily);
    }

    public List<WeaponFamily> findAll() {
        return weaponFamilyRepository.findAll();
    }

    public WeaponFamily findById(UUID id) {
        return weaponFamilyRepository.findById(id);
    }
}
