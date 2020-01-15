package net.homecredit.trainee.drd.entity.shop;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "SHOP_ITEM")
public class ShopItem {

    @Id
    private UUID id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "ITEM_TYPE")
    private ItemType itemType;

    @OneToMany(mappedBy = "shopItem", orphanRemoval = true)
    private Collection<LocalPrice> priceList;

    @Column(name = "BLUEPRINT_ID")
    private UUID blueprintId;

    public ShopItem() {
    }

    public ShopItem(String name, String description, ItemType itemType, Collection<LocalPrice> priceList, UUID blueprintId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.priceList = priceList;
        this.blueprintId = blueprintId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Collection<LocalPrice> getPriceList() {
        return priceList;
    }

    public void setPriceList(Collection<LocalPrice> priceList) {
        this.priceList = priceList;
    }

    public UUID getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(UUID blueprintId) {
        this.blueprintId = blueprintId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopItem)) return false;
        ShopItem shopItem = (ShopItem) o;
        return id.equals(shopItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", itemType=" + itemType +
                ", priceList=" + priceList +
                ", blueprintId=" + blueprintId +
                '}';
    }
}
