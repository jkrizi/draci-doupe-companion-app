package net.homecredit.trainee.drd.entity.inventory.weapon;

import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.shop.ItemType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WEAPON")
public class Weapon extends Equipment {

    private boolean equipped;

    private int attack;
    private int hurt;
    private int defense;

    @Column(name = "INITIATIVE_MODIFIER")
    private int initiativeModifier;

    @ManyToOne
    private WeaponFamily type;

    @Column(name = "SHORT_RANGE_LIMIT")
    private int shortRangeLimit;
    @Column(name = "MID_RANGE_LIMIT")
    private int midRangeLimit;
    @Column(name = "LONG_RANGE_LIMIT")
    private int longRangeLimit;

    @Column(name = "MIN_MELEE_REACH")
    private int minReach;
    @Column(name = "MAX_MELEE_REACH")
    private int maxReach;

    public Weapon() {
    }

    public Weapon(WeaponBlueprint weaponBlueprint) {
        super(weaponBlueprint, ItemType.WEAPONS);
        this.equipped = false;
        this.attack = weaponBlueprint.getAttack();
        this.hurt = weaponBlueprint.getHurt();
        this.defense = weaponBlueprint.getDefense();
        this.initiativeModifier = weaponBlueprint.getInitiativeModifier();
        this.type = weaponBlueprint.getWeaponFamily();
        this.shortRangeLimit = weaponBlueprint.getShortRangeLimit();
        this.midRangeLimit = weaponBlueprint.getMidRangeLimit();
        this.longRangeLimit = weaponBlueprint.getLongRangeLimit();
        this.minReach = weaponBlueprint.getMinMeleeReach();
        this.maxReach = weaponBlueprint.getMaxMeleeReach();
    }

    public Weapon(WeaponBlueprint weaponBlueprint, StorageUnit storage) {
        super(weaponBlueprint, storage, ItemType.WEAPONS);
        this.equipped = false;
        this.attack = weaponBlueprint.getAttack();
        this.hurt = weaponBlueprint.getHurt();
        this.defense = weaponBlueprint.getDefense();
        this.initiativeModifier = weaponBlueprint.getInitiativeModifier();
        this.type = weaponBlueprint.getWeaponFamily();
        this.shortRangeLimit = weaponBlueprint.getShortRangeLimit();
        this.midRangeLimit = weaponBlueprint.getMidRangeLimit();
        this.longRangeLimit = weaponBlueprint.getLongRangeLimit();
        this.minReach = weaponBlueprint.getMinMeleeReach();
        this.maxReach = weaponBlueprint.getMaxMeleeReach();
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
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

    public WeaponFamily getType() {
        return type;
    }

    public void setType(WeaponFamily type) {
        this.type = type;
    }

    public int getShortRangeLimit() {
        return shortRangeLimit;
    }

    public void setShortRangeLimit(int shortRangeLimit) {
        this.shortRangeLimit = shortRangeLimit;
    }

    public int getMidRangelimit() {
        return midRangeLimit;
    }

    public void setMidRangelimit(int midRangeLimit) {
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

    @Override
    public String toString() {
        return "Weapon{" +
                "equipped=" + equipped +
                ", attack=" + attack +
                ", hurt=" + hurt +
                ", defense=" + defense +
                ", initiativeModifier=" + initiativeModifier +
                ", type=" + type +
                ", shortRangeLimit=" + shortRangeLimit +
                ", midRangeLimit=" + midRangeLimit +
                ", longRangeLimit=" + longRangeLimit +
                ", minReach=" + minReach +
                ", maxReach=" + maxReach +
                '}';
    }
}
