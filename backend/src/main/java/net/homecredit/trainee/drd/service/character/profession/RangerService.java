package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.profession.Profession;
import net.homecredit.trainee.drd.entity.character.profession.ProfessionKnowHow;
import org.springframework.stereotype.Service;

@Service
public class RangerService implements ProfessionService{

    @Override
    public ProfessionKnowHow startCareer(Profession profession) {
        throw new UnsupportedOperationException("TODO");
    }
}
