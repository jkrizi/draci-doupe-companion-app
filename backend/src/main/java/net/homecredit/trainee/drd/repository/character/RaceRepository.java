package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.race.Race;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class RaceRepository {

    private EntityManager entityManager;

    public RaceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Race> findAll() {
        TypedQuery<Race> query = entityManager.createQuery("select r from Race r", Race.class);
        return query.getResultList();
    }

    public void save(Race newRace) {
        entityManager.persist(newRace);
    }

    public void update(Race existingRace) {
        entityManager.merge(existingRace);
    }

    public void delete(UUID id) {
        entityManager.remove(entityManager.find(Race.class,id));
    }
}
