package net.homecredit.trainee.repository.character;

import net.homecredit.trainee.entity.character.Beast;

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
