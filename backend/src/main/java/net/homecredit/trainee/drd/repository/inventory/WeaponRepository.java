package net.homecredit.trainee.drd.repository.inventory;

import net.homecredit.trainee.drd.entity.inventory.weapon.Weapon;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class WeaponRepository {

    private EntityManager entityManager;

    public WeaponRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Weapon weapon) {
        entityManager.persist(weapon);
    }

    public void deleteAll() {
        for (Weapon weapon : findAll()) {
            entityManager.remove(weapon);
        }
    }

    public List<Weapon> findAll() {
        TypedQuery<Weapon> query = entityManager.createQuery("select x from Weapon x", Weapon.class);
        return query.getResultList();
    }
}
