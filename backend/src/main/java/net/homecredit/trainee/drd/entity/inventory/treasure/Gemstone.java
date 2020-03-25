package net.homecredit.trainee.drd.entity.inventory.treasure;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Gemstone {

    @Id
    private UUID id;
    private Integer weight;
    private Boolean polished;
    private Integer count;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private GemstoneBlueprint gemstoneBlueprint;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private TreasureBlueprint treasureBlueprint;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getPolished() {
        return polished;
    }

    public void setPolished(Boolean polished) {
        this.polished = polished;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GemstoneBlueprint getGemstoneBlueprint() {
        return gemstoneBlueprint;
    }

    public void setGemstoneBlueprint(GemstoneBlueprint gemstoneBlueprint) {
        this.gemstoneBlueprint = gemstoneBlueprint;
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
        if (!(o instanceof Gemstone)) return false;
        Gemstone gemStone = (Gemstone) o;
        return id.equals(gemStone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Gemstone{" +
                "id=" + id +
                ", weight=" + weight +
                ", polished=" + polished +
                ", count=" + count +
                ", price=" + price +
                ", gemstoneBlueprint=" + gemstoneBlueprint +
                '}';
    }
}
