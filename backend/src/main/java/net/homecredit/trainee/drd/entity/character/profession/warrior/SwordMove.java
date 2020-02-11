package net.homecredit.trainee.drd.entity.character.profession.warrior;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "swordMove")
    private Set<SwordMoveUserWeapon> allowedUserWeapons;
    @OneToMany(mappedBy = "swordMove")
    private Set<SwordMoveOpponentWeapon> allowedOpponentWeapons;

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

    public Set<SwordMoveUserWeapon> getAllowedUserWeapons() {
        return allowedUserWeapons;
    }

    public void setAllowedUserWeapons(Set<SwordMoveUserWeapon> allowedUserWeapons) {
        this.allowedUserWeapons = allowedUserWeapons;
    }

    public Set<SwordMoveOpponentWeapon> getAllowedOpponentWeapons() {
        return allowedOpponentWeapons;
    }

    public void setAllowedOpponentWeapons(Set<SwordMoveOpponentWeapon> allowedOpponentWeapons) {
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
