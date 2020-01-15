package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GemStoneBlueprint;
import net.homecredit.trainee.drd.entity.inventory.GemStone;
import net.homecredit.trainee.drd.util.comparator.GemStoneBlueprintComparatorByAttributes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;

@Repository
public class GemStoneBlueprintRepository {

    private EntityManager entityManager;

    public GemStoneBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(GemStoneBlueprint gemStoneBlueprint) {
        entityManager.persist(gemStoneBlueprint);
    }

    public GemStoneBlueprint find(UUID id) {
        GemStoneBlueprint result = entityManager.createQuery(
                "SELECT x FROM GemStoneBlueprint x WHERE x.id = ?1", GemStoneBlueprint.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (GemStoneBlueprint gemStoneBlueprint : findAll()) {
            entityManager.remove(gemStoneBlueprint);
        }
    }

    public List<GemStoneBlueprint> findAll() {
        TypedQuery<GemStoneBlueprint> query = entityManager.createQuery("select x from GemStoneBlueprint x", GemStoneBlueprint.class);
        return query.getResultList();
    }

    public boolean containsBlueprint(GemStoneBlueprint gemStoneBlueprint) {
        /*NavigableSet<GemStoneBlueprint> gemStoneCache = new TreeSet<>( new GemStoneBlueprintComparatorByAttributes());
        gemStoneCache.addAll(findAll());
//        System.out.println(gemStoneCache.size());
        return gemStoneCache.contains(gemStoneBlueprint);*/
        GemStoneBlueprintComparatorByAttributes comparator = new GemStoneBlueprintComparatorByAttributes();
        for (GemStoneBlueprint gemStoneBlueprint1 : findAll()) {
            if (comparator.compare(gemStoneBlueprint, gemStoneBlueprint1) == 0) {
                return true;
            }
        }
        return false;
    }
}
