package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
public class WeaponFamilyRepository {

    private EntityManager entityManager;

    public WeaponFamilyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<WeaponFamily> findAll() {
        return entityManager
                .createQuery(
                        "select distinct x " +
                                "from WeaponFamily x " +
                                "join fetch x.weaponType.damageType ", WeaponFamily.class
                )
                .getResultList();
    }

    public WeaponFamily findById(UUID id) {
        return entityManager
                .createQuery(
                        "SELECT x " +
                                "FROM WeaponFamily x " +
                                "join fetch x.weaponType.damageType " +
                                "WHERE x.id = ?1", WeaponFamily.class
                )
                .setParameter(1, id)
                .getSingleResult();
    }

    public void save(WeaponFamily newWeaponFamily) {
        entityManager.persist(newWeaponFamily);
    }
}
