package net.homecredit.trainee.repository.shop;

import net.homecredit.trainee.entity.shop.ShopItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ShopRepository {

    private EntityManager entityManager;

    public ShopRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(ShopItem shopItem) {
        entityManager.persist(shopItem);
    }
}
