package net.homecredit.trainee.drd.util.comparator;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.inventory.GemStone;

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
                newBlueprint.isTrained() == databaseBlueprint.isTrained() &&
                newBlueprint.getPugnacity() == databaseBlueprint.getPugnacity() &&
                newBlueprint.getBeastOrigin().equals(databaseBlueprint.getBeastOrigin())  &&
                newBlueprint.getName().equals(databaseBlueprint.getName()) &&
                newBlueprint.getSpecies().equals(databaseBlueprint.getSpecies())  &&
                newBlueprint.getDescription().equals(databaseBlueprint.getDescription())  &&
                newBlueprint.getSize().equals(databaseBlueprint.getSize()) &&
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
