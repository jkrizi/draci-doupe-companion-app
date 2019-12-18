package net.homecredit.trainee.drd.entity.inventory;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "STORAGE_UNIT")
public class StorageUnit extends Equipment{

    @Column(name = "STORAGE_CAPACITY")
    private int capacity;
    @Column(name = "CONTENT_WEIGHT")
    private int contentWeight;
    @Column(name = "DEFAULT_STORAGE")
    private boolean defaultStorage;

    @OneToMany(mappedBy = "storage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Equipment> equipment;

    @ManyToOne
    private Inventory inventory;

    public StorageUnit() {
    }

    public StorageUnit(String name, String description, int weight, int capacity, int contentWeight, boolean defaultStorage, Collection<Equipment> equipment, Inventory inventory) {
        super(name, description, weight);
        this.capacity = capacity;
        this.contentWeight = contentWeight;
        this.defaultStorage = defaultStorage;
        this.equipment = equipment;
        this.inventory = inventory;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getContentWeight() {
        return contentWeight;
    }

    public void setContentWeight(int contentWeight) {
        this.contentWeight = contentWeight;
    }

    public boolean isDefaultStorage() {
        return defaultStorage;
    }

    public void setDefaultStorage(boolean defaultStorage) {
        this.defaultStorage = defaultStorage;
    }

    public Collection<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Collection<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
