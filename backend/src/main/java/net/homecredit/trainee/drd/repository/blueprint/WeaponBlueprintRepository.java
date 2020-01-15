package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;
import net.homecredit.trainee.drd.util.comparator.WeaponBlueprintComparatorByAttributes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;

@Repository
public class WeaponBlueprintRepository {

    private EntityManager entityManager;

    public WeaponBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(WeaponBlueprint weaponBlueprint) {
        entityManager.persist(weaponBlueprint);
    }

    public WeaponBlueprint find(UUID id) {
        WeaponBlueprint result = entityManager.createQuery(
                "SELECT x FROM WeaponBlueprint x WHERE x.id = ?1", WeaponBlueprint.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (WeaponBlueprint weaponBlueprint : findAll()) {
            entityManager.remove(weaponBlueprint);
        }
    }

    public List<WeaponBlueprint> findAll() {
        TypedQuery<WeaponBlueprint> query = entityManager.createQuery("select x from WeaponBlueprint x", WeaponBlueprint.class);
        return query.getResultList();
    }

    public boolean containsBlueprint(WeaponBlueprint weaponBlueprint) {
        /*NavigableSet<WeaponBlueprint> weaponCache = new TreeSet<>( new WeaponBlueprintComparatorByAttributes());
        weaponCache.addAll(findAll());
        return weaponCache.contains(weaponBlueprint);*/

        WeaponBlueprintComparatorByAttributes comparator = new WeaponBlueprintComparatorByAttributes();
        for (WeaponBlueprint weaponBlueprint1 : findAll()) {
            if (comparator.compare(weaponBlueprint, weaponBlueprint1) == 0) {
                return true;
            }
        }
        return false;
    }
}
