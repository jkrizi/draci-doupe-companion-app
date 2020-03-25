package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;

import java.util.*;

public class BeastBlueprintComparatorByAttributes implements Comparator<BeastBlueprint> {

    @Override
    public int compare(BeastBlueprint newBlueprint, BeastBlueprint databaseBlueprint) {
        if (newBlueprint == databaseBlueprint) return 0;

        //compare every attribute first and if they are same compare gemstones
        //doesn't work yet for ability maps, inventory and combat values
        if (
                newBlueprint.getViability() == databaseBlueprint.getViability() &&
                newBlueprint.getViabilityBonus() == databaseBlueprint.getViabilityBonus() &&
                newBlueprint.getManna() == databaseBlueprint.getManna() &&
                newBlueprint.getMobility() == databaseBlueprint.getMobility() &&
                newBlueprint.getPugnacity() == databaseBlueprint.getPugnacity() &&
                newBlueprint.getPersistence() == databaseBlueprint.getPersistence() &&
                newBlueprint.getDomestication() == databaseBlueprint.getDomestication() &&
                newBlueprint.isSchooled() == databaseBlueprint.isSchooled() &&
                newBlueprint.getPugnacity() == databaseBlueprint.getPugnacity() &&
                newBlueprint.getOrigin().equals(databaseBlueprint.getOrigin())  &&
                newBlueprint.getName().equals(databaseBlueprint.getName()) &&
                newBlueprint.getSpecies().equals(databaseBlueprint.getSpecies())  &&
                newBlueprint.getDescription().equals(databaseBlueprint.getDescription())  &&
                newBlueprint.getSizes().equals(databaseBlueprint.getSizes()) &&
                newBlueprint.getVulnerabilities().equals(databaseBlueprint.getVulnerabilities())
//                newBlueprint.getAbilityMap().equals(abilities) &&
//                newBlueprint.getInventory().equals(databaseBlueprint.getInventory())  &&
//                newBlueprint.getCombatValues().equals(databaseBlueprint.getCombatValues())
        ) {
            //if blueprints are same and gemstones are same then return 0
            System.out.println("blueprints are same");
            return 0;
        }
        //blueprints dont match
        return newBlueprint.getId().compareTo(databaseBlueprint.getId());
    }
}
