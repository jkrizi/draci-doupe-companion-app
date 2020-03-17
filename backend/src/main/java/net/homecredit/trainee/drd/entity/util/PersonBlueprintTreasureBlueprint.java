package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_BLUEPRINT_TREASURE_BLUEPRINT")
public class PersonBlueprintTreasureBlueprint {

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private PersonBlueprint personBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private TreasureBlueprint treasureBlueprint;

    private Integer ownedPieces;

    public PersonBlueprintTreasureBlueprint() {}

    public PersonBlueprintTreasureBlueprint(PersonBlueprint personBlueprint, TreasureBlueprint treasureBlueprint, Integer ownedPieces) {
        this.id = new RelationTableId(personBlueprint.getId(), treasureBlueprint.getId());
        this.personBlueprint = personBlueprint;
        this.treasureBlueprint = treasureBlueprint;
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

    public TreasureBlueprint getTreasureBlueprint() {
        return treasureBlueprint;
    }

    public void setTreasureBlueprint(TreasureBlueprint treasureBlueprint) {
        this.treasureBlueprint = treasureBlueprint;
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

        PersonBlueprintTreasureBlueprint that = (PersonBlueprintTreasureBlueprint) o;

        if (!personBlueprint.equals(that.personBlueprint)) return false;
        return treasureBlueprint.equals(that.treasureBlueprint);
    }

    @Override
    public int hashCode() {
        int result = personBlueprint.hashCode();
        result = 31 * result + treasureBlueprint.hashCode();
        return result;
    }
}
