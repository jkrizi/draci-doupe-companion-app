package net.homecredit.trainee.drd.entity.character.person;

import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.race.Race;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintArmorBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintGoodsBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintTreasureBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintWeaponBlueprint;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "PERSON_BLUEPRINT")
public class PersonBlueprint {

    @Id
    private UUID id;
    private String name;
    private String description;

    @Column(name = "PERSON_LEVEL")
    private Integer level;

    @ManyToOne(fetch = FetchType.LAZY)
    private Race race;
    @Enumerated(EnumType.STRING)
    private Profession profession;

    @OneToMany(
            mappedBy = "personBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PersonBlueprintWeaponBlueprint> weaponBlueprints = new HashSet<>();

    @OneToMany(
            mappedBy = "personBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PersonBlueprintArmorBlueprint> armorBlueprints = new HashSet<>();

    @OneToMany(
            mappedBy = "personBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PersonBlueprintTreasureBlueprint> treasureBlueprints = new HashSet<>();

    @OneToMany(
            mappedBy = "personBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PersonBlueprintGoodsBlueprint> goodsBlueprints = new HashSet<>();

    private Double coinPouch;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Set<PersonBlueprintWeaponBlueprint> getWeaponBlueprints() {
        return weaponBlueprints;
    }

    public void setWeaponBlueprints(Set<PersonBlueprintWeaponBlueprint> weaponBlueprints) {
        this.weaponBlueprints = weaponBlueprints;
    }

    public Set<PersonBlueprintArmorBlueprint> getArmorBlueprints() {
        return armorBlueprints;
    }

    public void setArmorBlueprints(Set<PersonBlueprintArmorBlueprint> armorBlueprints) {
        this.armorBlueprints = armorBlueprints;
    }

    public Set<PersonBlueprintTreasureBlueprint> getTreasureBlueprints() {
        return treasureBlueprints;
    }

    public void setTreasureBlueprints(Set<PersonBlueprintTreasureBlueprint> treasureBlueprints) {
        this.treasureBlueprints = treasureBlueprints;
    }

    public Set<PersonBlueprintGoodsBlueprint> getGoodsBlueprints() {
        return goodsBlueprints;
    }

    public void setGoodsBlueprints(Set<PersonBlueprintGoodsBlueprint> goodsBlueprints) {
        this.goodsBlueprints = goodsBlueprints;
    }

    public Double getCoinPouch() {
        return coinPouch;
    }

    public void setCoinPouch(Double coinPouch) {
        this.coinPouch = coinPouch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonBlueprint that = (PersonBlueprint) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "PersonBlueprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", race=" + race +
                ", profession=" + profession +
                ", weaponBlueprints=" + weaponBlueprints +
                ", armorBlueprints=" + armorBlueprints +
                ", treasureBlueprints=" + treasureBlueprints +
                ", goodsBlueprints=" + goodsBlueprints +
                ", coinPouch=" + coinPouch +
                '}';
    }
}
