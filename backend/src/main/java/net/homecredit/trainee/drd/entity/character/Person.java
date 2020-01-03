package net.homecredit.trainee.drd.entity.character;

import net.homecredit.trainee.drd.entity.blueprint.PersonBlueprint;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.character.combat.CombatValues;
import net.homecredit.trainee.drd.entity.character.profession.ProfessionKnowHow;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowHow;
import net.homecredit.trainee.drd.entity.inventory.Inventory;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Entity
public class Person implements Character {

    @Id
    private UUID id;
    private String name;
    private String description;

    @Column(name = "person_level")
    private int level;
    private int exp;

    @Column(name = "current_life")
    private int currLife;
    @Column(name = "maximal_life")
    private int maxLife;
    @Column(name = "current_manna")
    private int currManna;
    @Column(name = "maximal_manna")
    private int maxManna;

    private int weight;
    private int height;

    @ManyToOne
    private Race race;

    @OneToOne
    @JoinColumn(name = "profession_knowhow_id")
    private ProfessionKnowHow professionKnowHow;

    @Embedded
    private CombatValues combatValues;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @MapKey(name = "ability")
    @MapKeyEnumerated
    private Map<Ability, AbilityScore> abilityMap;

    @OneToOne
    private Inventory inventory;
    @OneToMany
    private Collection<Beast> companion;
    @OneToMany
    private Collection<SkillKnowHow> skillKnowHow;
    @ManyToOne
    private PersonBlueprint personBlueprint;

    public Person() {
    }

    public Person(String name, String description, int level, int exp, int initialLife, int initialManna, int weight, int height, Race race, ProfessionKnowHow professionKnowHow, Map<Ability, AbilityScore> abilityMap, CombatValues combatValues, Inventory inventory, Collection<Beast> companion, Collection<SkillKnowHow> skillKnowHow) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.level = level;
        this.exp = exp;
        this.currLife = initialLife;
        this.maxLife = initialLife;
        this.currManna = initialManna;
        this.maxManna = initialManna;
        this.weight = weight;
        this.height = height;
        this.race = race;
        this.professionKnowHow = professionKnowHow;
        this.abilityMap = abilityMap;
        this.combatValues = combatValues;
        this.inventory = inventory;
        this.companion = companion;
        this.skillKnowHow = skillKnowHow;
    }

    public Person(PersonBlueprint personBlueprint, String name, String description, int level, int exp, int initialLife, int initialManna, int weight, int height, Race race, ProfessionKnowHow professionKnowHow, Map<Ability, AbilityScore> abilityMap, CombatValues combatValues, Inventory inventory, Collection<Beast> companion, Collection<SkillKnowHow> skillKnowHow) {
        this(name, description, level, exp, initialLife, initialManna, weight, height, race, professionKnowHow, abilityMap, combatValues, inventory, companion, skillKnowHow);
        this.personBlueprint = personBlueprint;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getCurrLife() {
        return currLife;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getCurrManna() {
        return currManna;
    }

    public int getMaxManna() {
        return maxManna;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public Race getRace() {
        return race;
    }

    public ProfessionKnowHow getProfessionKnowHow() {
        return professionKnowHow;
    }

    public CombatValues getCombatValues() {
        return combatValues;
    }

    public Map<Ability, AbilityScore> getAbilityMap() {
        return abilityMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Collection<Beast> getCompanion() {
        return companion;
    }

    public Collection<SkillKnowHow> getSkillKnowHow() {
        return skillKnowHow;
    }

    public PersonBlueprint getPersonBlueprint() {
        return personBlueprint;
    }
}
