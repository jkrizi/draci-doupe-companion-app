package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;

import java.util.UUID;

public class WeaponBlueprintDto {

    private UUID id;
    private String name;
    private String privateDescription;
    private String publicDescription;
    private int weight;
    private int attack;
    private int hurt;
    private int defense;
    private int initiativeModifier;
    private int shortRangeLimit;
    private int midRangeLimit;
    private int longRangeLimit;
    private int minReach;
    private int maxReach;
    private WeaponFamily weaponFamily;

    public WeaponBlueprintDto(UUID id, String name, String privateDescription, String publicDescription, int weight, int attack, int hurt, int defense, int initiativeModifier, int shortRangeLimit, int midRangeLimit, int longRangeLimit, int minReach, int maxReach, WeaponFamily weaponFamily) {
        this.id = id;
        this.name = name;
        this.privateDescription = privateDescription;
        this.publicDescription = publicDescription;
        this.weight = weight;
        this.attack = attack;
        this.hurt = hurt;
        this.defense = defense;
        this.initiativeModifier = initiativeModifier;
        this.shortRangeLimit = shortRangeLimit;
        this.midRangeLimit = midRangeLimit;
        this.longRangeLimit = longRangeLimit;
        this.minReach = minReach;
        this.maxReach = maxReach;
        this.weaponFamily = weaponFamily;
    }

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

    public String getPrivateDescription() {
        return privateDescription;
    }

    public void setPrivateDescription(String privateDescription) {
        this.privateDescription = privateDescription;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getInitiativeModifier() {
        return initiativeModifier;
    }

    public void setInitiativeModifier(int initiativeModifier) {
        this.initiativeModifier = initiativeModifier;
    }

    public int getShortRangeLimit() {
        return shortRangeLimit;
    }

    public void setShortRangeLimit(int shortRangeLimit) {
        this.shortRangeLimit = shortRangeLimit;
    }

    public int getMidRangeLimit() {
        return midRangeLimit;
    }

    public void setMidRangeLimit(int midRangeLimit) {
        this.midRangeLimit = midRangeLimit;
    }

    public int getLongRangeLimit() {
        return longRangeLimit;
    }

    public void setLongRangeLimit(int longRangeLimit) {
        this.longRangeLimit = longRangeLimit;
    }

    public int getMinReach() {
        return minReach;
    }

    public void setMinReach(int minReach) {
        this.minReach = minReach;
    }

    public int getMaxReach() {
        return maxReach;
    }

    public void setMaxReach(int maxReach) {
        this.maxReach = maxReach;
    }

    public WeaponFamily getWeaponFamily() {
        return weaponFamily;
    }

    public void setWeaponFamily(WeaponFamily weaponFamily) {
        this.weaponFamily = weaponFamily;
    }
}
