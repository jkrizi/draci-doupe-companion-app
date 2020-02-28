package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.character.profession.wizard.Spell;

import java.util.Comparator;

public class SpellComparatorByAttributes implements Comparator<Spell> {

    @Override
    public int compare(Spell newSpell, Spell databaseSpell) {
        if (newSpell == databaseSpell) return 0;

        //compare every attribute first and if they are same compare gemstones
        if (newSpell.getName().equals(databaseSpell.getName())) {

            //if spells are same then return 0
            System.out.println("spells are same");
            return 0;
        }
        return newSpell.getId().compareTo(databaseSpell.getId());
    }
}
