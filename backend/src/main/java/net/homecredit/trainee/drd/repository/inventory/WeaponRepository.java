package net.homecredit.trainee.repository.inventory;

import net.homecredit.trainee.entity.inventory.weapon.Weapon;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class WeaponRepository {

    private EntityManager entityManager;

    public WeaponRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Weapon weapon) {
        entityManager.persist(weapon);
    }
}
