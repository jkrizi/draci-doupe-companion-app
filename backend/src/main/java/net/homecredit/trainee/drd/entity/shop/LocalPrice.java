package net.homecredit.trainee.drd.entity.shop;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "LOCAL_PRICE")
public class LocalPrice {

    @Id
    private UUID id;

    private double price;
    private String dealLocation;

    @ManyToOne
    @JoinColumn(name = "SHOP_ITEM_ID")
    private ShopItem shopItem;

    public LocalPrice () {}

    public LocalPrice(UUID id, double price, String dealLocation, ShopItem shopItem) {
        this.id = UUID.randomUUID();
        this.price = price;
        this.dealLocation = dealLocation;
        this.shopItem = shopItem;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDealLocation() {
        return dealLocation;
    }

    public void setDealLocation(String dealLocation) {
        this.dealLocation = dealLocation;
    }

    public ShopItem getShopItem() {
        return shopItem;
    }

    public void setShopItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }
}
