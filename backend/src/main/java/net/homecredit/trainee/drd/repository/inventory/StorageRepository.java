package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.StorageUnit;

import javax.persistence.EntityManager;
import java.util.UUID;

public class StorageRepository {

    private EntityManager entityManager;

    public StorageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void updateStorage(StorageUnit storageUnit) {
        entityManager.merge(storageUnit);
    }

    public StorageUnit find(UUID id) {
        return entityManager.find(StorageUnit.class, id);
    }


}
