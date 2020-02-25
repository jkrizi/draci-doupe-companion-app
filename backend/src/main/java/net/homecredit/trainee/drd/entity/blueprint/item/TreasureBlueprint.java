package net.homecredit.trainee.drd.entity.blueprint.item;

import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.GemStone;
import net.homecredit.trainee.drd.util.Material;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "TREASURE_BLUEPRINT")
public class TreasureBlueprint implements ItemBlueprint {

    @Id
    private UUID id;
    private String name;
    @Column(name = "PUBLIC_DESCRIPTION")
    private String publicDescription;
    @Column(name = "PRIVATE_DESCRIPTION")
    private String privateDescription;

    @OneToMany(mappedBy = "treasureBlueprint", cascade = CascadeType.ALL)
    private Collection<GemStone> gemStones;

    @Enumerated(EnumType.STRING)
    private Material material;
    @Column(name = "MATERIAL_WEIGHT")
    private int materialWeight;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_QUALITY")
    private SkillKnowledge productQuality;

    @Column(name = "TREASURE_VALUE")
    private double treasureValue;

    public TreasureBlueprint() {
    }

    public TreasureBlueprint(String name, String publicDescription, String privateDescription, Collection<GemStone> gemStones, Material material, int materialWeight, SkillKnowledge productQuality, double treasureValue) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
        this.gemStones = gemStones;
        this.material = material;
        this.materialWeight = materialWeight;
        this.productQuality = productQuality;
        this.treasureValue = treasureValue;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int getWeight() {
        int weight = getMaterialWeight();
        for(GemStone gs: getGemStones()) {
            weight += gs.getStoneWeight();
        }
        return weight;
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

    public Collection<GemStone> getGemStones() {
        return gemStones;
    }

    public void setGemStones(Collection<GemStone> gemStones) {
        this.gemStones = gemStones;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getMaterialWeight() {
        return materialWeight;
    }

    public void setMaterialWeight(int metalWeight) {
        this.materialWeight = metalWeight;
    }

    public SkillKnowledge getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(SkillKnowledge productQuality) {
        this.productQuality = productQuality;
    }

    public double getTreasureValue() {
        return treasureValue;
    }

    public void setTreasureValue(double treasureValue) {
        this.treasureValue = treasureValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreasureBlueprint)) return false;
        TreasureBlueprint that = (TreasureBlueprint) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TreasureBlueprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicDescription='" + publicDescription + '\'' +
                ", privateDescription='" + privateDescription + '\'' +
                ", gemStones=" + gemStones +
                ", material=" + material +
                ", materialWeight=" + materialWeight +
                ", productQuality=" + productQuality +
                ", treasureValue=" + treasureValue +
                '}';
    }
}
