package net.homecredit.trainee.drd.controller.dto;

import java.util.Collection;
import java.util.UUID;

public class TreasureBlueprintDto {

    private UUID id;
    private String name;
    private String publicDescription;
    private String privateDescription;
    private Collection<GemStoneDto> gemStones;
    private MaterialDto material;
    private String goldCoins;
    private String silverCoins;
    private String copperCoins;

    public TreasureBlueprintDto(UUID id, String name, String publicDescription, String privateDescription,
                                Collection<GemStoneDto> gemStones, MaterialDto material,
                                String goldCoins, String silverCoins, String copperCoins) {
        this.id = id;
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
        this.gemStones = gemStones;
        this.material = material;
        this.goldCoins = goldCoins.isEmpty()? "0":goldCoins;
        this.silverCoins = silverCoins.isEmpty()? "0":silverCoins;
        this.copperCoins = copperCoins.isEmpty()? "0":copperCoins;
    }

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

    public Collection<GemStoneDto> getGemStones() {
        return gemStones;
    }

    public void setGemStones(Collection<GemStoneDto> gemStones) {
        this.gemStones = gemStones;
    }

    public MaterialDto getMaterial() {
        return material;
    }

    public void setMaterial(MaterialDto material) {
        this.material = material;
    }

    public String getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(String goldCoins) {
        this.goldCoins = goldCoins;
    }

    public String getSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(String silverCoins) {
        this.silverCoins = silverCoins;
    }

    public String getCopperCoins() {
        return copperCoins;
    }

    public void setCopperCoins(String copperCoins) {
        this.copperCoins = copperCoins;
    }

    @Override
    public String toString() {
        return "TreasureBlueprintDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicDescription='" + publicDescription + '\'' +
                ", privateDescription='" + privateDescription + '\'' +
                ", gemStones=" + gemStones +
                ", material='" + material + '\'' +
                ", goldCoins=" + goldCoins +
                ", silverCoins=" + silverCoins +
                ", copperCoins=" + copperCoins +
                '}';
    }
}
