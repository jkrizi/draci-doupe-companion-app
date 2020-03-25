package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.GoodsBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.TreasureBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;

import java.util.*;

public class BeastBlueprintDto implements CharacterBlueprintDto {

    private UUID id;
    private String origin;
    private String name;
    private String species;
    private String description;
    private int viability;
    private int viabilityBonus;
    private int manna;
    private int mobility;

    private List<AbilityScoreDto> abilityMap = new ArrayList<>();
    private List<String> sizes;
    private List<String> vulnerabilities;

    private int initiative;

    private int pugnacity;
    private int persistence;
    private int domestication;
    private boolean schooled;

    private Set<WeaponBlueprintDto> weaponry = new HashSet<>();
    private Set<ArmorBlueprintDto> armory = new HashSet<>();
    private Set<TreasureBlueprintDto> treasury = new HashSet<>();
    private Set<GoodsBlueprintDto> goods = new HashSet<>();
    private int gold;
    private int silver;
    private int copper;

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

    public int getViability() {
        return viability;
    }

    public void setViability(int viability) {
        this.viability = viability;
    }

    public int getViabilityBonus() {
        return viabilityBonus;
    }

    public void setViabilityBonus(int viabilityBonus) {
        this.viabilityBonus = viabilityBonus;
    }

    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    public int getMobility() {
        return mobility;
    }

    public void setMobility(int mobility) {
        this.mobility = mobility;
    }

    public List<AbilityScoreDto> getAbilityMap() {
        return abilityMap;
    }

    public void setAbilityMap(List<AbilityScoreDto> abilityMap) {
        this.abilityMap = abilityMap;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(List<String> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getPugnacity() {
        return pugnacity;
    }

    public void setPugnacity(int pugnacity) {
        this.pugnacity = pugnacity;
    }

    public int getPersistence() {
        return persistence;
    }

    public void setPersistence(int persistence) {
        this.persistence = persistence;
    }

    public int getDomestication() {
        return domestication;
    }

    public void setDomestication(int domestication) {
        this.domestication = domestication;
    }

    public boolean isSchooled() {
        return schooled;
    }

    public void setSchooled(boolean schooled) {
        this.schooled = schooled;
    }

    @Override
    public Set<WeaponBlueprintDto> getWeaponry() {
        return weaponry;
    }

    @Override
    public void setWeaponry(Set<WeaponBlueprintDto> weaponry) {
        this.weaponry = weaponry;
    }

    @Override
    public Set<ArmorBlueprintDto> getArmory() {
        return armory;
    }

    @Override
    public void setArmory(Set<ArmorBlueprintDto> armory) {
        this.armory = armory;
    }

    @Override
    public Set<TreasureBlueprintDto> getTreasury() {
        return treasury;
    }

    @Override
    public void setTreasury(Set<TreasureBlueprintDto> treasury) {
        this.treasury = treasury;
    }

    @Override
    public Set<GoodsBlueprintDto> getGoods() {
        return goods;
    }

    @Override
    public void setGoods(Set<GoodsBlueprintDto> goods) {
        this.goods = goods;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    @Override
    public String toString() {
        return "BeastBlueprintDto{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", description='" + description + '\'' +
                ", viability=" + viability +
                ", viabilityBonus=" + viabilityBonus +
                ", manna=" + manna +
                ", mobility=" + mobility +
                ", abilityMap=" + abilityMap +
                ", sizes=" + sizes +
                ", vulnerabilities=" + vulnerabilities +
                ", initiative=" + initiative +
                ", pugnacity=" + pugnacity +
                ", persistence=" + persistence +
                ", domestication=" + domestication +
                ", schooled=" + schooled +
                ", weaponry=" + weaponry +
                ", armory=" + armory +
                ", treasury=" + treasury +
                ", goods=" + goods +
                ", gold=" + gold +
                ", silver=" + silver +
                ", copper=" + copper +
                '}';
    }
}
