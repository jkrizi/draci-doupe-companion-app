package net.homecredit.trainee.drd.entity.character.skill;

import net.homecredit.trainee.drd.entity.character.ability.Ability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

}
