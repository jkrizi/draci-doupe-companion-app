package net.homecredit.trainee.drd.entity.inventory.weapon;

import javax.persistence.Embeddable;

@Embeddable
public class WeaponType {

    private boolean isMelee;
    private boolean isSingleHand;
    private WeightCategory weightCategory;
    private WeaponDamageType weaponDamageType;

    public WeaponType() {}

    public WeaponType(boolean isMelee, boolean isSingleHand, WeightCategory weightCategory, WeaponDamageType weaponDamageType) {
        this.isMelee = isMelee;
        this.isSingleHand = isSingleHand;
        this.weightCategory = weightCategory;
        this.weaponDamageType = weaponDamageType;
    }

    public boolean isMelee() {
        return isMelee;
    }

    public void setMelee(boolean melee) {
        isMelee = melee;
    }

    public boolean isSingleHand() {
        return isSingleHand;
    }

    public void setSingleHand(boolean singleHand) {
        isSingleHand = singleHand;
    }

    public WeightCategory getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(WeightCategory weightCategory) {
        this.weightCategory = weightCategory;
    }

    public WeaponDamageType getWeaponDamageType() {
        return weaponDamageType;
    }

    public void setWeaponDamageType(WeaponDamageType weaponDamageType) {
        this.weaponDamageType = weaponDamageType;
    }
}
