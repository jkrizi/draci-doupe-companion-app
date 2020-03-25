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
                        "left join fetch pb.armorBlueprints pab left join fetch pab.armorBlueprint ab left join fetch  ab.coverage " +
                        "left join fetch pb.weaponBlueprints pwb left join fetch pwb.weaponBlueprint wb left join fetch wb.weaponFamily wf left join fetch wf.weaponType.damageType " +
                        "left join fetch pb.treasureBlueprints ptb left join fetch ptb.treasureBlueprint tb left join fetch tb.gemstones g left join fetch g.gemstoneBlueprint " +
                        "left join fetch pb.goodsBlueprints pgb left join fetch pgb.goodsBlueprint", PersonBlueprint.class)
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
