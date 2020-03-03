package net.homecredit.trainee.drd.service.character;

import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.repository.character.RaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public int averageHeight(Race race) {
        return (race.getMaxHeight() + race.getMinHeight()) / 2;
    }

    public int averageWeight(Race race) {
        return (race.getMinWeight() + race.getMinWeight()) / 2;
    }

    public int getNrOfThrows(Race race, Ability ability) {
        switch (ability) {
            case STRENGTH:
                return race.getStrengthThrows();
            case DEXTERITY:
                return race.getDexterityThrows();
            case RESISTANCE:
                return race.getResistanceThrows();
            case INTELLIGENCE:
                return race.getIntelligenceThrows();
            case CHARISMA:
                return race.getCharismaThrows();
        }
        throw new IllegalArgumentException("Required invalid ability!");
    }

    public int getAbilityBase(Race race, Ability ability) {
        switch (ability) {
            case STRENGTH:
                return race.getStrengthBase();
            case DEXTERITY:
                return race.getDexterityBase();
            case RESISTANCE:
                return race.getResistanceBase();
            case INTELLIGENCE:
                return race.getIntelligenceBase();
            case CHARISMA:
                return race.getCharismaBase();
        }
        throw new IllegalArgumentException("Required invalid ability!");
    }

    public int getAbilityCorrection(Race race, Ability ability) {
        switch (ability) {
            case STRENGTH:
                return race.getStrengthCorrection();
            case DEXTERITY:
                return race.getDexterityCorrection();
            case RESISTANCE:
                return race.getResistanceCorrection();
            case INTELLIGENCE:
                return race.getIntelligenceCorrection();
            case CHARISMA:
                return race.getCharismaCorrection();
        }
        throw new IllegalArgumentException("Required invalid ability!");
    }

    public int calculateBonus(int abilityValue) {
        return (abilityValue - 11) / 2;
    }

    @Transactional
    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    @Transactional
    public void save(Race newRace) {
        raceRepository.save(newRace);
    }

    @Transactional
    public void update(Race existingRace) {
        raceRepository.update(existingRace);
    }

    @Transactional
    public void delete(UUID id) {
        raceRepository.delete(id);
    }
}
