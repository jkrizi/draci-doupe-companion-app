package net.homecredit.trainee.drd.util;

import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import org.springframework.context.ApplicationEvent;

public class StorageEvent extends ApplicationEvent {
    private StorageUnit storageUnit;
    private int weight;

    public StorageEvent(StorageUnit storageUnit, int weight) {
        super(storageUnit);
        this.storageUnit = storageUnit;
        this.weight = weight;
    }

    public StorageUnit getStorageUnit() {
        return storageUnit;
    }

    public int getWeight() {
        return weight;
    }
}
