package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.person.profession.warrior.SwordMove;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class SwordMoveRepository {

    private final EntityManager entityManager;

    public SwordMoveRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<SwordMove> findAll() {
        TypedQuery<SwordMove> query = entityManager.createQuery(
                "select distinct sm from SwordMove sm " +
                        "join fetch sm.allowedUserWeapons uw " +
                        "join fetch uw.weaponType uwt " +
                        "join fetch uwt.damageType " +
                        "join fetch sm.allowedOpponentWeapons ow " +
                        "join fetch ow.weaponType owt " +
                        "join fetch owt.damageType",SwordMove.class);
        return query.getResultList();
    }

    public void save(SwordMove newSwordMove) {
        entityManager.persist(newSwordMove);
    }

    public void delete(UUID id) {
        entityManager.remove(entityManager.find(SwordMove.class,id));
    }

    public void update(SwordMove existingSwordMove) {
        entityManager.merge(existingSwordMove);
    }
}
