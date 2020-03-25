package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;

import java.util.Comparator;

public class ArmorBlueprintComparatorByAttributes implements Comparator<ArmorBlueprint> {

    @Override
    public int compare(ArmorBlueprint newBlueprint, ArmorBlueprint databaseBlueprint) {
        if (newBlueprint == databaseBlueprint) return 0;

        //compare every attribute first and if they are same compare gemstones
        if (newBlueprint.getName().equals(databaseBlueprint.getName()) &&
            newBlueprint.getPublicDescription().equals(databaseBlueprint.getPublicDescription()) &&
            newBlueprint.getPrivateDescription().equals(databaseBlueprint.getPrivateDescription()) &&
            newBlueprint.getCoverage().equals(databaseBlueprint.getCoverage()) &&
            newBlueprint.getWeight() == databaseBlueprint.getWeight() &&
            newBlueprint.getDefense() == databaseBlueprint.getDefense()) {

            //if blueprints are same then return 0
            System.out.println("blueprints are same");
            return 0;
        }
        return newBlueprint.getId().compareTo(databaseBlueprint.getId());
    }
}
