package net.homecredit.trainee.drd.entity.inventory;

import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.UUID;

@Entity
public class GemStone {

    @Id
    private UUID id;
    private int stoneWeight;
    private boolean polished;

    private double stonePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private GemstoneBlueprint gemStoneBlueprint;

    @ManyToOne(fetch = FetchType.LAZY)
    private TreasureBlueprint treasureBlueprint;

    public GemStone() {}

    public GemStone(int stoneWeight, boolean polished, double stonePrice, GemstoneBlueprint gemStoneBlueprint) {
        this.id = UUID.randomUUID();
        this.stoneWeight = stoneWeight;
        this.polished = polished;
        this.stonePrice = stonePrice;
        this.gemStoneBlueprint = gemStoneBlueprint;
    }

    public GemStone(int stoneWeight, boolean polished, double stonePrice, GemstoneBlueprint gemStoneBlueprint, TreasureBlueprint treasureBlueprint) {
        this.id = UUID.randomUUID();
        this.stoneWeight = stoneWeight;
        this.polished = polished;
        this.stonePrice = stonePrice;
        this.gemStoneBlueprint = gemStoneBlueprint;
        this.treasureBlueprint = treasureBlueprint;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getStoneWeight() {
        return stoneWeight;
    }

    public void setStoneWeight(int stoneWeight) {
        this.stoneWeight = stoneWeight;
    }

    public boolean isPolished() {
        return polished;
    }

    public void setPolished(boolean polished) {
        this.polished = polished;
    }

    public double getStonePrice() {
        return stonePrice;
    }

    public void setStonePrice(double stonePrice) {
        this.stonePrice = stonePrice;
    }

    public GemstoneBlueprint getGemStoneBlueprint() {
        return gemStoneBlueprint;
    }

    public void setGemStoneBlueprint(GemstoneBlueprint gemStoneBlueprint) {
        this.gemStoneBlueprint = gemStoneBlueprint;
    }

    public TreasureBlueprint getTreasureBlueprint() {
        return treasureBlueprint;
    }

    public void setTreasureBlueprint(TreasureBlueprint treasureBlueprint) {
        this.treasureBlueprint = treasureBlueprint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GemStone)) return false;
        GemStone gemStone = (GemStone) o;
        return id.equals(gemStone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GemStone{" +
                " stoneWeight=" + stoneWeight +
                ", polished=" + polished +
                ", stonePrice=" + stonePrice +
                ", gemStoneBlueprint=" + gemStoneBlueprint +
                '}';
    }
}
