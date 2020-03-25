package net.homecredit.trainee.drd.entity.character;

import net.homecredit.trainee.drd.entity.util.CharacterBlueprintItemBlueprint;

import java.util.Set;

public interface CharacterBlueprint {
    Set<CharacterBlueprintItemBlueprint> getArmorBlueprintsNewSet();

    Set<CharacterBlueprintItemBlueprint> getGoodsBlueprintsNewSet();

    Set<CharacterBlueprintItemBlueprint> getTreasureBlueprintsNewSet();

    Set<CharacterBlueprintItemBlueprint> getWeaponBlueprintsNewSet();
}
