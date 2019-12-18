package net.homecredit.trainee.repository.blueprint;

import net.homecredit.trainee.entity.blueprint.item.ArmorBlueprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.UUID;

@Repository
public class ArmorBlueprintRepository {

    private EntityManager entityManager;

    public ArmorBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(ArmorBlueprint armorBlueprint) {
        entityManager.persist(armorBlueprint);
    }

    public ArmorBlueprint find(UUID id) {
        ArmorBlueprint result = entityManager.createQuery(
                "SELECT x FROM ArmorBlueprint x WHERE x.id = ?1", ArmorBlueprint.class )
                .setParameter( 1, id ).getSingleResult();
        return  result;
    }
}
