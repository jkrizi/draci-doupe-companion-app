package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.person.skill.SkillDifficulty;

import java.util.UUID;

public class SkillDto {

    private UUID id;
    private String name;

    private SkillDifficulty difficulty;
    private Ability ability;

    private String fullSuccess;
    private String success;
    private String failure;
    private String fatalFailure;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(SkillDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public String getFullSuccess() {
        return fullSuccess;
    }

    public void setFullSuccess(String fullSuccess) {
        this.fullSuccess = fullSuccess;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public String getFatalFailure() {
        return fatalFailure;
    }

    public void setFatalFailure(String fatalFailure) {
        this.fatalFailure = fatalFailure;
    }
}
