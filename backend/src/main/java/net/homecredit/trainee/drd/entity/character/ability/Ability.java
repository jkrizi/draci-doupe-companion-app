package net.homecredit.trainee.drd.entity.character.ability;

import java.util.HashMap;
import java.util.Map;

public enum Ability {
    STRENGTH, DEXTERITY, RESISTANCE, INTELLIGENCE, CHARISMA;

    @Override
    public String toString() {
        String ability = this.name().toLowerCase();

        return ability.substring(0,1).toUpperCase() + ability.substring(1);
    }

    public Map<Ability,Integer> composeAbilityIntegerMap (int strength, int dexterity, int resistance, int intelligence, int charisma) {
        Map<Ability,Integer> map = new HashMap<>();
        map.put(Ability.STRENGTH, strength);
        map.put(Ability.DEXTERITY, dexterity);
        map.put(Ability.RESISTANCE, resistance);
        map.put(Ability.INTELLIGENCE, intelligence);
        map.put(Ability.CHARISMA, charisma);
        return map;
    }
}

