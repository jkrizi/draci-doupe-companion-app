package net.homecredit.trainee.drd.service.item;

import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.repository.inventory.StorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StorageService {

    private StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public StorageUnit createDefaultStorage(Inventory inventory) {
        List<Equipment> noEquipment = new ArrayList<>();

        return new StorageUnit(
                "Default storage",
                "Default storage for NPC Inventory and Equipment not contained in other Storage Units",
                0,
                inventory.getLimitWeight(),
                0,
                true,
                noEquipment,
                inventory);
    }

    public StorageUnit findStorage(UUID id) {
        return storageRepository.find(id);
    }
}
