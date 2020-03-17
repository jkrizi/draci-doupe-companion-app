package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_BLUEPRINT_WEAPON_BLUEPRINT")
public class PersonBlueprintWeaponBlueprint {

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private PersonBlueprint personBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private WeaponBlueprint weaponBlueprint;

    private Integer ownedPieces;

    public PersonBlueprintWeaponBlueprint() {}

    public PersonBlueprintWeaponBlueprint(PersonBlueprint personBlueprint, WeaponBlueprint weaponBlueprint, Integer ownedPieces) {
        this.personBlueprint = personBlueprint;
        this.weaponBlueprint = weaponBlueprint;
        this.id = new RelationTableId(personBlueprint.getId(), weaponBlueprint.getId());
        this.ownedPieces = ownedPieces;
    }

    public RelationTableId getId() {
        return id;
    }

    public void setId(RelationTableId id) {
        this.id = id;
    }

    public PersonBlueprint getPersonBlueprint() {
        return personBlueprint;
    }

    public void setPersonBlueprint(PersonBlueprint personBlueprint) {
        this.personBlueprint = personBlueprint;
    }

    public WeaponBlueprint getWeaponBlueprint() {
        return weaponBlueprint;
    }

    public void setWeaponBlueprint(WeaponBlueprint weaponBlueprint) {
        this.weaponBlueprint = weaponBlueprint;
    }

    public Integer getOwnedPieces() {
        return ownedPieces;
    }

    public void setOwnedPieces(Integer ownedPieces) {
        this.ownedPieces = ownedPieces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonBlueprintWeaponBlueprint that = (PersonBlueprintWeaponBlueprint) o;

        if (!personBlueprint.equals(that.personBlueprint)) return false;
        return weaponBlueprint.equals(that.weaponBlueprint);
    }

    @Override
    public int hashCode() {
        int result = personBlueprint.hashCode();
        result = 31 * result + weaponBlueprint.hashCode();
        return result;
    }
}
