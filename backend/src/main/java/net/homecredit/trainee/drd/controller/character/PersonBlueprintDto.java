package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.GoodsBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.TreasureBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;
import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.race.Race;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PersonBlueprintDto implements CharacterBlueprintDto {

    private UUID id;
    private String name;
    private String description;
    private int level;
    private Race race;
    private Profession profession;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
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
        return "PersonBlueprintDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", race=" + race +
                ", profession=" + profession +
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
