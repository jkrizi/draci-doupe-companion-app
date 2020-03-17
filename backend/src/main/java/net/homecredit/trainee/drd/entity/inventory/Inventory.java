package net.homecredit.trainee.drd.entity.inventory;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Inventory {

    @Id
    private UUID id;
    private int limitWeight;
    private int contentWeight;
    private double coinPouch;
    private double bankVault;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private Set<StorageUnit> storageUnits;

    public Inventory() {
    }

    public Inventory(int limitWeight, int contentWeight, double coinPouch, double bankVault, Set<StorageUnit> storageUnits) {
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

    public Set<StorageUnit> getStorageUnits() {
        return storageUnits;
    }

    public void setStorageUnits(Set<StorageUnit> storageUnits) {
        this.storageUnits = storageUnits;
    }

    //JZ-getter without attribute
    public int getFreeSpace() {
        return getLimitWeight() - getContentWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return id.equals(inventory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", limitWeight=" + limitWeight +
                ", contentWeight=" + contentWeight +
                ", coinPouch=" + coinPouch +
                ", bankVault=" + bankVault +
                ", storageUnits=" + storageUnits +
                '}';
    }
}
