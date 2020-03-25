package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;

import java.util.Set;
import java.util.UUID;

public class SwordMoveDto {

    private UUID id;
    private String name;
    private String description;
    private int initiative;
    private int actions;
    private boolean humanoidOpponent;

    private Set<WeaponFamily> allowedUserWeapons;
    private Set<WeaponFamily> allowedOpponentWeapons;

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

    public Set<WeaponFamily> getAllowedUserWeapons() {
        return allowedUserWeapons;
    }

    public void setAllowedUserWeapons(Set<WeaponFamily> allowedUserWeapons) {
        this.allowedUserWeapons = allowedUserWeapons;
    }

    public Set<WeaponFamily> getAllowedOpponentWeapons() {
        return allowedOpponentWeapons;
    }

    public void setAllowedOpponentWeapons(Set<WeaponFamily> allowedOpponentWeapons) {
        this.allowedOpponentWeapons = allowedOpponentWeapons;
    }

    @Override
    public String toString() {
        return "SwordMoveDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", initiative=" + initiative +
                ", actions=" + actions +
                ", humanoidOpponent=" + humanoidOpponent +
                ", allowedUserWeapons=" + allowedUserWeapons +
                ", allowedOpponentWeapons=" + allowedOpponentWeapons +
                '}';
    }
}
