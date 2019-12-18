package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BeastBlueprintRepository {

    private EntityManager entityManager;

    public BeastBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveBlueprint(BeastBlueprint blueprint) {
        entityManager.persist(blueprint);
    }

    public List<BeastBlueprint> findAllBluePrints() {
        TypedQuery<BeastBlueprint> query = entityManager.createQuery("select b from BeastBlueprint b", BeastBlueprint.class);
        return query.getResultList();
    }

    public void deleteBlueprint(BeastBlueprint blueprint) {
        entityManager.remove(blueprint);
    }
}
