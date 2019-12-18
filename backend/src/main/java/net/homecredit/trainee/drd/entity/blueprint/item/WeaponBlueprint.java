package net.homecredit.trainee.drd.entity.blueprint.item;


import net.homecredit.trainee.entity.inventory.weapon.WeaponType;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "WEAPON_BLUEPRINT")
public class WeaponBlueprint implements ItemBlueprint {

    @Id
    private UUID id;
    private String name;
    @Column(name = "PRIVATE_DESCRIPTION")
    private String privateDescription;
    @Column(name = "PUBLIC_DESCRIPTION")
    private String publicDescription;
    private int weight;

    private int attack;
    private int hurt;
    private int defense;
    @Column(name = "INITIATIVE_MODIFIER")
    private int initiativeModifier;

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

    @ElementCollection
    @CollectionTable(name="WEAPON_TYPE_BLUEPRINT", joinColumns = @JoinColumn(name = "WEAPON_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "WEAPON_TYPE")
    private Set<WeaponType> type;

    public WeaponBlueprint() {}

    public WeaponBlueprint(String name, String publicDescription, String privateDescription, int weight, int attack, int hurt, int defense, int initiativeModifier, int shortRangeLimit, int midRangeLimit, int longRangeLimit, int minReach, int maxReach, Set<WeaponType> type) {
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
        this.minReach = minReach;
        this.maxReach = maxReach;
        this.type = type;
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

    public Set<WeaponType> getType() {
        return type;
    }

    public void setType(Set<WeaponType> type) {
        this.type = type;
    }
}
