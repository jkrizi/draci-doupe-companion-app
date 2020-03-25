package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.Armor;
import net.homecredit.trainee.drd.repository.inventory.ArmorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArmorService {

    private ArmorRepository armorRepository;

    public ArmorService(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    public Armor forgeArmor(ArmorBlueprint armorBlueprint) {
        Armor armor = new Armor(armorBlueprint);
        armorRepository.save(armor);
        return armor;
    }

    public void deleteAll() {
        armorRepository.deleteAll();
    }
}
