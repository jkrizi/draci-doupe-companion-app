package net.homecredit.trainee.drd.entity.character.person.profession.ranger;

import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.profession.ProfessionKnowHow;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RangerKnowHow extends ProfessionKnowHow {

    @Column(name = "PYROKINESIS_LEVEL_LEARNED")
    private int pyrokinesisLevelLearned;
    @Column(name = "TELEKINESIS_LEVEL_LEARNED")
    private int telekinesisLevelLearned;
    @Column(name = "TELEPATHY_LEVEL_LEARNED")
    private int telepathyLevelLearned;

    public RangerKnowHow() {
    }

    public RangerKnowHow(Profession profession, int pyrokinesisLevelLearned, int telekinesisLevelLearned, int telepathyLevelLearned) {
        super(profession);
        this.pyrokinesisLevelLearned = pyrokinesisLevelLearned;
        this.telekinesisLevelLearned = telekinesisLevelLearned;
        this.telepathyLevelLearned = telepathyLevelLearned;
    }

    public int getPyrokinesisLevelLearned() {
        return pyrokinesisLevelLearned;
    }

    public void setPyrokinesisLevelLearned(int pyrokinesisLevelLearned) {
        this.pyrokinesisLevelLearned = pyrokinesisLevelLearned;
    }

    public int getTelekinesisLevelLearned() {
        return telekinesisLevelLearned;
    }

    public void setTelekinesisLevelLearned(int telekinesisLevelLearned) {
        this.telekinesisLevelLearned = telekinesisLevelLearned;
    }

    public int getTelepathyLevelLearned() {
        return telepathyLevelLearned;
    }

    public void setTelepathyLevelLearned(int telepathyLevelLearned) {
        this.telepathyLevelLearned = telepathyLevelLearned;
    }
}
