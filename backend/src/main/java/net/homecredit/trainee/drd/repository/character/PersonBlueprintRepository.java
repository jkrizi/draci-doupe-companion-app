package net.homecredit.trainee.drd.repository.character;

import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
public class PersonBlueprintRepository {

    private final EntityManager entityManager;

    public PersonBlueprintRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<PersonBlueprint> findAll() {
        return entityManager.createQuery(
                "select distinct pb " +
                        "from PersonBlueprint pb " +
                        "join fetch pb.race r join fetch r.weapon w join fetch w.weaponType.damageType " +
                        "join fetch pb.armorBlueprints pab join fetch pab.armorBlueprint ab join fetch  ab.coverage " +
                        "join fetch pb.weaponBlueprints pwb join fetch pwb.weaponBlueprint wb join fetch wb.weaponFamily wf join fetch wf.weaponType.damageType " +
                        "join fetch pb.treasureBlueprints ptb join fetch ptb.treasureBlueprint tb join fetch tb.gemstones g join fetch g.gemstoneBlueprint " +
                        "join fetch pb.goodsBlueprints pgb join fetch pgb.goodsBlueprint", PersonBlueprint.class)
                .getResultList();
    }

    public void save(PersonBlueprint newPersonBlueprint) {
        entityManager.persist(newPersonBlueprint);
    }

    public void update(PersonBlueprint existingPersonBlueprint) {
        entityManager.merge(existingPersonBlueprint);
    }

    public void delete(UUID id) {
        entityManager.remove(entityManager.find(PersonBlueprint.class, id));
    }
}
