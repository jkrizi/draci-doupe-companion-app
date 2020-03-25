package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.profession.ProfessionKnowHow;
import org.springframework.stereotype.Service;

@Service
public class WizardService implements ProfessionService {

    @Override
    public ProfessionKnowHow startCareer(Profession profession) {
        throw new UnsupportedOperationException("TODO");
    }
}
