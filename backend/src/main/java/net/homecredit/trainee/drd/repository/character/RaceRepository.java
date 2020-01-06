package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.race.Race;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
}
