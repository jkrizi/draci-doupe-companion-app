package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GoodsBlueprint;
import net.homecredit.trainee.drd.util.comparator.GoodsBlueprintComparatorByAttributes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;

@Repository
public class GoodsBlueprintRepository {

    private EntityManager entityManager;

    public GoodsBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(GoodsBlueprint goodsBlueprint) {
        entityManager.persist(goodsBlueprint);
    }

    public GoodsBlueprint find(UUID id) {
        GoodsBlueprint result = entityManager.createQuery(
                "SELECT x FROM GoodsBlueprint x WHERE x.id = ?1", GoodsBlueprint.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (GoodsBlueprint goodsBlueprint : findAll()) {
            entityManager.remove(goodsBlueprint);
        }
    }

    public List<GoodsBlueprint> findAll() {
        TypedQuery<GoodsBlueprint> query = entityManager.createQuery("select x from GoodsBlueprint x", GoodsBlueprint.class);
        return query.getResultList();
    }

    public boolean containsBlueprint(GoodsBlueprint goodsBlueprint) {
        /*NavigableSet<GoodsBlueprint> goodsCache = new TreeSet<>( new GoodsBlueprintComparatorByAttributes());
        goodsCache.addAll(findAll());
        return goodsCache.contains(goodsBlueprint);*/
        GoodsBlueprintComparatorByAttributes comparator = new GoodsBlueprintComparatorByAttributes();
        for (GoodsBlueprint goodsBlueprint1 : findAll()) {
            if (comparator.compare(goodsBlueprint, goodsBlueprint1) == 0) {
                return true;
            }
        }
        return false;
    }
}
