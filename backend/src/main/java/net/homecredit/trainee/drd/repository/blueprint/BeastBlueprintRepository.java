package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.util.comparator.BeastBlueprintComparatorByAttributes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                "select distinct bb " +
                        "from BeastBlueprint bb " +
                        "join fetch bb.abilityMap " +
                        "join fetch bb.sizes " +
                        "join fetch bb.vulnerabilities " +
                        "left join fetch bb.beasts b " +
                        "join fetch b.inventory ib " +
                        "join fetch ib.storageUnits ub " +
                        "left join fetch ub.equipment " +
                        "join fetch bb.inventory ibb " +
                        "join fetch ibb.storageUnits ubb " +
                        "left join fetch ubb.equipment", BeastBlueprint.class);
        List<BeastBlueprint> beastBlueprints = query.getResultList();
        return beastBlueprints;
    }

    public void deleteAll() {
        for (BeastBlueprint beastBlueprint : findAll()) {
            entityManager.remove(beastBlueprint);
        }
    }

    public boolean containsBlueprint(BeastBlueprint beastBlueprint) {
        BeastBlueprintComparatorByAttributes comparator = new BeastBlueprintComparatorByAttributes();
        for (BeastBlueprint beastBlueprint1 : findAll()) {
            if (comparator.compare(beastBlueprint, beastBlueprint1) == 0) {
                return true;
            }
        }
        return false;
    }
}
