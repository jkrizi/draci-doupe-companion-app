package net.homecredit.trainee.drd.entity.util;

import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;

import javax.persistence.*;

@Entity
@Table(name = "BEAST_BLUEPRINT_WEAPON_BLUEPRINT")
public class BeastBlueprintWeaponBlueprint implements CharacterBlueprintItemBlueprint{

    @EmbeddedId
    private RelationTableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private BeastBlueprint beastBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownedId")
    private WeaponBlueprint weaponBlueprint;

    private Integer ownedPieces;

    public BeastBlueprintWeaponBlueprint() {}

    public BeastBlueprintWeaponBlueprint(BeastBlueprint beastBlueprint, WeaponBlueprint weaponBlueprint, Integer ownedPieces) {
        this.id = new RelationTableId(beastBlueprint.getId(), weaponBlueprint.getId());
        this.beastBlueprint = beastBlueprint;
        this.weaponBlueprint = weaponBlueprint;
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

        BeastBlueprintWeaponBlueprint that = (BeastBlueprintWeaponBlueprint) o;

        if (!beastBlueprint.equals(that.beastBlueprint)) return false;
        return weaponBlueprint.equals(that.weaponBlueprint);
    }

    @Override
    public int hashCode() {
        int result = beastBlueprint.hashCode();
        result = 31 * result + weaponBlueprint.hashCode();
        return result;
    }

    @Override
    public ItemBlueprint getItemBlueprint() {
        return weaponBlueprint;
    }

    @Override
    public CharacterBlueprint getCharacterBlueprint() {
        return beastBlueprint;
    }
}
