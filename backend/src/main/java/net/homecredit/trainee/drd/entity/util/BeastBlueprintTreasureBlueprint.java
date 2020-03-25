package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "BEAST_BLUEPRINT_TREASURE_BLUEPRINT")
public class BeastBlueprintTreasureBlueprint implements CharacterBlueprintItemBlueprint{

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private BeastBlueprint beastBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private TreasureBlueprint treasureBlueprint;

    private Integer ownedPieces;

    public BeastBlueprintTreasureBlueprint() {}

    public BeastBlueprintTreasureBlueprint(BeastBlueprint beastBlueprint, TreasureBlueprint treasureBlueprint, Integer ownedPieces) {
        this.id = new RelationTableId(beastBlueprint.getId(), treasureBlueprint.getId());
        this.beastBlueprint = beastBlueprint;
        this.treasureBlueprint = treasureBlueprint;
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

        BeastBlueprintTreasureBlueprint that = (BeastBlueprintTreasureBlueprint) o;

        if (!beastBlueprint.equals(that.beastBlueprint)) return false;
        return treasureBlueprint.equals(that.treasureBlueprint);
    }

    @Override
    public int hashCode() {
        int result = beastBlueprint.hashCode();
        result = 31 * result + treasureBlueprint.hashCode();
        return result;
    }

    @Override
    public ItemBlueprint getItemBlueprint() {
        return treasureBlueprint;
    }

    @Override
    public CharacterBlueprint getCharacterBlueprint() {
        return beastBlueprint;
    }
}
