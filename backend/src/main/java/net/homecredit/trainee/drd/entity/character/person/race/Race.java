package net.homecredit.trainee.drd.entity.character.person.race;

import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Race {

    @Id
    private UUID id;
    private String name;
    private String description;
    private Integer minWeight;
    private Integer maxWeight;
    private Integer minHeight;
    private Integer maxHeight;

    @Enumerated(EnumType.STRING)
    @Column(name = "race_size")
    private CharacterSize size;

    @ManyToOne
    private WeaponFamily weapon;

    private Integer strengthThrows;
    private Integer dexterityThrows;
    private Integer resistanceThrows;
    private Integer intelligenceThrows;
    private Integer charismaThrows;

    private Integer strengthBase;
    private Integer dexterityBase;
    private Integer resistanceBase;
    private Integer intelligenceBase;
    private Integer charismaBase;

    private Integer strengthCorrection;
    private Integer dexterityCorrection;
    private Integer resistanceCorrection;
    private Integer intelligenceCorrection;
    private Integer charismaCorrection;

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

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight) {
        this.minHeight = minHeight;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public CharacterSize getSize() {
        return size;
    }

    public void setSize(CharacterSize size) {
        this.size = size;
    }

    public WeaponFamily getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponFamily weapon) {
        this.weapon = weapon;
    }

    public Integer getStrengthThrows() {
        return strengthThrows;
    }

    public void setStrengthThrows(Integer strengthThrows) {
        this.strengthThrows = strengthThrows;
    }

    public Integer getDexterityThrows() {
        return dexterityThrows;
    }

    public void setDexterityThrows(Integer dexterityThrows) {
        this.dexterityThrows = dexterityThrows;
    }

    public Integer getResistanceThrows() {
        return resistanceThrows;
    }

    public void setResistanceThrows(Integer resistanceThrows) {
        this.resistanceThrows = resistanceThrows;
    }

    public Integer getIntelligenceThrows() {
        return intelligenceThrows;
    }

    public void setIntelligenceThrows(Integer intelligenceThrows) {
        this.intelligenceThrows = intelligenceThrows;
    }

    public Integer getCharismaThrows() {
        return charismaThrows;
    }

    public void setCharismaThrows(Integer charismaThrows) {
        this.charismaThrows = charismaThrows;
    }

    public Integer getStrengthBase() {
        return strengthBase;
    }

    public void setStrengthBase(Integer strengthBase) {
        this.strengthBase = strengthBase;
    }

    public Integer getDexterityBase() {
        return dexterityBase;
    }

    public void setDexterityBase(Integer dexterityBase) {
        this.dexterityBase = dexterityBase;
    }

    public Integer getResistanceBase() {
        return resistanceBase;
    }

    public void setResistanceBase(Integer resistanceBase) {
        this.resistanceBase = resistanceBase;
    }

    public Integer getIntelligenceBase() {
        return intelligenceBase;
    }

    public void setIntelligenceBase(Integer intelligenceBase) {
        this.intelligenceBase = intelligenceBase;
    }

    public Integer getCharismaBase() {
        return charismaBase;
    }

    public void setCharismaBase(Integer charismaBase) {
        this.charismaBase = charismaBase;
    }

    public Integer getStrengthCorrection() {
        return strengthCorrection;
    }

    public void setStrengthCorrection(Integer strengthCorrection) {
        this.strengthCorrection = strengthCorrection;
    }

    public Integer getDexterityCorrection() {
        return dexterityCorrection;
    }

    public void setDexterityCorrection(Integer dexterityCorrection) {
        this.dexterityCorrection = dexterityCorrection;
    }

    public Integer getResistanceCorrection() {
        return resistanceCorrection;
    }

    public void setResistanceCorrection(Integer resistanceCorrection) {
        this.resistanceCorrection = resistanceCorrection;
    }

    public Integer getIntelligenceCorrection() {
        return intelligenceCorrection;
    }

    public void setIntelligenceCorrection(Integer intelligenceCorrection) {
        this.intelligenceCorrection = intelligenceCorrection;
    }

    public Integer getCharismaCorrection() {
        return charismaCorrection;
    }

    public void setCharismaCorrection(Integer charismaCorrection) {
        this.charismaCorrection = charismaCorrection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        Race race = (Race) o;
        return id.equals(race.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
