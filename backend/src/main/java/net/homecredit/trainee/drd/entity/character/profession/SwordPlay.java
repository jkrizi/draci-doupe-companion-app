package net.homecredit.trainee.drd.entity.character.profession;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class SwordPlay {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "WARRIOR_KNOWHOW")
    private WarriorKnowHow warriorKnowHow;
    @ManyToOne
    @JoinColumn(name = "SWORDPLAY_MOVE")
    private SwordPlayMove swordPlayMove;

    public SwordPlay() {
    }

    public SwordPlay(UUID id, WarriorKnowHow warriorKnowHow, SwordPlayMove swordPlayMove) {
        this.id = UUID.randomUUID();
        this.warriorKnowHow = warriorKnowHow;
        this.swordPlayMove = swordPlayMove;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public WarriorKnowHow getWarriorKnowHow() {
        return warriorKnowHow;
    }

    public void setWarriorKnowHow(WarriorKnowHow warriorKnowHow) {
        this.warriorKnowHow = warriorKnowHow;
    }

    public SwordPlayMove getSwordPlayMove() {
        return swordPlayMove;
    }

    public void setSwordPlayMove(SwordPlayMove swordPlayMove) {
        this.swordPlayMove = swordPlayMove;
    }
}
