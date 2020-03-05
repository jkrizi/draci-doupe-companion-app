package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.Gemstone;

import java.util.*;

public class TreasureBlueprintComparatorByAttributes implements Comparator<TreasureBlueprint> {

    @Override
    public int compare(TreasureBlueprint newBlueprint, TreasureBlueprint databaseBlueprint) {
        if (newBlueprint == databaseBlueprint) return 0;

        //compare every attribute first and if they are same compare gemstones
        if (newBlueprint.getMaterialWeight() == databaseBlueprint.getMaterialWeight() &&
                Double.compare(databaseBlueprint.getGoldValue(), newBlueprint.getGoldValue()) == 0 &&
                Double.compare(databaseBlueprint.getSilverValue(), newBlueprint.getSilverValue()) == 0 &&
                Double.compare(databaseBlueprint.getCopperValue(), newBlueprint.getCopperValue()) == 0 &&
                newBlueprint.getName().equals(databaseBlueprint.getName()) &&
                newBlueprint.getPublicDescription().equals(databaseBlueprint.getPublicDescription()) &&
                newBlueprint.getPrivateDescription().equals(databaseBlueprint.getPrivateDescription()) &&
                newBlueprint.getMaterial() == databaseBlueprint.getMaterial() &&
                newBlueprint.getProductQuality() == databaseBlueprint.getProductQuality()) {

            //if gemstones sizes are different then the sets are not same
            if (newBlueprint.getGemstones().size() != databaseBlueprint.getGemstones().size()) {
                return newBlueprint.getId().compareTo(databaseBlueprint.getId());
            }

            //create two lists of gemstones, one from new blueprint and one from database blueprint
            //sort lists using GemStoneComparator
            //compare every gemstone in one list with a gemstone in other list on the same position
            //because they are sorted we can do that
            GemStoneComparator gemStoneComparator = new GemStoneComparator();
            List<Gemstone> newGemstones = new ArrayList<>(newBlueprint.getGemstones());
            List<Gemstone> databaseGemstones = new ArrayList<>(databaseBlueprint.getGemstones());
            newGemstones.sort(gemStoneComparator);
            databaseGemstones.sort(gemStoneComparator);

            for (int i = 0; i < newGemstones.size(); i++) {
                if (gemStoneComparator.compare(newGemstones.get(i), databaseGemstones.get(i)) != 0) {
                    //if there is a different gemstone
                    return newBlueprint.getId().compareTo(databaseBlueprint.getId());
                }
            }
            //if blueprints are same and gemstones are same then return 0
            return 0;
        }
        return newBlueprint.getId().compareTo(databaseBlueprint.getId());
    }
}
