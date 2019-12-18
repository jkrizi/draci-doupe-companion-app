package net.homecredit.trainee.drd.entity.blueprint.item;

import net.homecredit.trainee.drd.entity.inventory.armor.BodySection;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ARMOR_BLUEPRINT")
public class ArmorBlueprint implements ItemBlueprint {

    @Id
    private UUID id;
    private String name;
    @Column(name = "PUBLIC_DESCRIPTION")
    private String publicDescription;
    @Column(name = "PRIVATE_DESCRIPTION")
    private String privateDescription;

    private int weight;

    private int defense;

    @ElementCollection
    @CollectionTable(name="ARMOR_COVERAGE_BLUEPRINT", joinColumns = @JoinColumn(name = "ARMOR_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "BODY_SECTION")
    private Set<BodySection> coverage;

    public ArmorBlueprint() {}

    public ArmorBlueprint(String name, String publicDescription, String privateDescription, int weight, int defense, Set<BodySection> coverage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
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
}
