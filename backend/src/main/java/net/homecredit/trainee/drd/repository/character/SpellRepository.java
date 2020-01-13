package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.profession.Spell;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Repository
public class SpellRepository {

    private EntityManager entityManager;

    public SpellRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Spell> findAll() {
        TypedQuery<Spell> query = entityManager.createQuery("select s from Spell s",Spell.class);
        return query.getResultList();
    }

    public void save(Spell newSpell) {
        entityManager.persist(newSpell);
    }

    public void delete(UUID id) {
        entityManager.remove(entityManager.find(Spell.class,id));
    }

    public void update(Spell existingSpell) {
        entityManager.merge(existingSpell);
    }
}
