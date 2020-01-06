package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.Inventory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class InventoryRepository {

    private EntityManager entityManager;

    public InventoryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveInventory(Inventory inventory) {
        entityManager.persist(inventory);
    }

    public void deleteAll() {
        for (Inventory inventory : findAll()) {
            entityManager.remove(inventory);
        }
    }

    public List<Inventory> findAll() {
        TypedQuery<Inventory> query = entityManager.createQuery("select x from Inventory x", Inventory.class);
        return query.getResultList();
    }

    private Inventory findById(UUID id) {
        Inventory result = entityManager.createQuery(
                "SELECT x FROM Inventory x WHERE x.id = ?1", Inventory.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void updateInventory(Inventory inventory) {
        entityManager.merge(inventory);
    }
}
