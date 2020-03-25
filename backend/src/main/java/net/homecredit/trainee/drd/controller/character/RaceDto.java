package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.entity.character.CharacterSize;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.UUID;

public class RaceDto {

    private UUID id;
    private String name;
    private String description;
    private int minWeight;
    private int maxWeight;
    private int minHeight;
    private int maxHeight;
    private CharacterSize size;
    private UUID weaponFamilyId;
    private int strengthThrows;
    private int dexterityThrows;
    private int resistanceThrows;
    private int intelligenceThrows;
    private int charismaThrows;
    private int strengthBase;
    private int dexterityBase;
    private int resistanceBase;
    private int intelligenceBase;
    private int charismaBase;
    private int strengthCorrection;
    private int dexterityCorrection;
    private int resistanceCorrection;
    private int intelligenceCorrection;
    private int charismaCorrection;

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

    public CharacterSize getSize() {
        return size;
    }

    public void setSize(CharacterSize size) {
        this.size = size;
    }

    public UUID getWeaponFamilyId() {
        return weaponFamilyId;
    }

    public void setWeaponFamilyId(UUID weaponFamilyId) {
        this.weaponFamilyId = weaponFamilyId;
    }

    public int getStrengthThrows() {
        return strengthThrows;
    }

    public void setStrengthThrows(int strengthThrows) {
        this.strengthThrows = strengthThrows;
    }

    public int getDexterityThrows() {
        return dexterityThrows;
    }

    public void setDexterityThrows(int dexterityThrows) {
        this.dexterityThrows = dexterityThrows;
    }

    public int getResistanceThrows() {
        return resistanceThrows;
    }

    public void setResistanceThrows(int resistanceThrows) {
        this.resistanceThrows = resistanceThrows;
    }

    public int getIntelligenceThrows() {
        return intelligenceThrows;
    }

    public void setIntelligenceThrows(int intelligenceThrows) {
        this.intelligenceThrows = intelligenceThrows;
    }

    public int getCharismaThrows() {
        return charismaThrows;
    }

    public void setCharismaThrows(int charismaThrows) {
        this.charismaThrows = charismaThrows;
    }

    public int getStrengthBase() {
        return strengthBase;
    }

    public void setStrengthBase(int strengthBase) {
        this.strengthBase = strengthBase;
    }

    public int getDexterityBase() {
        return dexterityBase;
    }

    public void setDexterityBase(int dexterityBase) {
        this.dexterityBase = dexterityBase;
    }

    public int getResistanceBase() {
        return resistanceBase;
    }

    public void setResistanceBase(int resistanceBase) {
        this.resistanceBase = resistanceBase;
    }

    public int getIntelligenceBase() {
        return intelligenceBase;
    }

    public void setIntelligenceBase(int intelligenceBase) {
        this.intelligenceBase = intelligenceBase;
    }

    public int getCharismaBase() {
        return charismaBase;
    }

    public void setCharismaBase(int charismaBase) {
        this.charismaBase = charismaBase;
    }

    public int getStrengthCorrection() {
        return strengthCorrection;
    }

    public void setStrengthCorrection(int strengthCorrection) {
        this.strengthCorrection = strengthCorrection;
    }

    public int getDexterityCorrection() {
        return dexterityCorrection;
    }

    public void setDexterityCorrection(int dexterityCorrection) {
        this.dexterityCorrection = dexterityCorrection;
    }

    public int getResistanceCorrection() {
        return resistanceCorrection;
    }

    public void setResistanceCorrection(int resistanceCorrection) {
        this.resistanceCorrection = resistanceCorrection;
    }

    public int getIntelligenceCorrection() {
        return intelligenceCorrection;
    }

    public void setIntelligenceCorrection(int intelligenceCorrection) {
        this.intelligenceCorrection = intelligenceCorrection;
    }

    public int getCharismaCorrection() {
        return charismaCorrection;
    }

    public void setCharismaCorrection(int charismaCorrection) {
        this.charismaCorrection = charismaCorrection;
    }
}
