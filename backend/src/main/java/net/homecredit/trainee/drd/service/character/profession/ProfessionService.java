package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.profession.ProfessionKnowHow;

public interface ProfessionService {

    ProfessionKnowHow startCareer(Profession profession);
}
