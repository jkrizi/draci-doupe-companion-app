package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BeastBlueprintRepository {

    private EntityManager entityManager;

    public BeastBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveBlueprint(BeastBlueprint blueprint) {
        entityManager.persist(blueprint);
    }

    public List<BeastBlueprint> findAll() {
        TypedQuery<BeastBlueprint> query = entityManager.createQuery(
                "select distinct b " +
                        "from BeastBlueprint b " +
                        "join fetch b.abilityMap " +
                        "join fetch b.size " +
                        "join fetch b.vulnerabilities " +
                        "left join fetch b.beasts " +
                        "join fetch b.inventory i " +
                        "join fetch i.storageUnits u " +
                        "left join fetch u.equipment", BeastBlueprint.class);
        List<BeastBlueprint> beastBlueprints = query.getResultList();
        return beastBlueprints;
    }

    public void deleteBlueprints() {
        for (BeastBlueprint beastBlueprint : findAllBluePrints()) {
            entityManager.remove(beastBlueprint);
        }
    }
}
