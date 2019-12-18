package net.homecredit.trainee.service.character.profession;

import net.homecredit.trainee.entity.character.Character;
import net.homecredit.trainee.entity.character.Person;
import net.homecredit.trainee.entity.character.profession.Profession;
import net.homecredit.trainee.entity.character.profession.ProfessionKnowHow;
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
