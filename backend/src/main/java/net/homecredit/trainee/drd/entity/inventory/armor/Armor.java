package net.homecredit.trainee.drd.entity.inventory.armor;

import net.homecredit.trainee.drd.entity.blueprint.item.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.shop.ItemType;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "ARMOR")
public class Armor extends Equipment {

    private int defense;
    private boolean equipped;

    @ElementCollection
    @CollectionTable(name = "ARMOR_COVERAGE", joinColumns = @JoinColumn(name = "ARMOR_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "BODY_SECTION")
    private Set<BodySection> coverage;

    public Armor() {
    }

    public Armor(ArmorBlueprint armorBlueprint) {
        super(armorBlueprint, ItemType.ARMOR);
        this.defense = armorBlueprint.getDefense();
        Set<BodySection> copiedCoverage = EnumSet.copyOf(armorBlueprint.getCoverage());
        this.coverage = copiedCoverage;
        //for practice
        this.equipped = false;
    }

    public Armor(ItemBlueprint itemBlueprint, StorageUnit storage, ItemType itemType, int defense, boolean equipped, Set<BodySection> coverage) {
        super(itemBlueprint, storage, itemType);
        this.defense = defense;
        this.equipped = equipped;
        this.coverage = coverage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public Set<BodySection> getCoverage() {
        return coverage;
    }

    public void setCoverage(Set<BodySection> coverage) {
        this.coverage = coverage;
    }
}
