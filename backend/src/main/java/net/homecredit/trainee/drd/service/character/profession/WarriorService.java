package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.person.Person;
import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.profession.ProfessionKnowHow;
import org.springframework.stereotype.Service;

@Service
public class WarriorService implements ProfessionService {

    @Override
    public ProfessionKnowHow startCareer(Profession profession) {
        return new ProfessionKnowHow();
    }

    public int estimateOpponent(Person warrior, Character character) {
        return 1;
    }
}
