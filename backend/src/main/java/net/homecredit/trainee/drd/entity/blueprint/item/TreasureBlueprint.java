package net.homecredit.trainee.drd.entity.blueprint.item;

import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;

import javax.persistence.*;
import java.util.UUID;

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

    @OneToOne(cascade = CascadeType.ALL)
    private GemStone gemStone;
    @Column(name = "STONE_WEIGHT")
    private int stoneWeight;

    private boolean polished;

    @Enumerated(EnumType.STRING)
    private Metal material;
    @Column(name = "MATERIAL_WEIGHT")
    private int materialWeight;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_QUALITY")
    private SkillKnowledge productQuality;

    @Column(name = "TREASURE_VALUE")
    private double treasureValue;

    public TreasureBlueprint() {
    }

    public TreasureBlueprint(String name, String publicDescription, String privateDescription, GemStone gemStone, int stoneWeight, boolean polished, Metal material, int materialWeight, SkillKnowledge productQuality, double treasureValue) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
        this.gemStone = gemStone;
        this.stoneWeight = stoneWeight;
        this.material = material;
        this.polished = polished;
        this.materialWeight = materialWeight;
        this.productQuality = productQuality;
        this.treasureValue = treasureValue;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int getWeight() {
        return getStoneWeight() + getMaterialWeight();
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

    public GemStone getGemStone() {
        return gemStone;
    }

    public void setGemStone(GemStone gemStone) {
        this.gemStone = gemStone;
    }

    public int getStoneWeight() {
        return stoneWeight;
    }

    public void setStoneWeight(int stoneWeight) {
        this.stoneWeight = stoneWeight;
    }

    public Metal getMaterial() {
        return material;
    }

    public void setMaterial(Metal material) {
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

    public boolean isPolished() {
        return polished;
    }

    public void setPolished(boolean polished) {
        this.polished = polished;
    }
}
