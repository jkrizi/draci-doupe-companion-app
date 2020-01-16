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

    private RaceRepository raceRepository;

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
                return race.getStrengthNrOfThrows();
            case DEXTERITY:
                return race.getDexterityNrOfThrows();
            case RESISTANCE:
                return race.getResistanceNrOfThrows();
            case INTELLIGENCE:
                return race.getIntelligenceNrOfThrows();
            case CHARISMA:
                return race.getCharismaNrOfThrows();
        }
        throw new IllegalArgumentException("Required invalid ability!");
    }

    public int getAbilityBase(Race race, Ability ability) {
        switch (ability) {
            case STRENGTH:
                return race.getStrengthAbilityBase();
            case DEXTERITY:
                return race.getDexterityAbilityBase();
            case RESISTANCE:
                return race.getResistanceAbilityBase();
            case INTELLIGENCE:
                return race.getIntelligenceAbilityBase();
            case CHARISMA:
                return race.getCharismaAbilityBase();
        }
        throw new IllegalArgumentException("Required invalid ability!");
    }

    public int getAbilityCorrection(Race race, Ability ability) {
        switch (ability) {
            case STRENGTH:
                return race.getStrengthAbilityCorrection();
            case DEXTERITY:
                return race.getDexterityAbilityCorrection();
            case RESISTANCE:
                return race.getResistanceAbilityCorrection();
            case INTELLIGENCE:
                return race.getIntelligenceAbilityCorrection();
            case CHARISMA:
                return race.getCharismaAbilityCorrection();
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
