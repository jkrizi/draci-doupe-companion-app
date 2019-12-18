package net.homecredit.trainee.service.blueprint;

import net.homecredit.trainee.entity.blueprint.PersonBlueprint;
import net.homecredit.trainee.entity.character.Person;
import net.homecredit.trainee.entity.character.profession.Profession;
import net.homecredit.trainee.entity.character.race.Race;
import net.homecredit.trainee.entity.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class PersonBlueprintService {

    public PersonBlueprint drawBlueprint(String name, String description, int level, Race race, Profession profession, Inventory inventory) {
        List<Person> personList = new ArrayList<>();

        return new PersonBlueprint(name, description, level, race, profession, inventory, personList);
    }
}
