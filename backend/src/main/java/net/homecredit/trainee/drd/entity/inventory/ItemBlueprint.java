package net.homecredit.trainee.drd.entity.inventory;

import java.util.UUID;

public interface ItemBlueprint {

    String getName();

    String toString();

    UUID getId();

    int getWeight();

    String getPublicDescription();
}
