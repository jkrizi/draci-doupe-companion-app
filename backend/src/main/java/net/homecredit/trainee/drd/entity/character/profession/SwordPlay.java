package net.homecredit.trainee.drd.entity.character.profession;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class SwordPlay {

    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WARRIOR_KNOWHOW")
    private WarriorKnowHow warriorKnowHow;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SWORDPLAY_MOVE")
    private SwordMove swordMove;

    public SwordPlay() {
    }

    public SwordPlay(UUID id, WarriorKnowHow warriorKnowHow, SwordMove swordMove) {
        this.id = UUID.randomUUID();
        this.warriorKnowHow = warriorKnowHow;
        this.swordMove = swordMove;
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

    public SwordMove getSwordMove() {
        return swordMove;
    }

    public void setSwordMove(SwordMove swordMove) {
        this.swordMove = swordMove;
    }
}
