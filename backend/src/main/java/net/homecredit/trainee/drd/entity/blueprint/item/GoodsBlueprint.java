package net.homecredit.trainee.drd.entity.blueprint.item;

import net.homecredit.trainee.entity.shop.ItemType;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "GOODS_BLUEPRINT")
public class GoodsBlueprint implements ItemBlueprint {

    @Id
    private UUID id;
    private String name;
    @Column(name = "PUBLIC_DESCRIPTION")
    private String publicDescription;
    @Column(name = "PRIVATE_DESCRIPTION")
    private String privateDescription;

    private int weight;
    @Enumerated(EnumType.STRING)
    @Column(name = "ITEM_TYPE")
    private ItemType itemType;

    public GoodsBlueprint () {}

    public GoodsBlueprint(String name, String publicDescription, String privateDescription, int weight, ItemType itemType) {
        this.id = UUID.randomUUID();
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

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
