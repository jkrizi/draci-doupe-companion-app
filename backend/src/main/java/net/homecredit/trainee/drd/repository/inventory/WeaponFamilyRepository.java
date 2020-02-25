package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;

import javax.persistence.EntityManager;
import java.util.List;

public class WeaponFamilyRepository {

    private EntityManager entityManager;

    public WeaponFamilyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<WeaponFamily> findAll() {
        return entityManager
                .createQuery(
                        "select distinct x from WeaponFamily x " +
                                "join fetch x.weaponType y " +
                                "join fetch y.damageType", WeaponFamily.class
                ).getResultList();
    }

    public void save(WeaponFamily newWeaponFamily) {
        entityManager.persist(newWeaponFamily);
    }
}
