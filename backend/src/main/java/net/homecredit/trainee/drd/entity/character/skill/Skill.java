package net.homecredit.trainee.drd.entity.character.skill;

import net.homecredit.trainee.drd.entity.character.ability.Ability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Skill {

    @Id
    private UUID id;
    private String name;

    private SkillDifficulty difficulty;
    private Ability ability;

    @Column(name = "full_success")
    private String fullSuccess;
    @Column(name = "success")
    private String success;
    @Column(name = "failure")
    private String failure;
    @Column(name = "fatal_failure")
    private String fatalFailure;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return id.equals(skill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", ability=" + ability +
                ", fullSuccess='" + fullSuccess + '\'' +
                ", success='" + success + '\'' +
                ", failure='" + failure + '\'' +
                ", fatalFailure='" + fatalFailure + '\'' +
                '}';
    }
}
