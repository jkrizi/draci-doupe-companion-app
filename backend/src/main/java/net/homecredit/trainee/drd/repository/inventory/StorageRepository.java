package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.StorageUnit;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class StorageRepository {

    private EntityManager entityManager;

    public StorageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void updateStorage(StorageUnit storageUnit) {
        entityManager.merge(storageUnit);
    }

    /*public StorageUnit find(UUID id) {
        return entityManager.find(StorageUnit.class, id);
    }*/

    public StorageUnit find(UUID id) {
        StorageUnit result = entityManager.createQuery(
                "SELECT x FROM StorageUnit x WHERE x.id = ?1", StorageUnit.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (StorageUnit storageUnit : findAll()) {
            entityManager.remove(storageUnit);
        }
    }

    public List<StorageUnit> findAll() {
        TypedQuery<StorageUnit> query = entityManager.createQuery("select x from StorageUnit x", StorageUnit.class);
        return query.getResultList();
    }
}
