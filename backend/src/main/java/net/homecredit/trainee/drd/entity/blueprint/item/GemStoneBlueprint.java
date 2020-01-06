package net.homecredit.trainee.drd.entity.blueprint.item;

import net.homecredit.trainee.drd.util.Color;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class GemStoneBlueprint {

    @Id
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Color color;
    private double unitPrice;

    public GemStoneBlueprint() {
    }

    public GemStoneBlueprint(String name, Color color, double unitPrice) {
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
}
