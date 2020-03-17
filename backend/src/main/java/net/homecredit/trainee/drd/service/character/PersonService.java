package net.homecredit.trainee.drd.service.character;

import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.race.Race;
import net.homecredit.trainee.drd.service.character.profession.ProfessionServiceFactory;
import net.homecredit.trainee.drd.service.inventory.InventoryService;
import net.homecredit.trainee.drd.util.Dice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class PersonService {

    private Dice dice;
    private InventoryService inventoryService;
    private RaceService raceService;
    private ProfessionServiceFactory professionServiceFactory;

    public PersonService(Dice dice, InventoryService inventoryService, RaceService raceService, ProfessionServiceFactory professionServiceFactory) {
        this.dice = dice;
        this.inventoryService = inventoryService;
        this.raceService = raceService;
        this.professionServiceFactory = professionServiceFactory;
    }

//    public Collection<Person> spawnFromBlueprint(int nrOfPeople, PersonBlueprint personBlueprint) {
//        List<Person> people = new ArrayList<>();
//        Profession profession = personBlueprint.getProfession();
//        ProfessionService professionService = professionServiceFactory.selectProfessionService(profession);
//
//        for (int i = 0; i < nrOfPeople; i++) {
//            String name = personBlueprint.getName() + " " + i;
//
//            ProfessionKnowHow profKnowHow = professionService.startCareer(profession);
//
//            Map<Ability, AbilityScore> abilityMap = randomiseAbilities(personBlueprint.getRace(), profession);
//
//            int manna = 0;
//            int life = calculateLife(profession, personBlueprint.getLevel(), abilityMap.get(Ability.RESISTANCE));
//
//            //@TODO - Both inventory and combat values are not properly initialized
//            Inventory inventory = inventoryService.copyBlueprintInventory(personBlueprint.getInventory());
//            CombatValues combatValues = new CombatValues();
//
//            Collection<Beast> companion = new ArrayList<>();
//            Collection<SkillKnowHow> skillKnowHow = new ArrayList<>();
//
//            int height = raceService.averageHeight(personBlueprint.getRace());
//            int weight = raceService.averageWeight(personBlueprint.getRace());
//            Person singlePerson = new Person(personBlueprint, name, personBlueprint.getDescription(), personBlueprint.getLevel(), 0, life, manna, weight, height, personBlueprint.getRace(), profKnowHow, abilityMap, combatValues, inventory, companion, skillKnowHow);
//            people.add(singlePerson);
//        }
//
//        return people;
//    }

    private Map<Ability, AbilityScore> randomiseAbilities(Race race, Profession profession) {
        Map<Ability, AbilityScore> abilityMap = new HashMap<>();

        for (Ability ability : Ability.values()) {
            AbilityScore abilityScore;
            if (profession.getDominantAbilities().containsKey(ability)) {
                abilityScore = professionAbility(ability, profession, race);
            } else {
                abilityScore = raceAbility(ability, race);
            }
            abilityMap.put(ability, abilityScore);
        }
        return abilityMap;
    }

    private AbilityScore raceAbility(Ability ability, Race race) {
        int diceRollSum = 0;
        for (int i = 0; i < raceService.getNrOfThrows(race, ability); i++) {
            diceRollSum += dice.roll(6);
        }
        int abilityValue = raceService.getAbilityBase(race, ability) + diceRollSum;
        int abilityBonus = raceService.calculateBonus(abilityValue);

        return new AbilityScore(ability, abilityValue, abilityBonus);
    }

    private AbilityScore professionAbility(Ability ability, Profession profession, Race race) {
        int abilityValue = profession.getDominantAbilities().get(ability) + raceService.getAbilityCorrection(race, ability) + dice.roll(6);
        int abilityBonus = raceService.calculateBonus(abilityValue);

        return new AbilityScore(ability, abilityValue, abilityBonus);
    }

    private int calculateLife(Profession profession, int level, AbilityScore resistanceScore) {
        int life = profession.getBaseLife();

        for (int i = 2; i <= Math.min(level, 9); i++) {
            life += Math.max(
                    dice.roll(profession.getLifeDice()) + resistanceScore.getAbilityBonusValue() + profession.getLifeBonus(),
                    1
            );
        }
        life += profession.getLifeGain() * Math.max((level - 9), 0);

        return life;
    }
}
