package net.homecredit.trainee.drd.entity.inventory.goods;

import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintGoodsBlueprint;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "GOODS_BLUEPRINT")
public class GoodsBlueprint implements ItemBlueprint {

    @Id
    private UUID id;
    private String name;
    private String publicDescription;
    private String privateDescription;
    private int weight;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsBlueprint)) return false;
        GoodsBlueprint that = (GoodsBlueprint) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GoodsBlueprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicDescription='" + publicDescription + '\'' +
                ", privateDescription='" + privateDescription + '\'' +
                ", weight=" + weight +
                ", itemType=" + itemType +
                '}';
    }
}
