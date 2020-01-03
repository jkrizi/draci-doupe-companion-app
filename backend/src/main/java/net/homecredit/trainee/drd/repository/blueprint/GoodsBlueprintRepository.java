package net.homecredit.trainee.drd.repository.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GoodsBlueprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
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
}
