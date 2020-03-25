package net.homecredit.trainee.drd.entity.character.beast;

import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.character.combat.CombatValues;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.entity.util.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BEAST_BLUEPRINT")
public class BeastBlueprint implements CharacterBlueprint {

    @Id
    private UUID id;
    private String origin;
    private String name;
    private String species;
    private String description;
    private Integer viability;
    private Integer viabilityBonus;
    private Integer manna;
    private Integer mobility;
    private Integer persistence;

    @OneToMany()
    @JoinTable(
            name = "BEAST_BLUEPRINT_ABILITY_SCORE",
            joinColumns = @JoinColumn(name = "BEAST_BLUEPRINT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ABILITY_SCORE_ID")
    )
    @MapKey(name = "ability")
    @MapKeyEnumerated
    private Map<Ability, AbilityScore> abilityMap = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "BEAST_SIZE", joinColumns = @JoinColumn(name = "BEAST_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "CHARACTER_SIZE")
    private Set<CharacterSize> sizes;

    @ElementCollection
    @CollectionTable(name = "BEAST_VULNERABILITY", joinColumns = @JoinColumn(name = "BEAST_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "VULNERABILITY")
    private Set<Vulnerability> vulnerabilities;

    private Integer initiative;
    private Integer pugnacity;
    private Integer domestication;
    private Boolean schooled;

    @OneToMany(
            mappedBy = "beastBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<BeastBlueprintWeaponBlueprint> weaponBlueprints = new HashSet<>();

    @OneToMany(
            mappedBy = "beastBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<BeastBlueprintArmorBlueprint> armorBlueprints = new HashSet<>();

    @OneToMany(
            mappedBy = "beastBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<BeastBlueprintTreasureBlueprint> treasureBlueprints = new HashSet<>();

    @OneToMany(
            mappedBy = "beastBlueprint",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<BeastBlueprintGoodsBlueprint> goodsBlueprints = new HashSet<>();

    private Double coinPouch;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViability() {
        return viability;
    }

    public void setViability(Integer viability) {
        this.viability = viability;
    }

    public Integer getViabilityBonus() {
        return viabilityBonus;
    }

    public void setViabilityBonus(Integer viabilityBonus) {
        this.viabilityBonus = viabilityBonus;
    }

    public Integer getManna() {
        return manna;
    }

    public void setManna(Integer manna) {
        this.manna = manna;
    }

    public Integer getMobility() {
        return mobility;
    }

    public void setMobility(Integer mobility) {
        this.mobility = mobility;
    }

    public Integer getPersistence() {
        return persistence;
    }

    public void setPersistence(Integer persistence) {
        this.persistence = persistence;
    }

    public Map<Ability, AbilityScore> getAbilityMap() {
        return abilityMap;
    }

    public void setAbilityMap(Map<Ability, AbilityScore> abilityMap) {
        this.abilityMap = abilityMap;
    }

    public Set<CharacterSize> getSizes() {
        return sizes;
    }

    public void setSizes(Set<CharacterSize> sizes) {
        this.sizes = sizes;
    }

    public Set<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Set<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getPugnacity() {
        return pugnacity;
    }

    public void setPugnacity(Integer pugnacity) {
        this.pugnacity = pugnacity;
    }

    public Integer getDomestication() {
        return domestication;
    }

    public void setDomestication(Integer domestication) {
        this.domestication = domestication;
    }

    public Boolean getSchooled() {
        return schooled;
    }

    public void setSchooled(Boolean schooled) {
        this.schooled = schooled;
    }

    public Set<BeastBlueprintWeaponBlueprint> getWeaponBlueprints() {
        return weaponBlueprints;
    }

    public void setWeaponBlueprints(Set<BeastBlueprintWeaponBlueprint> weaponBlueprints) {
        this.weaponBlueprints = weaponBlueprints;
    }

    public Set<BeastBlueprintArmorBlueprint> getArmorBlueprints() {
        return armorBlueprints;
    }

    public void setArmorBlueprints(Set<BeastBlueprintArmorBlueprint> armorBlueprints) {
        this.armorBlueprints = armorBlueprints;
    }

    public Set<BeastBlueprintTreasureBlueprint> getTreasureBlueprints() {
        return treasureBlueprints;
    }

    public void setTreasureBlueprints(Set<BeastBlueprintTreasureBlueprint> treasureBlueprints) {
        this.treasureBlueprints = treasureBlueprints;
    }

    public Set<BeastBlueprintGoodsBlueprint> getGoodsBlueprints() {
        return goodsBlueprints;
    }

    public void setGoodsBlueprints(Set<BeastBlueprintGoodsBlueprint> goodsBlueprints) {
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
        if (!(o instanceof BeastBlueprint)) return false;
        BeastBlueprint that = (BeastBlueprint) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BeastBlueprint{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", description='" + description + '\'' +
                ", viability=" + viability +
                ", viabilityBonus=" + viabilityBonus +
                ", manna=" + manna +
                ", mobility=" + mobility +
                ", persistence=" + persistence +
                ", abilityMap=" + abilityMap +
                ", sizes=" + sizes +
                ", vulnerabilities=" + vulnerabilities +
                ", initiative=" + initiative +
                ", pugnacity=" + pugnacity +
                ", domestication=" + domestication +
                ", schooled=" + schooled +
                ", weaponBlueprints=" + weaponBlueprints +
                ", armorBlueprints=" + armorBlueprints +
                ", treasureBlueprints=" + treasureBlueprints +
                ", goodsBlueprints=" + goodsBlueprints +
                ", coinPouch=" + coinPouch +
                '}';
    }

    @Override
    public Set<CharacterBlueprintItemBlueprint> getArmorBlueprintsNewSet() {
        return new HashSet<>(armorBlueprints);
    }

    @Override
    public Set<CharacterBlueprintItemBlueprint> getGoodsBlueprintsNewSet() {
        return new HashSet<>(goodsBlueprints);
    }

    @Override
    public Set<CharacterBlueprintItemBlueprint> getTreasureBlueprintsNewSet() {
        return new HashSet<>(treasureBlueprints);
    }

    @Override
    public Set<CharacterBlueprintItemBlueprint> getWeaponBlueprintsNewSet() {
        return new HashSet<>(weaponBlueprints);
    }
}
