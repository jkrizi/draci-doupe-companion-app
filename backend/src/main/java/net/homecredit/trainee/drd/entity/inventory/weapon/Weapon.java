package net.homecredit.trainee.drd.entity.inventory.weapon;

import net.homecredit.trainee.entity.blueprint.item.WeaponBlueprint;
import net.homecredit.trainee.entity.inventory.Equipment;
import net.homecredit.trainee.entity.inventory.StorageUnit;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "WEAPON")
public class Weapon extends Equipment {

    private boolean equipped;

    private int attack;
    private int hurt;
    private int defense;

    @Column(name = "INITIATIVE_MODIFIER")
    private int initiativeModifier;

    @ElementCollection
    @CollectionTable(name="WEAPON_TYPE_BLUEPRINT", joinColumns = @JoinColumn(name = "WEAPON_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "WEAPON_TYPE")
    private Set<WeaponType> type;

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

    public Weapon() {}

    public Weapon(WeaponBlueprint weaponBlueprint, StorageUnit storage) {
        super(weaponBlueprint.getName(), weaponBlueprint.getPublicDescription(), weaponBlueprint.getWeight(), storage);
        this.equipped = false;
        this.attack = weaponBlueprint.getAttack();
        this.hurt = weaponBlueprint.getHurt();
        this.defense = weaponBlueprint.getDefense();
        this.initiativeModifier = weaponBlueprint.getInitiativeModifier();
        this.type = EnumSet.copyOf(weaponBlueprint.getType());
        this.shortRangeLimit = weaponBlueprint.getShortRangeLimit();
        this.midRangeLimit = weaponBlueprint.getMidRangeLimit();
        this.longRangeLimit = weaponBlueprint.getLongRangeLimit();
        this.minReach = weaponBlueprint.getMinReach();
        this.maxReach = weaponBlueprint.getMaxReach();
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

    public Set<WeaponType> getType() {
        return type;
    }

    public void setType(EnumSet<WeaponType> type) {
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
}
