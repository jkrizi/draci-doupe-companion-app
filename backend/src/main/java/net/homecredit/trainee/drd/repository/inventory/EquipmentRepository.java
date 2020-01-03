package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EquipmentRepository {
    private EntityManager entityManager;

    public EquipmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Equipment equipment) {
        entityManager.persist(equipment);
    }

    public void deleteAll() {
        for (Equipment equipment : findAll()) {
            entityManager.remove(equipment);
        }
    }

    public List<Equipment> findAll() {
        TypedQuery<Equipment> query = entityManager.createQuery("select x from Equipment x", Equipment.class);
        return query.getResultList();
    }

    public void deleteAllGoods() {
        for (Equipment equipment : findAll()) {
            if(equipment.getItemType() != ItemType.GOODS)
            entityManager.remove(equipment);
        }
    }
}

