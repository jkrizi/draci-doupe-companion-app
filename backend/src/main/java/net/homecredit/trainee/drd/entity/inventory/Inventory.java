package net.homecredit.trainee.drd.entity.inventory;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
public class Inventory {

    @Id
    private UUID id;
    @Column(name = "limit_weight")
    private int limitWeight;
    @Column(name = "content_weight")
    private int contentWeight;
    @Column(name = "COIN_POUCH")
    private double coinPouch;
    @Column(name = "BANK_VAULT")
    private double bankVault;
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private Collection<StorageUnit> storageUnits;

    public Inventory() {
    }

    public Inventory(int limitWeight, int contentWeight, double coinPouch, double bankVault, Collection<StorageUnit> storageUnits) {
        this.id = UUID.randomUUID();
        this.limitWeight = limitWeight;
        this.contentWeight = contentWeight;
        this.coinPouch = coinPouch;
        this.bankVault = bankVault;
        this.storageUnits = storageUnits;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getLimitWeight() {
        return limitWeight;
    }

    public void setLimitWeight(int limitWeight) {
        this.limitWeight = limitWeight;
    }

    public int getContentWeight() {
        return contentWeight;
    }

    public void setContentWeight(int contentWeight) {
        this.contentWeight = contentWeight;
    }

    public double getCoinPouch() {
        return coinPouch;
    }

    public void setCoinPouch(double coinPouch) {
        this.coinPouch = coinPouch;
    }

    public double getBankVault() {
        return bankVault;
    }

    public void setBankVault(double bankVault) {
        this.bankVault = bankVault;
    }

    public Collection<StorageUnit> getStorageUnits() {
        return storageUnits;
    }

    public void setStorageUnits(Collection<StorageUnit> storageUnits) {
        this.storageUnits = storageUnits;
    }

    //JZ-getter without attribute
    public int getFreeSpace(){
        return getLimitWeight() - getContentWeight();
    }
}
