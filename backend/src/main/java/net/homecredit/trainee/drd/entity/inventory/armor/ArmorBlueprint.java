package net.homecredit.trainee.drd.entity.inventory.armor;

import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ARMOR_BLUEPRINT")
public class ArmorBlueprint implements ItemBlueprint {

    @Id
    private UUID id;
    private String name;
    private String publicDescription;
    private String privateDescription;

    @Enumerated(value = EnumType.STRING)
    private CharacterSize armorSize;
    private int weight;

    private int defense;

    @ElementCollection
    @CollectionTable(name = "ARMOR_COVERAGE_BLUEPRINT", joinColumns = @JoinColumn(name = "ARMOR_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "BODY_SECTION")
    private Set<BodySection> coverage;

    public ArmorBlueprint() {
    }

    public ArmorBlueprint(String name, String publicDescription, String privateDescription, CharacterSize armorSize, int weight, int defense, Set<BodySection> coverage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
        this.armorSize = armorSize;
        this.weight = weight;
        this.defense = defense;
        this.coverage = coverage;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public String getPrivateDescription() {
        return privateDescription;
    }

    public void setPrivateDescription(String privateDescription) {
        this.privateDescription = privateDescription;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Set<BodySection> getCoverage() {
        return coverage;
    }

    public void setCoverage(Set<BodySection> coverage) {
        this.coverage = coverage;
    }

    public CharacterSize getArmorSize() {
        return armorSize;
    }

    public void setArmorSize(CharacterSize armorSize) {
        this.armorSize = armorSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArmorBlueprint)) return false;
        ArmorBlueprint that = (ArmorBlueprint) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ArmorBlueprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicDescription='" + publicDescription + '\'' +
                ", privateDescription='" + privateDescription + '\'' +
                ", weight=" + weight +
                ", defense=" + defense +
                ", coverage=" + coverage +
                '}';
    }
}
