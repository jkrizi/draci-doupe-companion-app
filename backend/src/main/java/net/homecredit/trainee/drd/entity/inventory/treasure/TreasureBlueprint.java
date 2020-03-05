package net.homecredit.trainee.drd.entity.inventory.treasure;

import net.homecredit.trainee.drd.entity.character.person.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
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
    private Collection<Gemstone> gemstones;

    @Enumerated(EnumType.STRING)
    private Material material;
    @Column(name = "MATERIAL_WEIGHT")
    private int materialWeight;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_QUALITY")
    private SkillKnowledge productQuality;

    @Column(name = "GOLD_VALUE")
    private double goldValue;

    @Column(name = "SILVER_VALUE")
    private double silverValue;

    @Column(name = "COPPER_VALUE")
    private double copperValue;

    public TreasureBlueprint() {
    }

    public TreasureBlueprint(String name, String publicDescription, String privateDescription, Collection<Gemstone> gemstones, Material material, int materialWeight, SkillKnowledge productQuality, double goldValue, double silverValue, double copperValue) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
        this.gemstones = gemstones;
        this.material = material;
        this.materialWeight = materialWeight;
        this.productQuality = productQuality;
        this.goldValue = goldValue;
        this.silverValue = silverValue;
        this.copperValue = copperValue;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int getWeight() {
        int weight = getMaterialWeight();
        for(Gemstone gs: getGemstones()) {
            weight += gs.getWeight();
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

    public Collection<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(Collection<Gemstone> gemstones) {
        this.gemstones = gemstones;
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

    public double getGoldValue() {
        return goldValue;
    }

    public void setGoldValue(double goldValue) {
        this.goldValue = goldValue;
    }

    public double getSilverValue() {
        return silverValue;
    }

    public void setSilverValue(double silverValue) {
        this.silverValue = silverValue;
    }

    public double getCopperValue() {
        return copperValue;
    }

    public void setCopperValue(double copperValue) {
        this.copperValue = copperValue;
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
                ", gemstones=" + gemstones +
                ", material=" + material +
                ", materialWeight=" + materialWeight +
                ", productQuality=" + productQuality +
                ", goldValue=" + goldValue +
                ", silverValue=" + silverValue +
                ", copperValue=" + copperValue +
                '}';
    }
}
