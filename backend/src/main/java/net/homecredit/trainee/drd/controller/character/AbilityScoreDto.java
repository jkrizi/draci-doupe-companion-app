package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.entity.character.ability.Ability;

import java.util.UUID;

public class AbilityScoreDto {

    private UUID id;
    private Ability ability;
    private int abilityValue;
    private int abilityBonusValue;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public int getAbilityValue() {
        return abilityValue;
    }

    public void setAbilityValue(int abilityValue) {
        this.abilityValue = abilityValue;
    }

    public int getAbilityBonusValue() {
        return abilityBonusValue;
    }

    public void setAbilityBonusValue(int abilityBonusValue) {
        this.abilityBonusValue = abilityBonusValue;
    }
}
