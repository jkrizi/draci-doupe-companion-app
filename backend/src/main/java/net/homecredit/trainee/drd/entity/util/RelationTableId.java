package net.homecredit.trainee.drd.entity.util;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class RelationTableId implements Serializable {

    private UUID ownerId;
    private UUID ownedId;

    public UUID getOwnerId() {
        return ownerId;
    }

    public RelationTableId() {}

    public RelationTableId(UUID ownerId, UUID ownedId) {
        this.ownerId = ownerId;
        this.ownedId = ownedId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public UUID getOwnedId() {
        return ownedId;
    }

    public void setOwnedId(UUID ownedId) {
        this.ownedId = ownedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelationTableId that = (RelationTableId) o;

        if (!ownerId.equals(that.ownerId)) return false;
        return ownedId.equals(that.ownedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, ownedId);
    }
}
