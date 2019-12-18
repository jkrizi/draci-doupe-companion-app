package net.homecredit.trainee.drd.entity.character.profession;

import net.homecredit.trainee.drd.entity.character.ability.Ability;

import java.util.HashMap;
import java.util.Map;

public enum Profession {
    WARRIOR(10, 10, 0, 2, Ability.STRENGTH, 12, Ability.RESISTANCE, 12),
    FIGHTER(10, 10, 0, 2, Ability.STRENGTH, 12, Ability.RESISTANCE, 12),
    SWORDSMAN(10, 10, 0, 2, Ability.STRENGTH, 12, Ability.RESISTANCE, 12),
    RANGER(8, 6, 2, 2, Ability.STRENGTH, 10, Ability.INTELLIGENCE, 11),
    DRUID(8, 6, 2, 2, Ability.STRENGTH, 10, Ability.INTELLIGENCE, 11),
    STRIDER(8, 6, 2, 2, Ability.STRENGTH, 10, Ability.INTELLIGENCE, 11),
    ALCHEMIST(7, 6, 1, 1, Ability.DEXTERITY, 12, Ability.RESISTANCE, 11),
    THEURGIST(7, 6, 1, 1, Ability.DEXTERITY, 12, Ability.RESISTANCE, 11),
    PYROFOR(7, 6, 1, 1, Ability.DEXTERITY, 12, Ability.RESISTANCE, 11),
    WIZARD(6, 6, 0, 1, Ability.INTELLIGENCE, 13, Ability.CHARISMA, 12),
    SORCERER(6, 6, 0, 1, Ability.INTELLIGENCE, 13, Ability.CHARISMA, 12),
    MAGE(6, 6, 0, 1, Ability.INTELLIGENCE, 13, Ability.CHARISMA, 12),
    THIEF(6, 6, 0, 1, Ability.DEXTERITY, 13, Ability.CHARISMA, 11),
    BURGLAR(6, 6, 0, 1, Ability.DEXTERITY, 13, Ability.CHARISMA, 11),
    SICCO(6, 6, 0, 1, Ability.DEXTERITY, 13, Ability.CHARISMA, 11);

    private int baseLife;
    private int lifeDice;
    private int lifeBonus;
    private int lifeGain;
    private Map<Ability, Integer> dominantAbilities;

    Profession(int baseLife, int lifeDice, int lifeBonus, int lifeGain, Ability firstDominantAbility, int firstAbilityValue, Ability secondDominantAbility, int secondAbilityValue) {
        this.baseLife = baseLife;
        this.lifeDice = lifeDice;
        this.lifeBonus = lifeBonus;
        this.lifeGain = lifeGain;
        Map<Ability, Integer> dominantAbilities = new HashMap<>();
        dominantAbilities.put(firstDominantAbility, firstAbilityValue);
        dominantAbilities.put(secondDominantAbility, secondAbilityValue);
        this.dominantAbilities = dominantAbilities;
    }

    public int getBaseLife() {
        return baseLife;
    }

    public int getLifeDice() {
        return lifeDice;
    }

    public int getLifeBonus() {
        return lifeBonus;
    }

    public int getLifeGain() {
        return lifeGain;
    }

    public Map<Ability, Integer> getDominantAbilities() {
        return dominantAbilities;
    }
}
