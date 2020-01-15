package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.blueprint.item.GemStoneBlueprint;

import java.util.Comparator;

public class GemStoneBlueprintComparatorByAttributes implements Comparator<GemStoneBlueprint> {

    @Override
    public int compare(GemStoneBlueprint newBlueprint, GemStoneBlueprint databaseBlueprint) {
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
