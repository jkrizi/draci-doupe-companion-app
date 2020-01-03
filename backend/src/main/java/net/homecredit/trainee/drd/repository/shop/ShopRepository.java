package net.homecredit.trainee.drd.repository.shop;

import net.homecredit.trainee.drd.entity.shop.ShopItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class ShopRepository {

    private EntityManager entityManager;

    public ShopRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(ShopItem shopItem) {
        entityManager.persist(shopItem);
    }

    public ShopItem find(UUID id) {
        ShopItem result = entityManager.createQuery(
                "SELECT x FROM ShopItem x WHERE x.id = ?1", ShopItem.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (ShopItem shopItem : findAll()) {
            entityManager.remove(shopItem);
        }
    }

    public List<ShopItem> findAll() {
        TypedQuery<ShopItem> query = entityManager.createQuery("select x from ShopItem x", ShopItem.class);
        return query.getResultList();
    }
}
