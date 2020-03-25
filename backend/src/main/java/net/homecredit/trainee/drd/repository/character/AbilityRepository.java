package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AbilityRepository {

    private final EntityManager entityManager;

    public AbilityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(AbilityScore abilityScore) {
        entityManager.persist(abilityScore);
    }
}
