package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "BEAST_BLUEPRINT_ARMOR_BLUEPRINT")
public class BeastBlueprintArmorBlueprint implements CharacterBlueprintItemBlueprint{

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private BeastBlueprint beastBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private ArmorBlueprint armorBlueprint;

    private Integer ownedPieces;

    public BeastBlueprintArmorBlueprint() {}

    public BeastBlueprintArmorBlueprint(BeastBlueprint beastBlueprint, ArmorBlueprint armorBlueprint, Integer ownedPieces) {
        this.id = new RelationTableId(beastBlueprint.getId(), armorBlueprint.getId());
        this.beastBlueprint = beastBlueprint;
        this.armorBlueprint = armorBlueprint;
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

        BeastBlueprintArmorBlueprint that = (BeastBlueprintArmorBlueprint) o;

        if (!beastBlueprint.equals(that.beastBlueprint)) return false;
        return armorBlueprint.equals(that.armorBlueprint);
    }

    @Override
    public int hashCode() {
        int result = beastBlueprint.hashCode();
        result = 31 * result + armorBlueprint.hashCode();
        return result;
    }

    @Override
    public ItemBlueprint getItemBlueprint() {
        return armorBlueprint;
    }

    @Override
    public CharacterBlueprint getCharacterBlueprint() {
        return beastBlueprint;
    }
}
