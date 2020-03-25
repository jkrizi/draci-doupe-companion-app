package net.homecredit.trainee.drd.controller.inventory;

import net.homecredit.trainee.drd.entity.shop.ItemType;

import java.util.UUID;

public class GoodsBlueprintDto {

    private UUID id;
    private String name;
    private String publicDescription;
    private String privateDescription;
    private int weight;
    private ItemType itemType;

    public GoodsBlueprintDto(UUID id, String name, String publicDescription, String privateDescription, int weight, ItemType itemType) {
        this.id = id;
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
        this.weight = weight;
        this.itemType = itemType;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
