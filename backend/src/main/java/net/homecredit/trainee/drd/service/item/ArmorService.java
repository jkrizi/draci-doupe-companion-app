package net.homecredit.trainee.drd.service.item;

import net.homecredit.trainee.drd.entity.blueprint.item.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.inventory.armor.Armor;
import net.homecredit.trainee.drd.entity.inventory.armor.BodySection;
import net.homecredit.trainee.drd.repository.inventory.ArmorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

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
