package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.util.Material;

import java.util.Collection;
import java.util.UUID;

public class TreasureBlueprintDto {

    private UUID id;
    private String name;
    private String publicDescription;
    private String privateDescription;
    private int weight;
    private Collection<GemstoneDto> gemstones;
    private Material material;
    private SkillKnowledge productQuality;
    private int materialWeight;
    private int goldCoins;
    private int silverCoins;
    private int copperCoins;

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

    public Collection<GemstoneDto> getGemstones() {
        return gemstones;
    }

    public void setGemstones(Collection<GemstoneDto> gemstones) {
        this.gemstones = gemstones;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public SkillKnowledge getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(SkillKnowledge productQuality) {
        this.productQuality = productQuality;
    }

    public int getMaterialWeight() {
        return materialWeight;
    }

    public void setMaterialWeight(int materialWeight) {
        this.materialWeight = materialWeight;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(int silverCoins) {
        this.silverCoins = silverCoins;
    }

    public int getCopperCoins() {
        return copperCoins;
    }

    public void setCopperCoins(int copperCoins) {
        this.copperCoins = copperCoins;
    }

    @Override
    public String toString() {
        return "TreasureBlueprintDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicDescription='" + publicDescription + '\'' +
                ", privateDescription='" + privateDescription + '\'' +
                ", gemstones=" + gemstones +
                ", material=" + material +
                ", productQuality=" + productQuality +
                ", materialWeight=" + materialWeight +
                ", goldCoins=" + goldCoins +
                ", silverCoins=" + silverCoins +
                ", copperCoins=" + copperCoins +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
