package net.homecredit.trainee.drd.service.item;

import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.inventory.EquipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TreasureService {

    private EquipmentRepository equipmentRepository;

    public TreasureService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment forgeTreasure(TreasureBlueprint treasureBlueprint) {
        Equipment treasure = new Equipment(treasureBlueprint, ItemType.TREASURE);
        equipmentRepository.save(treasure);
        return treasure;
    }

    public void deleteAll() {
        equipmentRepository.deleteAll();
    }
}
