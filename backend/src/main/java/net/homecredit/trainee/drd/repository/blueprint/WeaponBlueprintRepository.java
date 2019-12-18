package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
                "SELECT x FROM WeaponBlueprint x WHERE x.id = ?1", WeaponBlueprint.class )
                .setParameter( 1, id ).getSingleResult();
        return  result;
    }
}
