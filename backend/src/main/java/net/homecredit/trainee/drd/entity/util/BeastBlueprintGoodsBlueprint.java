package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "BEAST_BLUEPRINT_GOODS_BLUEPRINT")
public class BeastBlueprintGoodsBlueprint implements CharacterBlueprintItemBlueprint{

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private BeastBlueprint beastBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private GoodsBlueprint goodsBlueprint;

    private Integer ownedPieces;

    public BeastBlueprintGoodsBlueprint() {}

    public BeastBlueprintGoodsBlueprint(BeastBlueprint beastBlueprint, GoodsBlueprint goodsBlueprint, Integer ownedPieces) {
        this.id = new RelationTableId(beastBlueprint.getId(), goodsBlueprint.getId());
        this.beastBlueprint = beastBlueprint;
        this.goodsBlueprint = goodsBlueprint;
        this.ownedPieces = ownedPieces;
    }

    public RelationTableId getId() {
        return id;
    }

    public void setId(RelationTableId id) {
        this.id = id;
    }

    public BeastBlueprint getBeastBlueprint() {
        return beastBlueprint;
    }

    public void setBeastBlueprint(BeastBlueprint beastBlueprint) {
        this.beastBlueprint = beastBlueprint;
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

        BeastBlueprintGoodsBlueprint that = (BeastBlueprintGoodsBlueprint) o;

        if (!beastBlueprint.equals(that.beastBlueprint)) return false;
        return goodsBlueprint.equals(that.goodsBlueprint);
    }

    @Override
    public int hashCode() {
        int result = beastBlueprint.hashCode();
        result = 31 * result + goodsBlueprint.hashCode();
        return result;
    }

    @Override
    public ItemBlueprint getItemBlueprint() {
        return goodsBlueprint;
    }

    @Override
    public CharacterBlueprint getCharacterBlueprint() {
        return beastBlueprint;
    }
}
