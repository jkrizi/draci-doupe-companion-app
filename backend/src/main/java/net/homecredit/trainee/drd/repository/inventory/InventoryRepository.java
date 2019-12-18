package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.Inventory;

import javax.persistence.EntityManager;

public class InventoryRepository {

    private EntityManager entityManager;

    public InventoryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveInventory(Inventory inventory) {
        entityManager.persist(inventory);
    }

}
