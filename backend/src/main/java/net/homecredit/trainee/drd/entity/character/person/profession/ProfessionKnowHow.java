package net.homecredit.trainee.drd.entity.character.person.profession;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PROFESSION_KNOWHOW")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProfessionKnowHow {

    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Profession profession;

    public ProfessionKnowHow() {
    }

    public ProfessionKnowHow(Profession profession) {
        this.id = UUID.randomUUID();
        this.profession = profession;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
