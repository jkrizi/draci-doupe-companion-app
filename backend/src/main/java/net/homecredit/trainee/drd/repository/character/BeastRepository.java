package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.Beast;

import javax.persistence.EntityManager;

public class BeastRepository {

    private EntityManager entityManager;

    public BeastRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Beast beast) {
        entityManager.persist(beast);
    }
}
