package net.homecredit.trainee.service.character.profession;

import net.homecredit.trainee.entity.character.profession.Profession;
import net.homecredit.trainee.entity.character.profession.ProfessionKnowHow;

public interface ProfessionService {

    ProfessionKnowHow startCareer(Profession profession);
}
