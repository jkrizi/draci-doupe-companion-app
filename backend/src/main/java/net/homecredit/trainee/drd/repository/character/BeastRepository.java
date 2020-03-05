package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.beast.Beast;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class BeastRepository {

    private EntityManager entityManager;

    public BeastRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Beast beast) {
        entityManager.persist(beast);
    }

    public Beast find(UUID id) {
        Beast result = entityManager.createQuery(
                "SELECT x FROM Beast x WHERE x.id = ?1", Beast.class)
                .setParameter(1, id).getSingleResult();
        return result;
    }

    public void deleteAll() {
        for (Beast beast : findAll()) {
            entityManager.remove(beast);
        }
    }

    public List<Beast> findAll() {
        TypedQuery<Beast> query = entityManager.createQuery("select x from Beast x join fetch x.beastBlueprint join fetch x.inventory i join fetch i.storageUnits s left join fetch s.equipment", Beast.class);
        return query.getResultList();
    }
}
