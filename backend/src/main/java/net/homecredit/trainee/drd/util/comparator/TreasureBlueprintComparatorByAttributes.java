package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.GemStone;

import java.util.*;

public class TreasureBlueprintComparatorByAttributes implements Comparator<TreasureBlueprint> {

    @Override
    public int compare(TreasureBlueprint newBlueprint, TreasureBlueprint databaseBlueprint) {
        if (newBlueprint == databaseBlueprint) return 0;

        //compare every attribute first and if they are same compare gemstones
        if (newBlueprint.getMaterialWeight() == databaseBlueprint.getMaterialWeight() &&
                Double.compare(databaseBlueprint.getTreasureValue(), newBlueprint.getTreasureValue()) == 0 &&
                newBlueprint.getName().equals(databaseBlueprint.getName()) &&
                newBlueprint.getPublicDescription().equals(databaseBlueprint.getPublicDescription()) &&
                newBlueprint.getPrivateDescription().equals(databaseBlueprint.getPrivateDescription()) &&
                newBlueprint.getMaterial() == databaseBlueprint.getMaterial() &&
                newBlueprint.getProductQuality() == databaseBlueprint.getProductQuality()) {

            //if gemstones sizes are different then the sets are not same
            if (newBlueprint.getGemStones().size() != databaseBlueprint.getGemStones().size()) {
                return newBlueprint.getId().compareTo(databaseBlueprint.getId());
            }

            //create two lists of gemstones, one from new blueprint and one from database blueprint
            //sort lists using GemStoneComparator
            //compare every gemstone in one list with a gemstone in other list on the same position
            //because they are sorted we can do that
            GemStoneComparator gemStoneComparator = new GemStoneComparator();
            List<GemStone> newGemStones = new ArrayList<>(newBlueprint.getGemStones());
            List<GemStone> databaseGemStones = new ArrayList<>(databaseBlueprint.getGemStones());
            newGemStones.sort(gemStoneComparator);
            databaseGemStones.sort(gemStoneComparator);

            for (int i = 0; i < newGemStones.size(); i++) {
                if (gemStoneComparator.compare(newGemStones.get(i), databaseGemStones.get(i)) != 0) {
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
