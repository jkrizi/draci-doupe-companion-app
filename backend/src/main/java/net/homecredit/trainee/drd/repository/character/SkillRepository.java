package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.person.skill.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
public class SkillRepository {

    private final EntityManager entityManager;

    public SkillRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Skill> findAll() {
        return entityManager
                .createQuery("select s from Skill s", Skill.class)
                .getResultList();
    }

    public void update(Skill existingSkill) {
        entityManager.merge(existingSkill);
    }

    public void delete(UUID id) {
        entityManager.remove(findById(id));
    }

    private Skill findById(UUID id) {
        return entityManager.find(Skill.class, id);
    }


    public void save(Skill newSkill) {
        entityManager.persist(newSkill);
    }
}
