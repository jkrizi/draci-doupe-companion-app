package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;

import java.util.Comparator;

public class GoodsBlueprintComparatorByAttributes implements Comparator<GoodsBlueprint> {

    @Override
    public int compare(GoodsBlueprint newBlueprint, GoodsBlueprint databaseBlueprint) {
        if (newBlueprint == databaseBlueprint) return 0;

        //compare every attribute first and if they are same compare gemstones
        if (newBlueprint.getName().equals(databaseBlueprint.getName()) &&
            newBlueprint.getPublicDescription().equals(databaseBlueprint.getPublicDescription()) &&
            newBlueprint.getPrivateDescription().equals(databaseBlueprint.getPrivateDescription()) &&
            newBlueprint.getWeight() == databaseBlueprint.getWeight() &&
            newBlueprint.getItemType() == databaseBlueprint.getItemType()) {

            //if blueprints are same then return 0
            return 0;
        }
        return newBlueprint.getId().compareTo(databaseBlueprint.getId());
    }
}
