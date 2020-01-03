package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class TreasureBlueprintRepository {

    private EntityManager entityManager;

    public TreasureBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(TreasureBlueprint treasureBlueprint) {
        entityManager.persist(treasureBlueprint);
    }

    public TreasureBlueprint find(UUID id) {
        TreasureBlueprint result = entityManager.createQuery(
                "SELECT x FROM TreasureBlueprint x WHERE x.id = ?1", TreasureBlueprint.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (TreasureBlueprint treasureBlueprint : findAll()) {
            entityManager.remove(treasureBlueprint);
        }
    }

    public List<TreasureBlueprint> findAll() {
        TypedQuery<TreasureBlueprint> query = entityManager.createQuery("select x from TreasureBlueprint x", TreasureBlueprint.class);
        return query.getResultList();
    }
}
