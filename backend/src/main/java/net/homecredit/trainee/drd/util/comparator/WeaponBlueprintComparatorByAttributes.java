package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;

import java.util.Comparator;

public class WeaponBlueprintComparatorByAttributes implements Comparator<WeaponBlueprint> {

    @Override
    public int compare(WeaponBlueprint newBlueprint, WeaponBlueprint databaseBlueprint) {
        if (newBlueprint == databaseBlueprint) return 0;

        //compare every attribute first and if they are same compare gemstones
        if (newBlueprint.getName().equals(databaseBlueprint.getName()) &&
            newBlueprint.getPublicDescription().equals(databaseBlueprint.getPublicDescription()) &&
            newBlueprint.getPrivateDescription().equals(databaseBlueprint.getPrivateDescription()) &&
            newBlueprint.getWeight() == databaseBlueprint.getWeight() &&
            newBlueprint.getDefense() == databaseBlueprint.getDefense() &&
            newBlueprint.getAttack() == databaseBlueprint.getAttack() &&
            newBlueprint.getHurt() == databaseBlueprint.getHurt() &&
            newBlueprint.getInitiativeModifier() == databaseBlueprint.getInitiativeModifier() &&
            newBlueprint.getShortRangeLimit() == databaseBlueprint.getShortRangeLimit() &&
            newBlueprint.getMidRangeLimit() == databaseBlueprint.getMidRangeLimit() &&
            newBlueprint.getLongRangeLimit() == databaseBlueprint.getLongRangeLimit() &&
            newBlueprint.getMinReach() == databaseBlueprint.getMinReach() &&
            newBlueprint.getMaxReach() == databaseBlueprint.getMaxReach() &&
            newBlueprint.getWeaponFamily().equals(databaseBlueprint.getWeaponFamily())) {

            //if blueprints are same then return 0
            return 0;
        }
        return newBlueprint.getId().compareTo(databaseBlueprint.getId());
    }
}
