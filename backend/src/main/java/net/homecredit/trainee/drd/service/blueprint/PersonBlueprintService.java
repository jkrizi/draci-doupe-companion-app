package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.PersonBlueprint;
import net.homecredit.trainee.drd.entity.character.Person;
import net.homecredit.trainee.drd.entity.character.profession.Profession;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.entity.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class PersonBlueprintService {

    public PersonBlueprint drawBlueprint(String name, String description, int level, Race race, Profession profession, Inventory inventory) {
        List<Person> personList = new ArrayList<>();

        return new PersonBlueprint(name, description, level, race, profession, inventory, personList);
    }
}
