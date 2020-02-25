package net.homecredit.trainee.drd.entity.blueprint.item;

import net.homecredit.trainee.drd.util.Color;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class GemstoneBlueprint {

    @Id
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Color color;
    private double unitPrice;

    public GemstoneBlueprint() {
    }

    public GemstoneBlueprint(String name, Color color, double unitPrice) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.color = color;
        this.unitPrice = unitPrice;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GemstoneBlueprint)) return false;
        GemstoneBlueprint that = (GemstoneBlueprint) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GemstoneBlueprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
