package net.homecredit.trainee.drd.entity.character.profession;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponType;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class SwordMove {

    @Id
    private UUID id;
    private String name;
    private String description;
    private int initiative;
    private int actions;
    private boolean humanoidOpponent;

    @ElementCollection
    @CollectionTable(name = "SWORD_MOVE_USER_WEAPON", joinColumns = @JoinColumn(name = "SWORD_MOVE_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "WEAPON_TYPE")
    private Set<WeaponType> userWeaponTypes;

    @ElementCollection
    @CollectionTable(name = "SWORD_MOVE_OPPONENT_WEAPON", joinColumns = @JoinColumn(name = "SWORD_MOVE_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "WEAPON_TYPE")
    private Set<WeaponType> opponentWeaponTypes;

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

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getActions() {
        return actions;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    public boolean isHumanoidOpponent() {
        return humanoidOpponent;
    }

    public void setHumanoidOpponent(boolean humanoidOpponent) {
        this.humanoidOpponent = humanoidOpponent;
    }

    public Set<WeaponType> getUserWeaponTypes() {
        return userWeaponTypes;
    }

    public void setUserWeaponTypes(Set<WeaponType> userWeaponTypes) {
        this.userWeaponTypes = userWeaponTypes;
    }

    public Set<WeaponType> getOpponentWeaponTypes() {
        return opponentWeaponTypes;
    }

    public void setOpponentWeaponTypes(Set<WeaponType> opponentWeaponTypes) {
        this.opponentWeaponTypes = opponentWeaponTypes;
    }

    @Override
    public String toString() {
        return "SwordMove{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", initiative=" + initiative +
                ", actions=" + actions +
                ", humanoidOpponent=" + humanoidOpponent +
                ", userWeaponTypes=" + userWeaponTypes +
                ", opponentWeaponTypes=" + opponentWeaponTypes +
                '}';
    }
}
