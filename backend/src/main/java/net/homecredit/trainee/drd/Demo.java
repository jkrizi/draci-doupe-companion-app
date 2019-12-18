package net.homecredit.trainee;

import net.homecredit.trainee.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.entity.character.CharacterSize;
import net.homecredit.trainee.entity.character.Vulnerability;
import net.homecredit.trainee.entity.character.ability.Ability;
import net.homecredit.trainee.entity.character.ability.AbilityScore;
import net.homecredit.trainee.service.blueprint.BeastBlueprintService;
import net.homecredit.trainee.service.character.BeastService;
import net.homecredit.trainee.service.item.StorageService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        BeastBlueprintService beastBlueprintService = applicationContext.getBean(BeastBlueprintService.class);
        BeastService beastService =  applicationContext.getBean(BeastService.class);
        StorageService storageService = applicationContext.getBean(StorageService.class);

        boolean delete = false;

        if(delete) {
            beastBlueprintService.deleteAll();
        } else {
            /**
             * CREATING GOBLIN IDEAL (BACKPACK INCLUDED)!!!
             */
            Map<Ability, AbilityScore> abilityScores = new HashMap<>();
            abilityScores.put(Ability.STRENGTH, new AbilityScore(Ability.STRENGTH, 8, -1));
            abilityScores.put(Ability.DEXTERITY, new AbilityScore(Ability.DEXTERITY, 8, -1));
            abilityScores.put(Ability.RESISTANCE, new AbilityScore(Ability.RESISTANCE, 8, -1));
            abilityScores.put(Ability.CHARISMA, new AbilityScore(Ability.CHARISMA, 4, -3));
            abilityScores.put(Ability.INTELLIGENCE, new AbilityScore(Ability.INTELLIGENCE, 3, -4));

            EnumSet<CharacterSize> sizes = EnumSet.noneOf(CharacterSize.class);
            EnumSet<Vulnerability> vulnerabilities = EnumSet.noneOf(Vulnerability.class);
            BeastBlueprint goblinIdeal = beastBlueprintService.drawBlueprint(
                    "Drd pravidla pro zacatecniky",
                    "Skreti valecnik",
                    "Skret",
                    "No comment",
                    1,
                    0,
                    0,
                    abilityScores,
                    7,
                    0,
                    sizes,
                    vulnerabilities,
                    10,
                    8,
                    -1,
                    true
            );

            sizes.add(CharacterSize.A);

            vulnerabilities.addAll(EnumSet.complementOf(EnumSet.of(Vulnerability.E, Vulnerability.F, Vulnerability.N, Vulnerability.P)));

            beastBlueprintService.saveBeastBlueprint(goblinIdeal);


            /**
             * CREATING GOGO THE FIRST OF GOBLINS
             */
            beastService.spawnBeasts(
                    2,
                    goblinIdeal,
                    "GoGo",
                    "GoGo je prosty skret, ktery rad vysiva",
                    CharacterSize.A
            );
        }
    }
}
