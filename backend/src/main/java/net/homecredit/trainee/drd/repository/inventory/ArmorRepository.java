package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.armor.Armor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ArmorRepository {
    private EntityManager entityManager;

    public ArmorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Armor armor) {
        entityManager.persist(armor);
    }

    public void deleteAll() {
        for (Armor armor : findAll()) {
            entityManager.remove(armor);
        }
    }

    public List<Armor> findAll() {
        TypedQuery<Armor> query = entityManager.createQuery("select distinct x from Armor x", Armor.class);
        return query.getResultList();
    }

}
