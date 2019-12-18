package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.profession.Profession;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class ProfessionServiceFactory {

    private WarriorService warriorService;
    private RangerService rangerService;
    private AlchemistService alchemistService;
    private WizardService wizardService;
    private ThiefService thiefService;

    public ProfessionServiceFactory(WarriorService warriorService, RangerService rangerService, AlchemistService alchemistService, WizardService wizardService, ThiefService thiefService) {
        this.warriorService = warriorService;
        this.rangerService = rangerService;
        this.alchemistService = alchemistService;
        this.wizardService = wizardService;
        this.thiefService = thiefService;
    }

    public ProfessionService selectProfessionService(Profession profession) {
        switch(profession) {
            case WARRIOR: return warriorService;
            case FIGHTER:return warriorService;
            case SWORDSMAN:return warriorService;
            case RANGER: return rangerService;
            case DRUID: return rangerService;
            case STRIDER: return  rangerService;
            case ALCHEMIST: return alchemistService;
            case THEURGIST: return alchemistService;
            case PYROFOR: return alchemistService;
            case WIZARD: return wizardService;
            case SORCERER: return wizardService;
            case MAGE: return wizardService;
            case THIEF: return thiefService;
            case BURGLAR: return thiefService;
            case SICCO: return thiefService;
        }
        throw new InvalidParameterException("No valid profession was selected!");
    }
}
