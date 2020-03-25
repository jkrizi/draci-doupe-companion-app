package net.homecredit.trainee.drd.entity.character.person.profession.warrior;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class SwordMove {

    @Id
    private UUID id;
    private String name;
    private String description;
    private Integer initiative;
    private Integer actions;
    private Boolean humanoidOpponent;

    @ManyToMany
    @JoinTable(
            name = "SWORD_MOVE_WEAPON_USER",
            joinColumns = @JoinColumn(name = "SWORD_MOVE_ID"),
            inverseJoinColumns = @JoinColumn(name = "WEAPON_FAMILY_ID")
    )
    private Set<WeaponFamily> allowedUserWeapons;
    @ManyToMany
    @JoinTable(
            name = "SWORD_MOVE_WEAPON_OPPONENT",
            joinColumns = @JoinColumn(name = "SWORD_MOVE_ID"),
            inverseJoinColumns = @JoinColumn(name = "WEAPON_FAMILY_ID")
    )
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

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getActions() {
        return actions;
    }

    public void setActions(Integer actions) {
        this.actions = actions;
    }

    public Boolean isHumanoidOpponent() {
        return humanoidOpponent;
    }

    public void setHumanoidOpponent(Boolean humanoidOpponent) {
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
        return "SwordMove{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", initiative=" + initiative +
                ", actions=" + actions +
                ", humanoidOpponent=" + humanoidOpponent +
                ", userWeaponTypes=" + allowedUserWeapons +
                ", opponentWeaponTypes=" + allowedOpponentWeapons +
                '}';
    }
}
