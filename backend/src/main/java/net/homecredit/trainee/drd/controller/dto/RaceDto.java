package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;

import java.util.List;
import java.util.UUID;

public class RaceDto {

    private UUID id;
    private String name;
    private String description;
    private int minWeight;
    private int maxWeight;
    private int minHeight;
    private int maxHeight;
    //Character Size udela jako array
    //A0, false, A, true, B, false, C, false, D, false, E, false
    private List<String> characterSize;
    private WeaponFamily weapon;
    //    private Collection<Person> person;
//    private Collection<PersonBlueprint> personBlueprint;
    private int strengthNrOfThrows;
    private int dexterityNrOfThrows;
    private int resistanceNrOfThrows;
    private int intelligenceNrOfThrows;
    private int charismaNrOfThrows;
    private int strengthAbilityBase;
    private int dexterityAbilityBase;
    private int resistanceAbilityBase;
    private int intelligenceAbilityBase;
    private int charismaAbilityBase;
    private int strengthAbilityCorrection;
    private int dexterityAbilityCorrection;
    private int resistanceAbilityCorrection;
    private int intelligenceAbilityCorrection;
    private int charismaAbilityCorrection;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public List<String> getCharacterSize() {
        return characterSize;
    }

    public void setCharacterSize(List<String> size) {
        this.characterSize = size;
    }

    public int getStrengthNrOfThrows() {
        return strengthNrOfThrows;
    }

    public void setStrengthNrOfThrows(int strengthNrOfThrows) {
        this.strengthNrOfThrows = strengthNrOfThrows;
    }

    public int getDexterityNrOfThrows() {
        return dexterityNrOfThrows;
    }

    public void setDexterityNrOfThrows(int dexterityNrOfThrows) {
        this.dexterityNrOfThrows = dexterityNrOfThrows;
    }

    public int getResistanceNrOfThrows() {
        return resistanceNrOfThrows;
    }

    public void setResistanceNrOfThrows(int resistanceNrOfThrows) {
        this.resistanceNrOfThrows = resistanceNrOfThrows;
    }

    public int getIntelligenceNrOfThrows() {
        return intelligenceNrOfThrows;
    }

    public void setIntelligenceNrOfThrows(int intelligenceNrOfThrows) {
        this.intelligenceNrOfThrows = intelligenceNrOfThrows;
    }

    public int getCharismaNrOfThrows() {
        return charismaNrOfThrows;
    }

    public void setCharismaNrOfThrows(int charismaNrOfThrows) {
        this.charismaNrOfThrows = charismaNrOfThrows;
    }

    public int getStrengthAbilityBase() {
        return strengthAbilityBase;
    }

    public void setStrengthAbilityBase(int strengthAbilityBase) {
        this.strengthAbilityBase = strengthAbilityBase;
    }

    public int getDexterityAbilityBase() {
        return dexterityAbilityBase;
    }

    public void setDexterityAbilityBase(int dexterityAbilityBase) {
        this.dexterityAbilityBase = dexterityAbilityBase;
    }

    public int getResistanceAbilityBase() {
        return resistanceAbilityBase;
    }

    public void setResistanceAbilityBase(int resistanceAbilityBase) {
        this.resistanceAbilityBase = resistanceAbilityBase;
    }

    public int getIntelligenceAbilityBase() {
        return intelligenceAbilityBase;
    }

    public void setIntelligenceAbilityBase(int intelligenceAbilityBase) {
        this.intelligenceAbilityBase = intelligenceAbilityBase;
    }

    public int getCharismaAbilityBase() {
        return charismaAbilityBase;
    }

    public void setCharismaAbilityBase(int charismaAbilityBase) {
        this.charismaAbilityBase = charismaAbilityBase;
    }

    public int getStrengthAbilityCorrection() {
        return strengthAbilityCorrection;
    }

    public void setStrengthAbilityCorrection(int strengthAbilityCorrection) {
        this.strengthAbilityCorrection = strengthAbilityCorrection;
    }

    public int getDexterityAbilityCorrection() {
        return dexterityAbilityCorrection;
    }

    public void setDexterityAbilityCorrection(int dexterityAbilityCorrection) {
        this.dexterityAbilityCorrection = dexterityAbilityCorrection;
    }

    public int getResistanceAbilityCorrection() {
        return resistanceAbilityCorrection;
    }

    public void setResistanceAbilityCorrection(int resistanceAbilityCorrection) {
        this.resistanceAbilityCorrection = resistanceAbilityCorrection;
    }

    public int getIntelligenceAbilityCorrection() {
        return intelligenceAbilityCorrection;
    }

    public void setIntelligenceAbilityCorrection(int intelligenceAbilityCorrection) {
        this.intelligenceAbilityCorrection = intelligenceAbilityCorrection;
    }

    public int getCharismaAbilityCorrection() {
        return charismaAbilityCorrection;
    }

    public void setCharismaAbilityCorrection(int charismaAbilityCorrection) {
        this.charismaAbilityCorrection = charismaAbilityCorrection;
    }

    public WeaponFamily getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponFamily weapon) {
        this.weapon = weapon;
    }
}
