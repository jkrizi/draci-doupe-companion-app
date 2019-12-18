package net.homecredit.trainee.repository.blueprint;

import net.homecredit.trainee.entity.blueprint.item.GoodsBlueprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
                "SELECT x FROM GoodsBlueprint x WHERE x.id = ?1", GoodsBlueprint.class )
        .setParameter( 1, id ).getSingleResult();
        return  result;
    }
}
