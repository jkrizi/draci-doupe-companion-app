package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;

import java.util.Comparator;

public class GemStoneBlueprintComparatorByAttributes implements Comparator<GemstoneBlueprint> {

    @Override
    public int compare(GemstoneBlueprint newBlueprint, GemstoneBlueprint databaseBlueprint) {
        if (newBlueprint == databaseBlueprint) return 0;

        //compare every attribute first and if they are same compare gemstones
        if (newBlueprint.getName().equals(databaseBlueprint.getName()) &&
                newBlueprint.getColor() == databaseBlueprint.getColor()) {

            //if blueprints are same then return 0
            System.out.println("blueprints are same");
            return 0;
        }
        return newBlueprint.getId().compareTo(databaseBlueprint.getId());
    }
}
