package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_BLUEPRINT_ARMOR_BLUEPRINT")
public class PersonBlueprintArmorBlueprint implements CharacterBlueprintItemBlueprint{

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private PersonBlueprint personBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private ArmorBlueprint armorBlueprint;

    private Integer ownedPieces;

    public PersonBlueprintArmorBlueprint() {}

    public PersonBlueprintArmorBlueprint(PersonBlueprint personBlueprint, ArmorBlueprint armorBlueprint, Integer ownedPieces) {
        this.id = new RelationTableId(personBlueprint.getId(), armorBlueprint.getId());
        this.personBlueprint = personBlueprint;
        this.armorBlueprint = armorBlueprint;
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

    public ArmorBlueprint getArmorBlueprint() {
        return armorBlueprint;
    }

    public void setArmorBlueprint(ArmorBlueprint armorBlueprint) {
        this.armorBlueprint = armorBlueprint;
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

        PersonBlueprintArmorBlueprint that = (PersonBlueprintArmorBlueprint) o;

        if (!personBlueprint.equals(that.personBlueprint)) return false;
        return armorBlueprint.equals(that.armorBlueprint);
    }

    @Override
    public int hashCode() {
        int result = personBlueprint.hashCode();
        result = 31 * result + armorBlueprint.hashCode();
        return result;
    }

    @Override
    public ItemBlueprint getItemBlueprint() {
        return armorBlueprint;
    }

    @Override
    public CharacterBlueprint getCharacterBlueprint() {
        return personBlueprint;
    }
}
