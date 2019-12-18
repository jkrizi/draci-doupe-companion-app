package net.homecredit.trainee.drd.entity.inventory;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Equipment {

    @Id
    private UUID id;
    private String name;
    private String description;
    private int weight;
    @ManyToOne
    @JoinColumn(name = "storage_unit_id")
    private StorageUnit storage;

    public Equipment() {
    }

    /**
     * Used for initialization of base Storage Units
     * These may not be included in other Storage Units and have no CoinValue
     */
    public Equipment(String name, String description, int weight) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public Equipment(String name, String description, int weight, StorageUnit storage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.storage = storage;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public StorageUnit getStorage() {
        return storage;
    }

    public void setStorage(StorageUnit storage) {
        this.storage = storage;
    }
}
