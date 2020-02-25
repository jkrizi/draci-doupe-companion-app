package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;
import net.homecredit.trainee.drd.util.comparator.GemStoneBlueprintComparatorByAttributes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class GemstoneBlueprintRepository {

    private EntityManager entityManager;

    public GemstoneBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(GemstoneBlueprint gemStoneBlueprint) {
        entityManager.persist(gemStoneBlueprint);
    }

    public GemstoneBlueprint find(UUID id) {
        GemstoneBlueprint result = entityManager.createQuery(
                "SELECT x FROM GemstoneBlueprint x WHERE x.id = ?1", GemstoneBlueprint.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (GemstoneBlueprint gemStoneBlueprint : findAll()) {
            entityManager.remove(gemStoneBlueprint);
        }
    }

    public List<GemstoneBlueprint> findAll() {
        TypedQuery<GemstoneBlueprint> query = entityManager.createQuery("select x from GemstoneBlueprint x", GemstoneBlueprint.class);
        return query.getResultList();
    }

    public boolean containsBlueprint(GemstoneBlueprint gemStoneBlueprint) {
        /*NavigableSet<GemstoneBlueprint> gemStoneCache = new TreeSet<>( new GemStoneBlueprintComparatorByAttributes());
        gemStoneCache.addAll(findAll());
//        System.out.println(gemStoneCache.size());
        return gemStoneCache.contains(gemStoneBlueprint);*/
        GemStoneBlueprintComparatorByAttributes comparator = new GemStoneBlueprintComparatorByAttributes();
        for (GemstoneBlueprint gemstoneBlueprint1 : findAll()) {
            if (comparator.compare(gemStoneBlueprint, gemstoneBlueprint1) == 0) {
                return true;
            }
        }
        return false;
    }
}
