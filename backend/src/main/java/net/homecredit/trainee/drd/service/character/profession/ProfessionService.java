package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.profession.Profession;
import net.homecredit.trainee.drd.entity.character.profession.ProfessionKnowHow;

public interface ProfessionService {

    ProfessionKnowHow startCareer(Profession profession);
}
