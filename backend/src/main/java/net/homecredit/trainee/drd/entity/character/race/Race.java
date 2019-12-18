package net.homecredit.trainee.drd.entity.character.race;

import net.homecredit.trainee.drd.entity.blueprint.PersonBlueprint;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.Person;
import net.homecredit.trainee.drd.entity.inventory.weapon.Weapon;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
public class Race {

    @Id
    private UUID id;
    private String name;
    private String description;
    @Column(name = "min_weight")
    private int minWeight;
    @Column(name = "max_weight")
    private int maxWeight;
    @Column(name = "min_height")
    private int minHeight;
    @Column(name = "max_height")
    private int maxHeight;
    @Enumerated(EnumType.STRING)
    @Column(name = "race_size")
    private CharacterSize size;

    @OneToOne
    private Weapon weapon;

    @OneToMany(mappedBy = "race", orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Person> person;

    @OneToMany(mappedBy = "race", orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<PersonBlueprint> personBlueprint;

    @Column(name = "strength_nr_of_throws")
    private int strengthNrOfThrows;
    @Column(name = "dexterity_nr_of_throws")
    private int dexterityNrOfThrows;
    @Column(name = "resistance_nr_of_throws")
    private int resistanceNrOfThrows;
    @Column(name = "intelligence_nr_of_throws")
    private int intelligenceNrOfThrows;
    @Column(name = "charisma_nr_of_throws")
    private int charismaNrOfThrows;

    @Column(name = "strength_ability_base")
    private int strengthAbilityBase;
    @Column(name = "dexterity_ability_base")
    private int dexterityAbilityBase;
    @Column(name = "resistance_ability_base")
    private int resistanceAbilityBase;
    @Column(name = "intelligence_ability_base")
    private int intelligenceAbilityBase;
    @Column(name = "charisma_ability_base")
    private int charismaAbilityBase;

    @Column(name = "strength_ability_correction")
    private int strengthAbilityCorrection;
    @Column(name = "dexterity_ability_correction")
    private int dexterityAbilityCorrection;
    @Column(name = "resistance_ability_correction")
    private int resistanceAbilityCorrection;
    @Column(name = "intelligence_ability_correction")
    private int intelligenceAbilityCorrection;
    @Column(name = "charisma_ability_correction")
    private int charismaAbilityCorrection;

    public Race() {}

    public Race(String name, String description, int minWeight, int maxWeight, int minHeight, int maxHeight, CharacterSize size, Weapon weapon, Collection<PersonBlueprint> personBlueprint, int strengthNrOfThrows, int dexterityNrOfThrows, int resistanceNrOfThrows, int intelligenceNrOfThrows, int charismaNrOfThrows, int strengthAbilityBase, int dexterityAbilityBase, int resistanceAbilityBase, int intelligenceAbilityBase, int charismaAbilityBase, int strengthAbilityCorrection, int dexterityAbilityCorrection, int resistanceAbilityCorrection, int intelligenceAbilityCorrection, int charismaAbilityCorrection) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.size = size;
        this.weapon = weapon;
        this.personBlueprint = personBlueprint;
        this.strengthNrOfThrows = strengthNrOfThrows;
        this.dexterityNrOfThrows = dexterityNrOfThrows;
        this.resistanceNrOfThrows = resistanceNrOfThrows;
        this.intelligenceNrOfThrows = intelligenceNrOfThrows;
        this.charismaNrOfThrows = charismaNrOfThrows;
        this.strengthAbilityBase = strengthAbilityBase;
        this.dexterityAbilityBase = dexterityAbilityBase;
        this.resistanceAbilityBase = resistanceAbilityBase;
        this.intelligenceAbilityBase = intelligenceAbilityBase;
        this.charismaAbilityBase = charismaAbilityBase;
        this.strengthAbilityCorrection = strengthAbilityCorrection;
        this.dexterityAbilityCorrection = dexterityAbilityCorrection;
        this.resistanceAbilityCorrection = resistanceAbilityCorrection;
        this.intelligenceAbilityCorrection = intelligenceAbilityCorrection;
        this.charismaAbilityCorrection = charismaAbilityCorrection;
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

    public int getMinWeight() {
        return minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public CharacterSize getSize() {
        return size;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Collection<PersonBlueprint> getPersonBlueprint() {
        return personBlueprint;
    }

    public int getStrengthNrOfThrows() {
        return strengthNrOfThrows;
    }

    public int getDexterityNrOfThrows() {
        return dexterityNrOfThrows;
    }

    public int getResistanceNrOfThrows() {
        return resistanceNrOfThrows;
    }

    public int getIntelligenceNrOfThrows() {
        return intelligenceNrOfThrows;
    }

    public int getCharismaNrOfThrows() {
        return charismaNrOfThrows;
    }

    public int getStrengthAbilityBase() {
        return strengthAbilityBase;
    }

    public int getDexterityAbilityBase() {
        return dexterityAbilityBase;
    }

    public int getResistanceAbilityBase() {
        return resistanceAbilityBase;
    }

    public int getIntelligenceAbilityBase() {
        return intelligenceAbilityBase;
    }

    public int getCharismaAbilityBase() {
        return charismaAbilityBase;
    }

    public int getStrengthAbilityCorrection() {
        return strengthAbilityCorrection;
    }

    public int getDexterityAbilityCorrection() {
        return dexterityAbilityCorrection;
    }

    public int getResistanceAbilityCorrection() {
        return resistanceAbilityCorrection;
    }

    public int getIntelligenceAbilityCorrection() {
        return intelligenceAbilityCorrection;
    }

    public int getCharismaAbilityCorrection() {
        return charismaAbilityCorrection;
    }
}
