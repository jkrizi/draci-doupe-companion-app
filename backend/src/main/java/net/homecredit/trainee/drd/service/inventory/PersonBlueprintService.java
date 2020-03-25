package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import net.homecredit.trainee.drd.entity.character.person.Person;
import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.race.Race;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonBlueprintService {

    public PersonBlueprint drawBlueprint(String name, String description, int level, Race race, Profession profession, Inventory inventory) {
        List<Person> personList = new ArrayList<>();

        return new PersonBlueprint(name, description, level, race, profession, inventory, personList);
    }
}
