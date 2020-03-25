package net.homecredit.trainee.drd.entity.inventory.weapon;


import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "WEAPON_BLUEPRINT")
public class WeaponBlueprint implements ItemBlueprint {

    @Id
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
    private int minMeleeReach;
    private int maxMeleeReach;

    @ManyToOne
    private WeaponFamily weaponFamily;

    public WeaponBlueprint() {
    }

    public WeaponBlueprint(String name, String publicDescription, String privateDescription, int weight, int attack, int hurt, int defense, int initiativeModifier, int shortRangeLimit, int midRangeLimit, int longRangeLimit, int minMeleeReach, int maxMeleeReach, WeaponFamily weaponFamily) {
        this.id = UUID.randomUUID();
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
        this.minMeleeReach = minMeleeReach;
        this.maxMeleeReach = maxMeleeReach;
        this.weaponFamily = weaponFamily;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
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

    public int getMinMeleeReach() {
        return minMeleeReach;
    }

    public void setMinMeleeReach(int minMeleeReach) {
        this.minMeleeReach = minMeleeReach;
    }

    public int getMaxMeleeReach() {
        return maxMeleeReach;
    }

    public void setMaxMeleeReach(int maxMeleeReach) {
        this.maxMeleeReach = maxMeleeReach;
    }

    public WeaponFamily getWeaponFamily() {
        return weaponFamily;
    }

    public void setWeaponFamily(WeaponFamily weaponTypes) {
        this.weaponFamily = weaponTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeaponBlueprint)) return false;
        WeaponBlueprint that = (WeaponBlueprint) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WeaponBlueprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privateDescription='" + privateDescription + '\'' +
                ", publicDescription='" + publicDescription + '\'' +
                ", weight=" + weight +
                ", attack=" + attack +
                ", hurt=" + hurt +
                ", defense=" + defense +
                ", initiativeModifier=" + initiativeModifier +
                ", shortRangeLimit=" + shortRangeLimit +
                ", midRangeLimit=" + midRangeLimit +
                ", longRangeLimit=" + longRangeLimit +
                ", minReach=" + minMeleeReach +
                ", maxReach=" + maxMeleeReach +
                ", type=" + weaponFamily +
                '}';
    }
}
