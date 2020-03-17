package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_BLUEPRINT_GOODS_BLUEPRINT")
public class PersonBlueprintGoodsBlueprint {

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private PersonBlueprint personBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private GoodsBlueprint goodsBlueprint;

    private Integer ownedPieces;

    public PersonBlueprintGoodsBlueprint() {}

    public PersonBlueprintGoodsBlueprint(PersonBlueprint personBlueprint, GoodsBlueprint goodsBlueprint, Integer ownedPieces) {
        this.id = new RelationTableId(personBlueprint.getId(), goodsBlueprint.getId());
        this.personBlueprint = personBlueprint;
        this.goodsBlueprint = goodsBlueprint;
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

    public GoodsBlueprint getGoodsBlueprint() {
        return goodsBlueprint;
    }

    public void setGoodsBlueprint(GoodsBlueprint goodsBlueprint) {
        this.goodsBlueprint = goodsBlueprint;
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

        PersonBlueprintGoodsBlueprint that = (PersonBlueprintGoodsBlueprint) o;

        if (!personBlueprint.equals(that.personBlueprint)) return false;
        return goodsBlueprint.equals(that.goodsBlueprint);
    }

    @Override
    public int hashCode() {
        int result = personBlueprint.hashCode();
        result = 31 * result + goodsBlueprint.hashCode();
        return result;
    }
}
