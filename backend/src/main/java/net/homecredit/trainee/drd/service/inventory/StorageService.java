package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.repository.inventory.StorageRepository;
import net.homecredit.trainee.drd.util.StorageEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class StorageService {

    private StorageRepository storageRepository;
    private ApplicationEventPublisher eventBus;

    public StorageService(StorageRepository storageRepository, ApplicationEventPublisher eventBus) {
        this.storageRepository = storageRepository;
        this.eventBus = eventBus;
    }

    public StorageUnit createDefaultStorage(Inventory inventory) {
        Set<Equipment> noEquipment = new HashSet<>();

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

    public boolean addEquipmentToStorageUnit(StorageUnit storageUnit, Equipment storedItem) {
        if(storageUnit.getFreeSpace() >= storedItem.getWeight()){
            storedItem.setStorage(storageUnit);
            storageUnit.getEquipment().add(storedItem);
            increaseContentWeight(storageUnit, storedItem.getWeight());
            return true;
        }
        throw new RuntimeException("You don't have enough space in the storage unit");
    }

    private void increaseContentWeight(StorageUnit storageUnit, int weight) {

        storageUnit.setContentWeight(storageUnit.getContentWeight() + weight);
        storageRepository.updateStorage(storageUnit);

        eventBus.publishEvent(new StorageEvent(storageUnit, weight));
    }

    public void deleteAll() {
        storageRepository.deleteAll();
    }
}
