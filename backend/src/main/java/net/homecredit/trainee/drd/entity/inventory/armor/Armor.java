package net.homecredit.trainee.drd.entity.inventory.armor;

import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ARMOR")
public class Armor extends Equipment {

    private int defense;
    private boolean equipped;

    @ElementCollection
    @CollectionTable(name="ARMOR_COVERAGE", joinColumns = @JoinColumn(name = "ARMOR_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "BODY_SECTION")
    private Set<BodySection> coverage;

    public Armor() {}

    public Armor(String name, String description, int weight, StorageUnit storage, int defense, boolean equipped, Set<BodySection> coverage) {
        super(name, description, weight, storage);
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
