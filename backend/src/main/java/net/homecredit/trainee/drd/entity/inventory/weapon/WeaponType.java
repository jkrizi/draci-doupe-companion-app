package net.homecredit.trainee.drd.entity.inventory.weapon;

import net.homecredit.trainee.drd.util.WeightCategory;

import javax.persistence.*;
import java.util.Set;

@Embeddable
public class WeaponType {

    @Column(name = "IS_MELEE")
    private boolean melee;
    @Column(name = "IS_SINGLE_HANDED")
    private boolean singleHanded;
    @Enumerated(EnumType.STRING)
    private WeightCategory weightCategory;
    @ElementCollection
    @CollectionTable(name = "DAMAGE_TYPE", joinColumns = @JoinColumn(name = "WEAPON_FAMILY_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "DAMAGE_TYPE")
    private Set<WeaponDamageType> damageType;

    public WeaponType() {}

    public WeaponType(boolean melee, boolean singleHanded, WeightCategory weightCategory, Set<WeaponDamageType> damageType) {
        this.melee = melee;
        this.singleHanded = singleHanded;
        this.weightCategory = weightCategory;
        this.damageType = damageType;
    }

    public boolean isMelee() {
        return melee;
    }

    public void setMelee(boolean melee) {
        this.melee = melee;
    }

    public boolean isSingleHanded() {
        return singleHanded;
    }

    public void setSingleHanded(boolean singleHanded) {
        this.singleHanded = singleHanded;
    }

    public WeightCategory getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(WeightCategory weightCategory) {
        this.weightCategory = weightCategory;
    }

    public Set<WeaponDamageType> getDamageType() {
        return damageType;
    }

    public void setDamageType(Set<WeaponDamageType> weaponDamageType) {
        this.damageType = weaponDamageType;
    }

    @Override
    public String toString() {
        return "WeaponType{" +
                "melee=" + melee +
                ", singleHanded=" + singleHanded +
                ", weightCategory=" + weightCategory +
                ", damageType=" + damageType +
                '}';
    }
}
